import { Component } from '@angular/core';

@Component({
  selector: 'app-studentresult',
  templateUrl: './studentresult.component.html',
  styleUrl: './studentresult.component.css'
})
export class StudentresultComponent {

  showTabNo=0;
  changeResultShow(num:number){
      this.showTabNo=num;
  }
}
