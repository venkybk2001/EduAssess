import { Component } from '@angular/core';

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrl: './result.component.css'
})
export class ResultComponent {

  showTabNo=0;
  changeResultShow(num:number){
      this.showTabNo=num;
  }
}
