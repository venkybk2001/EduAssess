import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WrittenquestionComponent } from './writtenquestion.component';

describe('WrittenquestionComponent', () => {
  let component: WrittenquestionComponent;
  let fixture: ComponentFixture<WrittenquestionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [WrittenquestionComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(WrittenquestionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
