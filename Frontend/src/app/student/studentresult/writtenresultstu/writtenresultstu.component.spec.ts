import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WrittenresultstuComponent } from './writtenresultstu.component';

describe('WrittenresultstuComponent', () => {
  let component: WrittenresultstuComponent;
  let fixture: ComponentFixture<WrittenresultstuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [WrittenresultstuComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(WrittenresultstuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
