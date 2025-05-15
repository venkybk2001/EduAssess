import { ComponentFixture, TestBed } from '@angular/core/testing';

import { McqresultComponent } from './mcqresult.component';

describe('McqresultComponent', () => {
  let component: McqresultComponent;
  let fixture: ComponentFixture<McqresultComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [McqresultComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(McqresultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
