import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AppComponent } from '../../../app.component';
import { StudentComponent } from '../../student.component';

@Component({
  selector: 'app-gtoresultstu',
  templateUrl: './gtoresultstu.component.html',
  styleUrl: './gtoresultstu.component.css'
})
export class GtoresultstuComponent {
   constructor(public http:HttpClient, public app:AppComponent, public student:StudentComponent){ this.loadResults();}
      
        results:any[]=[];
        component='GTO'
      
        loadResults(){
          let url=this.app.baseUrl+'giveTestsByCategoryAndId'+this.component+'and'+this.app.userid;
          this.http.get(url).subscribe((data:any)=>
          {
              this.results=data;
          }
          );
      
        }
}
