import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AppComponent } from '../../../app.component';

@Component({
  selector: 'app-mcq',
  templateUrl: './mcq.component.html',
  styleUrl: './mcq.component.css'
})
export class McqComponent {

  constructor(public http:HttpClient, public app:AppComponent){}
    
  mcqs:any[]=[];

  que:string='';
  newQuestion = {
    category: '',
    que: '',
    optA: '', optB: '', optC: '', optD: '',
    ans: '',
  };
    
  addQuestion() {
    let url=this.app.baseUrl+'addMCQ';
    this.http.post(url, this.newQuestion).subscribe((data:any)=>
      {
        if(data==1){
          alert("MCQ Added");
        }  
      }
      );
      this.newQuestion = {
        category: '',
        que: '',
        optA: '', optB: '', optC: '', optD: '',
        ans: '',
      }; 
  }

  load(){
      let url=this.app.baseUrl+'giveMCQ';
      this.http.get(url).subscribe((data:any)=>
      {
          this.mcqs=data;
      }
      );
    }

  delete(mcq:any){
    let url=this.app.baseUrl+'deleteMCQ'+mcq.id;
      this.http.get(url).subscribe((data:any)=>
      {
        if(data==1)
        {
          let index=this.mcqs.indexOf(mcq);
          if(index>=0)
          {
            this.mcqs.splice(index,1);
          }
        }
        else{
          alert('Exception on server')
        }
      }
      );
  }


}
