import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AppComponent } from '../../../app.component';

@Component({
  selector: 'app-mcqresult',
  templateUrl: './mcqresult.component.html',
  styleUrl: './mcqresult.component.css'
})
export class McqresultComponent {

  constructor(public http:HttpClient, public app:AppComponent){ this.loadResults();}
    
      results:any[]=[];
      component='MCQ'
    
      loadResults(){
        let url=this.app.baseUrl+'giveResultsByCategory'+this.component;
        this.http.get(url).subscribe((data:any)=>
        {
            this.results=data;
        }
        );
    
      }
}
