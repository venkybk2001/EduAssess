import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AppComponent } from '../../app.component';
@Component({
  selector: 'app-questionmgmt',
  templateUrl: './questionmgmt.component.html',
  styleUrl: './questionmgmt.component.css'
})


export class QuestionmgmtComponent 
{

  whatToShow:number=0;
  changeWhatToShow(num:number)
  {
    this.whatToShow=num;
  }
}


