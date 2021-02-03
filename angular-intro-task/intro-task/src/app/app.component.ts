import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'intro-task';
  check:boolean = false;

  signInButton() {
    console.log('clicked sign in');
    this.check = false;
  }
  signUpButton() {
    console.log('clicked sign up');
    this.check = true;
  }
  
}
