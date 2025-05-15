import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AppComponent } from '../../app.component';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';

@Component({
  selector: 'app-addvideosessions',
  templateUrl: './addvideosessions.component.html',
  styleUrls: ['./addvideosessions.component.css']
})
export class AddvideosessionsComponent {
  searchQuery: any;

  constructor(public http: HttpClient, public app: AppComponent, private sanitizer: DomSanitizer) {}

  videosessions: any[] = [];
  sessionName: string = '';
  sessionDescription: string = '';
  sessionLink: string = '';
  videoUrl: SafeResourceUrl | null = null; 
  isYouTube: boolean = false; 
  selectedVideoDescription: string = '';

  load() {
    let url = this.app.baseUrl + 'getAllVideos';
    this.http.get(url).subscribe((data: any) => {
      this.videosessions = data;
      console.log('Videos Loaded:', this.videosessions); // Debugging Log
    });
  }
  

  add() {
    let obj = {
      "sessionName": this.sessionName,
      "sessionLink": this.sessionLink,
      "sessionDescription": this.sessionDescription
    };

    let url = this.app.baseUrl + 'addVideo';
    this.http.post(url, obj).subscribe((data: any) => {
      console.log('Video added:', data);
      this.videosessions.push(data);
      this.sessionName = '';
      this.sessionDescription = ''; // Reset description
      this.sessionLink = '';
    });
  }

  delete(videosession: any) {
    let url = this.app.baseUrl + 'deleteVideo' + videosession.id;
    this.http.get(url).subscribe((data: any) => {
      if (data == 1) {
        let index = this.videosessions.indexOf(videosession);
        if (index >= 0) {
          this.videosessions.splice(index, 1);
        }
      } else {
        alert('Exception on server');
      }
    });
  }

  view(videosession: any) {
    let link = videosession.sessionLink.trim();
    this.selectedVideoDescription = videosession.sessionDescription ? videosession.sessionDescription : 'No description available';
   
   
    if (link.includes("youtube.com") || link.includes("youtu.be")) {
      // Convert YouTube link into an embeddable format
      this.isYouTube = true;
      let videoId = this.extractYouTubeId(link);
      this.videoUrl = this.sanitizer.bypassSecurityTrustResourceUrl(`https://www.youtube.com/embed/${videoId}`);
    } else {
      // Direct MP4 video
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

  filteredVideos() {
    if (!this.searchQuery) return this.videosessions;
        return this.videosessions.filter(video =>
           video.sessionName.toLowerCase().includes(this.searchQuery.toLowerCase())
    );
    }
    

  extractYouTubeId(url: string): string {
    let videoId = '';
    const regex = /(?:youtube\.com\/(?:[^\/]+\/.+\/|(?:v|e(?:mbed)?)\/|.*[?&]v=)|youtu\.be\/)([^"&?\/\s]+)/;
    const match = url.match(regex);
    if (match && match[1]) {
      videoId = match[1];
    }
    return videoId;
  }

  resetVideo() {
    this.videoUrl = null;
    this.selectedVideoDescription = ''; // Reset description on close
  }
}
