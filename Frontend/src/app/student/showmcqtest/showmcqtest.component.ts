import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AppComponent } from '../../app.component';
import { StudentComponent } from '../student.component';

@Component({
  selector: 'app-showmcqtest',
  templateUrl: './showmcqtest.component.html',
  styleUrl: './showmcqtest.component.css'
})
export class ShowmcqtestComponent {

  tests:any;
  theSection='MCQ';

  constructor(public http:HttpClient, public app:AppComponent, public student:StudentComponent)
  {
    let url=this.app.baseUrl+'giveActiveTests'+this.theSection;
    this.http.get(url).subscribe((data:any)=>
    {
      if(data!=null){
        this.tests=data;
      }else{
        alert("No test added by the admin");
      }
      
    }
    );
  }

  attempt(test:any)
  {
    let url=this.app.baseUrl+'giveMeTestLogs'+this.app.userid+'and'+test.id+'and'+this.theSection
    this.http.get(url).subscribe((data:any)=>
    {
      this.student.logs=data;
      this.student.whatToShow=4;
    }
    );
  }


}
