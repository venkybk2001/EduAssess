import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AppComponent } from '../../../app.component';

@Component({
  selector: 'app-mcqresultstu',
  templateUrl: './mcqresultstu.component.html',
  styleUrl: './mcqresultstu.component.css'
})
export class McqresultstuComponent {

   constructor(public http:HttpClient, public app:AppComponent){ this.loadResults();}
      
        results:any[]=[];
        component='MCQ'
      
        loadResults(){
          let url=this.app.baseUrl+'giveTestsByCategoryAndId'+this.component+'and'+this.app.userid;
          this.http.get(url).subscribe((data:any)=>
          {
              this.results=data;
          }
          );
      
        }
}
