import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { AuthService } from '../services/auth.service';
import { RouterService } from '../services/router.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private auth: AuthService, private router: RouterService) { }

  ngOnInit(): void {
  }

  loginForm = new FormGroup ({
    username: new FormControl(''),
    password: new FormControl('')
  });

  login() {
    if (this.loginForm.valid) {
      this.auth.validateUser(this.loginForm.value)
      .subscribe(response => {
        console.log('success');
        console.log(response);
        console.log(response['token']);
        this.router.gotoDashboard();
      }, error => {console.log(error);});
    }
    else {
      console.log("Form validation failed");
    }
  }

}
