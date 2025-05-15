import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AppComponent } from '../../../app.component';

@Component({
  selector: 'app-writtenresult',
  templateUrl: './writtenresult.component.html',
  styleUrl: './writtenresult.component.css'
})
export class WrittenresultComponent {

  constructor(public http:HttpClient, public app:AppComponent){ this.loadResults();}
  
    results:any[]=[];
    component='WRITTEN'
  
    loadResults(){
      let url=this.app.baseUrl+'giveResultsByCategory'+this.component;
      this.http.get(url).subscribe((data:any)=>
      {
          this.results=data;
      }
      );
  
    }
}
