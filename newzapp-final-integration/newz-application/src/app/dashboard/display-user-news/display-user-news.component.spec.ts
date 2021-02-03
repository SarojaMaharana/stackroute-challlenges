import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayUserNewsComponent } from './display-user-news.component';

describe('DisplayUserNewsComponent', () => {
  let component: DisplayUserNewsComponent;
  let fixture: ComponentFixture<DisplayUserNewsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisplayUserNewsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplayUserNewsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
