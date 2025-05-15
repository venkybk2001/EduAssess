import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AppComponent } from '../../app.component';
import { StudentComponent } from '../student.component';

@Component({
  selector: 'app-showtest',
  templateUrl: './showtest.component.html',
  styleUrls: ['./showtest.component.css'] // Fixed typo: styleUrl → styleUrls
})
export class ShowtestComponent {

  tests: any;
  theSection = 'WRITTEN';

  constructor(
    public http: HttpClient,
    public app: AppComponent,
    public student: StudentComponent
  ) {
    let url = this.app.baseUrl + 'giveActiveTests' + this.theSection;
    this.http.get(url).subscribe((data: any) => {
      if (data != null) {
        this.tests = data;
      } else {
        alert("No test added by the admin");
      }
    });
  }

  attempt(test: any) {
    let url = this.app.baseUrl + 'giveMeTestLogs' + this.app.userid + 'and' + test.id + 'and' + this.theSection;
    this.http.get(url).subscribe((data: any) => {
      this.student.logs = data;
      this.student.whatToShow = 2;
    });
  }

  // ✅ Add this function to fix the error
  goToDashboard(): void {
    this.student.whatToShow = 0; // Or whatever value you use to show the dashboard
  }
}
