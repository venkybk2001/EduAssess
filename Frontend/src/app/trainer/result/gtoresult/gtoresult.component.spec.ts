import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GtoresultComponent } from './gtoresult.component';

describe('GtoresultComponent', () => {
  let component: GtoresultComponent;
  let fixture: ComponentFixture<GtoresultComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [GtoresultComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(GtoresultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
