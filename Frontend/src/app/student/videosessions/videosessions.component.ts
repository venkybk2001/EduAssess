import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';
import { AppComponent } from '../../app.component';

@Component({
  selector: 'app-videosessions',
  templateUrl: './videosessions.component.html',
  styleUrls: ['./videosessions.component.css']
})
export class VideosessionsComponent {
  constructor(public http: HttpClient, public app: AppComponent, private sanitizer: DomSanitizer) {}

  videosessions: any[] = [];
  videoUrl: SafeResourceUrl | null = null;
  isYouTube: boolean = false;
  selectedVideoDescription: string = '';
  searchText: string = '';

  load() {
    const url = this.app.baseUrl + 'getAllVideos';
    this.http.get<any[]>(url).subscribe((data) => {
      this.videosessions = data;
    });
  }

  view(videosession: any) {
    const link = videosession.sessionLink.trim();
    this.selectedVideoDescription = videosession.sessionDescription || 'No description available';

    if (link.includes("youtube.com") || link.includes("youtu.be")) {
      this.isYouTube = true;
      const videoId = this.extractYouTubeId(link);
      this.videoUrl = this.sanitizer.bypassSecurityTrustResourceUrl(`https://www.youtube.com/embed/${videoId}`);
    } else {
      this.isYouTube = false;
      this.videoUrl = this.sanitizer.bypassSecurityTrustResourceUrl(link);
    }

    setTimeout(() => {
      const videoPreview = document.querySelector('.video-preview');
      if (videoPreview) {
        videoPreview.scrollIntoView({ behavior: 'smooth', block: 'center' });
      }
    }, 100);
  }

  resetVideo() {
    this.videoUrl = null;
    this.selectedVideoDescription = '';
  }

  extractYouTubeId(url: string): string {
    const regex = /(?:youtube\.com\/(?:[^\/]+\/.+\/|(?:v|e(?:mbed)?)\/|.*[?&]v=)|youtu\.be\/)([^"&?\/\s]+)/;
    const match = url.match(regex);
    return match && match[1] ? match[1] : '';
  }

  filteredVideos() {
    if (!this.searchText) return this.videosessions;
    return this.videosessions.filter(video =>
      video.sessionName.toLowerCase().includes(this.searchText.toLowerCase())
    );
  }

  toggleWatched(link: string) {
    const watchedVideos = JSON.parse(localStorage.getItem('watchedVideos') || '[]');
    const index = watchedVideos.indexOf(link);
    if (index > -1) {
      watchedVideos.splice(index, 1);
    } else {
      watchedVideos.push(link);
    }
    localStorage.setItem('watchedVideos', JSON.stringify(watchedVideos));
  }

  isWatched(link: string): boolean {
    const watchedVideos = JSON.parse(localStorage.getItem('watchedVideos') || '[]');
    return watchedVideos.includes(link);
  }

  getThumbnail(link: string): string | null {
    if (link.includes('youtube.com') || link.includes('youtu.be')) {
      const id = this.extractYouTubeId(link);
      return `https://img.youtube.com/vi/${id}/0.jpg`;
    }
    return null; // No thumbnail for MP4
  }
}
