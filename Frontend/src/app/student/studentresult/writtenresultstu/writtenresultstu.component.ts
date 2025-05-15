import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AppComponent } from '../../../app.component';

@Component({
  selector: 'app-writtenresultstu',
  templateUrl: './writtenresultstu.component.html',
  styleUrl: './writtenresultstu.component.css'
})
export class WrittenresultstuComponent {
   constructor(public http:HttpClient, public app:AppComponent){ this.loadResults();}
    
      results:any[]=[];
      component='WRITTEN'
    
      loadResults(){
        let url=this.app.baseUrl+'giveTestsByCategoryAndId'+this.component+'and'+this.app.userid;
        this.http.get(url).subscribe((data:any)=>
        {
            this.results=data;
        }
        );
    
      }
}
