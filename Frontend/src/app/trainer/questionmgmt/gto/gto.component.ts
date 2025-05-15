import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AppComponent } from '../../../app.component';

@Component({
  selector: 'app-gto',
  templateUrl: './gto.component.html',
  styleUrl: './gto.component.css'
})
export class GtoComponent {

  constructor(public http:HttpClient, public app:AppComponent){}
    
  gtos:any[]=[];

  newGto = {
    code: '',
    output: ''
  };

  addGtoQuestion() {
    let url=this.app.baseUrl+'addGTO';
    this.http.post(url, this.newGto).subscribe((data:any)=>
      {
        if(data==1){
          alert("GTO Added");
        }  
      }
      );
      this.newGto = {
        code: '',
        output: ''
      };
  }

  load()
    {
      let url=this.app.baseUrl+'giveGTO';
      this.http.get(url).subscribe((data:any)=>
      {
          this.gtos=data;
      }
      );
    }

  delete(gto:any){
    let url=this.app.baseUrl+'deleteGTO'+gto.id;
      this.http.get(url).subscribe((data:any)=>
      {
        if(data==1)
        {
          let index=this.gtos.indexOf(gto);
          if(index>=0)
          {
            this.gtos.splice(index,1);
          }
        }
        else{
          alert('Exception on server')
        }
      }
      );
  }
    
      

}
