import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AttemptgtotestComponent } from './attemptgtotest.component';

describe('AttemptgtotestComponent', () => {
  let component: AttemptgtotestComponent;
  let fixture: ComponentFixture<AttemptgtotestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AttemptgtotestComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AttemptgtotestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
