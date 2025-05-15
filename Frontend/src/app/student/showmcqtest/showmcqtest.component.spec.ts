import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowmcqtestComponent } from './showmcqtest.component';

describe('ShowmcqtestComponent', () => {
  let component: ShowmcqtestComponent;
  let fixture: ComponentFixture<ShowmcqtestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ShowmcqtestComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ShowmcqtestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
