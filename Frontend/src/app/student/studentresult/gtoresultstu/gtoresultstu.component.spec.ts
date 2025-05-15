import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GtoresultstuComponent } from './gtoresultstu.component';

describe('GtoresultstuComponent', () => {
  let component: GtoresultstuComponent;
  let fixture: ComponentFixture<GtoresultstuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [GtoresultstuComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(GtoresultstuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
