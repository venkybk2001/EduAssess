import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GtoComponent } from './gto.component';

describe('GtoComponent', () => {
  let component: GtoComponent;
  let fixture: ComponentFixture<GtoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [GtoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(GtoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
