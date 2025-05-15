import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, provideHttpClient, withFetch } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { StudentComponent } from './student/student.component';
import { TrainerComponent } from './trainer/trainer.component';
import { AttempttestComponent } from './student/attempttest/attempttest.component';
import { ShowtestComponent } from './student/showtest/showtest.component';
import { QuestionmgmtComponent } from './trainer/questionmgmt/questionmgmt.component';
import { TestmgmtComponent } from './trainer/testmgmt/testmgmt.component';
import { AnswerverificationComponent } from './trainer/answerverification/answerverification.component';
import { FormsModule } from '@angular/forms';
import { RegistrationComponent } from './trainer/registration/registration.component';
import { StudentlistComponent } from './trainer/studentlist/studentlist.component';
import { WrittenquestionComponent } from './trainer/questionmgmt/writtenquestion/writtenquestion.component';
import { McqComponent } from './trainer/questionmgmt/mcq/mcq.component';
import { GtoComponent } from './trainer/questionmgmt/gto/gto.component';
import { AttemptmcqtestComponent } from './student/attemptmcqtest/attemptmcqtest.component';
import { AttemptgtotestComponent } from './student/attemptgtotest/attemptgtotest.component';
import { ShowmcqtestComponent } from './student/showmcqtest/showmcqtest.component';
import { ShowgtotestComponent } from './student/showgtotest/showgtotest.component';
import { WrittenresultComponent } from './trainer/result/writtenresult/writtenresult.component';
import { McqresultComponent } from './trainer/result/mcqresult/mcqresult.component';
import { GtoresultComponent } from './trainer/result/gtoresult/gtoresult.component';
import { ResultComponent } from './trainer/result/result.component';
import { AddvideosessionsComponent } from './trainer/addvideosessions/addvideosessions.component';
import { VideoPlayerComponent } from './video-player/video-player.component';
import { SafeUrlPipe } from './safe-url.pipe';
import { RouterModule } from '@angular/router';
import { VideosessionsComponent } from './student/videosessions/videosessions.component';
import { StudentresultComponent } from './student/studentresult/studentresult.component';
import { WrittenresultstuComponent } from './student/studentresult/writtenresultstu/writtenresultstu.component';
import { GtoresultstuComponent } from './student/studentresult/gtoresultstu/gtoresultstu.component';
import { McqresultstuComponent } from './student/studentresult/mcqresultstu/mcqresultstu.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    StudentComponent,
    TrainerComponent,
    AttempttestComponent,
    ShowtestComponent,
    QuestionmgmtComponent,
    TestmgmtComponent,
    AnswerverificationComponent,
    RegistrationComponent,
    StudentlistComponent,
    WrittenquestionComponent,
    McqComponent,
    GtoComponent,
    AttemptmcqtestComponent,
    AttemptgtotestComponent,
    ShowmcqtestComponent,
    ShowgtotestComponent,
    WrittenresultComponent,
    McqresultComponent,
    GtoresultComponent,
    ResultComponent,
    AddvideosessionsComponent,
    VideoPlayerComponent,
    SafeUrlPipe,
    VideosessionsComponent,
    StudentresultComponent,
    WrittenresultstuComponent,
    GtoresultstuComponent,
    McqresultstuComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule
  ],
  providers: [
    provideHttpClient(withFetch())
  ],
  bootstrap: [AppComponent]  // Only bootstrap AppComponent
})
export class AppModule { }
