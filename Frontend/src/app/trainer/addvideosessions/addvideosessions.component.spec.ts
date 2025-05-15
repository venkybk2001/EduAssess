import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddvideosessionsComponent } from './addvideosessions.component';

describe('AddvideosessionsComponent', () => {
  let component: AddvideosessionsComponent;
  let fixture: ComponentFixture<AddvideosessionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AddvideosessionsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddvideosessionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
