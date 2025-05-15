import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VideosessionsComponent } from './videosessions.component';

describe('VideosessionsComponent', () => {
  let component: VideosessionsComponent;
  let fixture: ComponentFixture<VideosessionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [VideosessionsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(VideosessionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
