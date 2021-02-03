import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeComponent } from './home.component';

describe('HomeComponent', () => {
  let component: HomeComponent;
  let fixture: ComponentFixture<HomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HomeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should render the all tab data', () => {
    fixture = TestBed.createComponent(HomeComponent);
    const allData: HTMLElement = fixture.nativeElement.querySelector('#all');
    expect(allData).toBeTruthy();
  })

  it('should render the personal tab data', () => {
    fixture = TestBed.createComponent(HomeComponent);
    const allData: HTMLElement = fixture.nativeElement.querySelector('#personal');
    expect(allData).toBeTruthy();
  })
});
