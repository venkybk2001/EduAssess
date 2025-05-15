import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AttemptmcqtestComponent } from './attemptmcqtest.component';

describe('AttemptmcqtestComponent', () => {
  let component: AttemptmcqtestComponent;
  let fixture: ComponentFixture<AttemptmcqtestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AttemptmcqtestComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AttemptmcqtestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
