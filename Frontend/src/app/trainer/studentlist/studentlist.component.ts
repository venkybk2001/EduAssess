import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AppComponent } from '../../app.component';

@Component({
  selector: 'app-studentlist',
  templateUrl: './studentlist.component.html',
  styleUrl: './studentlist.component.css'
})
export class StudentlistComponent {

  constructor(public http:HttpClient, public app:AppComponent){}

  students:any[]=[];

  loadStudents(){
    let url=this.app.baseUrl+'studentList';
    this.http.get(url).subscribe((data:any)=>
    {
        this.students=data;
    }
    );

  }

  delete(student:any)
  {
    let url=this.app.baseUrl+'deleteStudent'+student.id;
    this.http.get(url).subscribe((data:any)=>
    {
      if(data==1)
      {
        let index=this.students.indexOf(student);
        if(index>=0)
        {
          this.students.splice(index,1);
        }
      }
      else{
        alert('Exception on server')
      }
    }
    );
  }


  toggleStatus(student: any): void {
    let url=this.app.baseUrl;
    if (student.activeStatus === 0) {
      url=url+'activateStudent'+student.id;
      this.http.get(url).subscribe((data:any)=>
        {
          if(data==1){
            this.loadStudents();
            alert('Student Activated')
          }else{
            alert('Exception on server')
          }
        });
    } else if (student.activeStatus === 1) {
      url=url+'deactiveStudent'+student.id;
      this.http.get(url).subscribe((data:any)=>
        {
          if(data==1){
            this.loadStudents();
            alert('Student Dectivated')
          }else{
            alert('Exception on server')
          }
        });
    }
  }

}
