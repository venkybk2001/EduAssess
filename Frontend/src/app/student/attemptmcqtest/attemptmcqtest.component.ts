import { Component } from '@angular/core';
import { StudentComponent } from '../student.component';
import { HttpClient } from '@angular/common/http';
import { AppComponent } from '../../app.component';

@Component({
  selector: 'app-attemptmcqtest',
  templateUrl: './attemptmcqtest.component.html',
  styleUrl: './attemptmcqtest.component.css'
})
export class AttemptmcqtestComponent {
    
      constructor(public student:StudentComponent, public http:HttpClient, public app:AppComponent){}
    
      showIndex:number=-1;
      load(i:number)
      {
          this.showIndex=i;
      }
      

      submit()
      {
        let url=this.app.baseUrl+'submitMcq'+this.student.logs[this.showIndex].id;
        this.http.post(url, this.student.logs[this.showIndex].answer).subscribe((data:any)=>
        {
          if(data==null || data==0)
          {
            window.alert('Something is wrong')
          }
          else
          {
            this.student.logs[this.showIndex].submit=1;
            window.alert('Done');
          }
        }
        )
      }
    
    
    
      back(){
        this.student.section=2
        this.student.whatToShow=3;
      }
    


}
