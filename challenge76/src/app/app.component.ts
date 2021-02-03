import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { AuthenticationService } from './services/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'challenge76';
  check:boolean = false;

  constructor(private authServ: AuthenticationService) {}

  signInButton() {
    console.log('clicked sign in');
    this.check = false;
  }
  signUpButton() {
    console.log('clicked sign up');
    this.check = true;
  }

  loginForm = new FormGroup ({
    username: new FormControl(''),
    password: new FormControl('')
  })

  onClickLogin() {
    if (this.loginForm.valid) {
      this.authServ.validateUser(this.loginForm.value)
      .subscribe(response => {
        console.log('success');
        console.log(response);
      }, error => {console.log(error)})
    }
  }
}
