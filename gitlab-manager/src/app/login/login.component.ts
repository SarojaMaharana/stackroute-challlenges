import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Login } from '../class/login';
import { Register } from '../class/register';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  url = 'http://localhost:3000/users'

  loginData: Login = new Login()
  registerData: Register = new Register()
  fetchedData:Array<any> = []
  emails: Array<string> = []

  constructor(private router: Router, private toastr: ToastrService) { }

  async ngOnInit() {
    // console.log(await this.isAvaliable())
    if (await this.isAvaliable() === 'success') {
      const response = await fetch(this.url)
      this.fetchedData = Array.of(await response.json())[0]
    }
    // const resp = await fetch(this.url+'?registerEmail=meher.psit@gmail.co')
    // if (resp.ok) {
    //   console.log(await resp.json())
    // } else {
    //   console.log('http error: ' +resp.status);
    // }
  }

  async isAvaliable () {
    const timeout = new Promise((resolve, reject) => {
      setTimeout(reject, 300, 'Request timed out');
    })
    const request = fetch(this.url)
    return Promise.race([timeout, request])
    .then(response => 'success')
      .catch(error => this.toastr.error('Server not avaliable. Please Wait..'))
  }

  async login() {

      var item = this.fetchedData.find(item => item.registerEmail === this.loginData.loginEmail)
      if (item) {
        if (item.registerPassword === this.loginData.loginPassword) {
          console.log('success')
          this.loginData = new Login()
          this.onLoginSuccess()
        }
        else {
          this.onLoginFailure('invalid password')
        }
      } else {
        this.loginData = new Login()
        this.onLoginFailure('Email is not registered')
      }
  }

  onLoginSuccess() {
    this.toastr.success('Successful')
    this.router.navigate(['/home'])
  }

  onLoginFailure(msg: string) {
    this.toastr.error(msg)
  }

  async register() {
    if (this.registerData.registerEmail == '' || this.registerData.registerUsername == '' || this.registerData.registerPassword == '' || this.registerData.registerPasswordRetype == '') {
      this.toastr.error('all fields are required')
    }
    else {
      if (/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/.test(this.registerData.registerEmail)) {
        if (/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/.test(this.registerData.registerPassword)) {
          if (this.registerData.registerPassword === this.registerData.registerPasswordRetype) {
            const config = {
              method: 'POST',
              headers: {
                  'Accept': 'application/json',
                  'Content-Type': 'application/json',
              },
              body: JSON.stringify(this.registerData)
            }
            const response = await fetch(this.url, config)
            
            if (response.ok) {
              this.router.navigate(['/'])
                this.toastr.success('Registered Successfully')
                this.registerData = new Register()
            }
          } else {
            this.toastr.error('both the passwords are not matching')
          }
        }
        else {
          this.toastr.error('password must be between 6 to 20 characters which contain at least one numeric digit, one uppercase and one lowercase letter')
        }
      }
      else {
        this.toastr.error('Please enter a proper email id')
      }
    }
  }

}
