import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router'; 

@Component({
  selector: 'app-video-player',
  templateUrl: './video-player.component.html',
  styleUrl: './video-player.component.css'
})
export class VideoPlayerComponent implements OnInit{

  sessionName: string = '';
  sessionLink: string = '';

  constructor(private route: ActivatedRoute, private router: Router, ) {}

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this.sessionName = params['name'];
      this.sessionLink = params['link'];
    });
  }

  goBack() {
    this.router.navigate(['/']);
  }
}
