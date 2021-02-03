import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import * as $ from 'jquery';
import { ToastrService } from 'ngx-toastr';
import { Credentials } from 'src/model/Credentials';
import { AuthService } from '../services/auth.service';
import { TokenStorageService } from '../services/token-storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  credentials: Credentials = new Credentials();
  isLoggedIn = false;

  constructor(private auth: AuthService, private toastr: ToastrService, private router:Router, private tokenService: TokenStorageService) { }

  ngOnInit(): void {
    if (this.tokenService.getToken()) {
      this.router.navigate(['/news']);
    }
    $('input, select').on('focus', function () {
      $(this).parent().find('.input-group-text').css('border-color', '#80bdff');
    });
    $('input, select').on('blur', function () {
        $(this).parent().find('.input-group-text').css('border-color', '#ced4da');
    });
  }

  async loginUser(loginForm: NgForm) {
    this.credentials.userId = loginForm.value.username;
    this.credentials.password = loginForm.value.password;
    
    let loginUser = await this.auth.loginUser(this.credentials)
                    .then(response => {
                      this.onLoginSuccess(response.message, response.token, response.username);
                    })
                    .catch(error => {
                      this.onLoginFailure(error.error.message);
                    });
  }

  onLoginSuccess(message: string, token: string, username: string) {
    this.toastr.success('Successful', message);
    this.tokenService.saveToken(token);
    this.tokenService.saveUser(username);
    this.router.navigate(['/news']);
  }

  onLoginFailure(message: string) {
    this.toastr.error(message);
  }

}
