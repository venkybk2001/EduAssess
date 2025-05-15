import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AppComponent } from '../../../app.component';

@Component({
  selector: 'app-writtenquestion',
  templateUrl: './writtenquestion.component.html',
  styleUrl: './writtenquestion.component.css'
})
export class WrittenquestionComponent {

  
  
    constructor(public http:HttpClient, public app:AppComponent){}
  
    questions:any[]=[];
    name:string='';
  
    load()
    {
      let url=this.app.baseUrl+'giveQuestion';
      this.http.get(url).subscribe((data:any)=>
      {
          this.questions=data;
      }
      );
    }
  
        
  
    add()
    {
      let url=this.app.baseUrl+'addQuestion';
      this.http.post(url, this.name).subscribe((data:any)=>
      {
         this.questions.push(data);
      }
      );
      this.emptyField();
    }
  
    emptyField(){
        this.name = '';
      }
  
    delete(question:any)
    {
      let url=this.app.baseUrl+'delete'+question.id;
      this.http.get(url).subscribe((data:any)=>
      {
        if(data==1)
        {
          let index=this.questions.indexOf(question);
          if(index>=0)
          {
            this.questions.splice(index,1);
          }
        }
        else{
          alert('Exception on server')
        }
      }
      );
    }
  
}
