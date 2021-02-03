import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import * as $ from 'jquery';
import { ToastrService } from 'ngx-toastr';
import { Credentials } from 'src/model/Credentials';
import { UserDetails } from 'src/model/UserDetails';
import { AuthService } from '../services/auth.service';
import { UserprofileService } from '../services/userprofile.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  userDetails: UserDetails = new UserDetails();
  credentials: Credentials = new Credentials();

  constructor(private auth: AuthService,private userService: UserprofileService ,private toastr: ToastrService, private router:Router) { }

  ngOnInit(): void {
    $('input, select').on('focus', function () {
      $(this).parent().find('.input-group-text').css('border-color', '#80bdff');
    });
    $('input, select').on('blur', function () {
        $(this).parent().find('.input-group-text').css('border-color', '#ced4da');
    });
  }

  async registerUser(registerForm: NgForm) {
    if (/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/.test(registerForm.value.password)) {
      if (registerForm.value.password === registerForm.value.passwordConfirmation) {
        this.userDetails.userId = registerForm.value.username;
        this.userDetails.firstName = registerForm.value.firstname;
        this.userDetails.lastName = registerForm.value.lastname;
        this.userDetails.contact = registerForm.value.phone;
        this.userDetails.email = registerForm.value.email;
    
        this.credentials.userId = registerForm.value.username;
        this.credentials.password = registerForm.value.password;
        this.credentials.cpassword = registerForm.value.passwordConfirmation;
    
        console.log(this.userDetails);
        
        await this.userService.createUser(this.userDetails)
                  .then(response => {
                    this.authenticationCall();
                  })
                  .catch(error => {
                    this.onRegisterFailure(error.error.message);
                  });
      } else {
        this.onRegisterFailure('both the passwords are not matching')
      }
    }
    else {
      this.onRegisterFailure('password must be between 6 to 20 characters which contain at least one numeric digit, one uppercase and one lowercase letter')
    }
  }

  async authenticationCall(){
    await this.auth.createUser(this.credentials)
                          .then(response => {
                            this.onRegisterSuccess();
                          })
                          .catch(error => {
                            this.onRegisterFailure(error.error.message);
                          });
  }

  onRegisterSuccess() {
    this.toastr.success('Successful', 'registered successfully');
    this.router.navigate(['/']);
  }

  onRegisterFailure(message: string) {
    this.toastr.error(message);
  }

}
