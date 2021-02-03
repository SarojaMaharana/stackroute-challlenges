import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MarvelNavigationComponent } from './marvel-navigation.component';

describe('MarvelNavigationComponent', () => {
  let component: MarvelNavigationComponent;
  let fixture: ComponentFixture<MarvelNavigationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MarvelNavigationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MarvelNavigationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
