import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { RouterTestingModule } from '@angular/router/testing';

import { HeaderComponent } from './header.component';

describe('HeaderComponent', () => {
  let component: HeaderComponent;
  let fixture: ComponentFixture<HeaderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HeaderComponent ],
      imports: [RouterTestingModule]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  // custom test cases
  it('should render the header', () => {
    fixture = TestBed.createComponent(HeaderComponent);
    const pannel = fixture.debugElement.query(By.css('mat-toolbar'));
    expect(pannel).toBeTruthy();
  });

  it('should render brand name', () => {
    fixture = TestBed.createComponent(HeaderComponent);
    const text: HTMLElement = fixture.nativeElement.querySelector('#brand_name');
    const title=text.innerHTML;
    expect(title).toBe('Gitlab manager')
  });
});
