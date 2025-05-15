import { ComponentFixture, TestBed } from '@angular/core/testing';

import { McqresultstuComponent } from './mcqresultstu.component';

describe('McqresultstuComponent', () => {
  let component: McqresultstuComponent;
  let fixture: ComponentFixture<McqresultstuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [McqresultstuComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(McqresultstuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
