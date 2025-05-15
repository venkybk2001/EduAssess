import { Component, ViewChild, ElementRef } from '@angular/core';
import { StudentComponent } from '../student.component';
import { HttpClient } from '@angular/common/http';
import { AppComponent } from '../../app.component';

@Component({
  selector: 'app-attemptgtotest',
  templateUrl: './attemptgtotest.component.html',
  styleUrl: './attemptgtotest.component.css'
})
export class AttemptgtotestComponent {
  constructor(
    public student: StudentComponent,
    public http: HttpClient,
    public app: AppComponent
  ) {}

  showIndex: number = -1;

  @ViewChild('answerSection') answerSection!: ElementRef;

  load(i: number) {
    this.showIndex = i;

    // Delay scroll to ensure DOM is updated
    setTimeout(() => {
      if (this.answerSection) {
        this.answerSection.nativeElement.scrollIntoView({ behavior: 'smooth' });
      }
    }, 100);
  }

  submit() {
    const url = this.app.baseUrl + 'submitGto' + this.student.logs[this.showIndex].id;
    this.http.post(url, this.student.logs[this.showIndex].answer).subscribe((data: any) => {
      if (data == null || data == 0) {
        window.alert('Something is wrong');
      } else if (data == 2) {
        window.alert('Output Not Correct');
      } else {
        this.student.logs[this.showIndex].submit = 1;
        window.alert('Done');
      }
    });
  }

  back() {
    this.student.section = 3;
    this.student.whatToShow = 5;
  }
}
