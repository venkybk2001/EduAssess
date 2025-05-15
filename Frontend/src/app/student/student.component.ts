import { Component } from '@angular/core';
import { AppComponent } from '../app.component';

@Component({
    selector: 'app-student',
    templateUrl: './student.component.html',
    styleUrls: ['./student.component.css']
})
export class StudentComponent {
    whatToShow: number = 0;
    section: number = 0; // 1 - Written, 2 - MCQ, 3 - GTO, 4 - Video, 5-Result

    constructor(public app: AppComponent) {}

    logs:any;

    logout() {
        this.app.isLoggedIn = 0;
    }

    changeSection(num: number) {
        this.section = num;
        const sectionMapping: { [key: number]: number } = {
            1: 1, // Show Test
            2: 3, // Show MCQ Test
            3: 5, // Show GTO Test
            4: 7, // Video Sessions
            5: 9  //result section
        };
        this.whatToShow = sectionMapping[num] || 1;
    }
}
