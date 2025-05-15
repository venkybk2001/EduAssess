import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VideoPlayerComponent } from './video-player/video-player.component';
import { AddvideosessionsComponent } from './trainer/addvideosessions/addvideosessions.component';

const routes: Routes = [
  { path: 'video-player', component: VideoPlayerComponent },
  {path: '', component: AddvideosessionsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
