import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { ToastRef, ToastrModule, ToastrService } from 'ngx-toastr';
import { Register } from '../class/register';

import { LoginComponent } from './login.component';

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let toastPackageMock: {
    toastId: number;
    toastType: string;
    afterActivate: jasmine.Spy;
    config: { toastClass: string; };
    message: string;
    title: string;
    toastRef: ToastRef<unknown>;
  };

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginComponent ],
      imports: [RouterTestingModule,
                ToastrModule.forRoot()],
      providers: [ToastrService]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should contain a default value for loginData', () => {
    expect(component.loginData).toBeTruthy();
  });

  it('should contain a default empty value for loginData', () => {
    expect(component.loginData.loginEmail).toEqual('')
    expect(component.loginData.loginPassword).toEqual('')
  });

  it('should contain a default value for registerData', () => {
    expect(component.registerData).toBeTruthy();
  });

  it('should contain a default empty value for registerData', () => {
    expect(component.registerData.registerEmail).toEqual('')
    expect(component.registerData.registerPassword).toEqual('')
    expect(component.registerData.registerPasswordRetype).toEqual('')
    expect(component.registerData.registerUsername).toEqual('')
  });

  it('should login the user if the form is valid and navigate to the dashboard', () => {
    component.fetchedData = [{id: 1,
      registerEmail: "mehersupreeth@gmail.com",
      registerPassword: "1234567",
      registerPasswordRetype: "1234567",
      registerUsername: "mehersk"}]
    component.loginData.loginEmail = 'mehersupreeth@gmail.com';
    component.loginData.loginPassword = '1234567';
    spyOn(component, 'onLoginSuccess')
    component.login()
    expect(component.onLoginSuccess).toHaveBeenCalled();
  });
  
  it('should not login if the user gives invalid password', () => {
    component.fetchedData = [{id: 1,
      registerEmail: "mehersupreeth@gmail.com",
      registerPassword: "1234567",
      registerPasswordRetype: "1234567",
      registerUsername: "mehersk"}]
    component.loginData.loginEmail = 'mehersupreeth@gmail.com';
    component.loginData.loginPassword = '123456';
    spyOn(component, 'onLoginFailure')
    component.login()
    expect(component.onLoginFailure).toHaveBeenCalled();
  });

  it('should not login if the user gives invalid email', () => {
    component.fetchedData = [{id: 1,
      registerEmail: "mehersupreeth@gmail.com",
      registerPassword: "1234567",
      registerPasswordRetype: "1234567",
      registerUsername: "mehersk"}]
    component.loginData.loginEmail = 'mehersupree@gmail.com';
    component.loginData.loginPassword = '1234567';
    spyOn(component, 'onLoginFailure')
    component.login()
    expect(component.onLoginFailure).toHaveBeenCalled();
  });

});
