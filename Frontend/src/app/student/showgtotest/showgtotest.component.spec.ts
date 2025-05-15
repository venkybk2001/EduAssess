import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowgtotestComponent } from './showgtotest.component';

describe('ShowgtotestComponent', () => {
  let component: ShowgtotestComponent;
  let fixture: ComponentFixture<ShowgtotestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ShowgtotestComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ShowgtotestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
