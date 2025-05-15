import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AppComponent } from '../../../app.component';

@Component({
  selector: 'app-gtoresult',
  templateUrl: './gtoresult.component.html',
  styleUrl: './gtoresult.component.css'
})
export class GtoresultComponent {

  constructor(public http:HttpClient, public app:AppComponent){ this.loadResults();}
    
      results:any[]=[];
      component='GTO'
    
      loadResults(){
        let url=this.app.baseUrl+'giveResultsByCategory'+this.component;
        this.http.get(url).subscribe((data:any)=>
        {
            this.results=data;
        }
        );
    
      }
}
