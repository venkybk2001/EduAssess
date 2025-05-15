import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WrittenresultComponent } from './writtenresult.component';

describe('WrittenresultComponent', () => {
  let component: WrittenresultComponent;
  let fixture: ComponentFixture<WrittenresultComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [WrittenresultComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(WrittenresultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
