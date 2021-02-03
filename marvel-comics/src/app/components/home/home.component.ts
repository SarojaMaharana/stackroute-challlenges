import { Component, OnInit } from '@angular/core';
import { AngularFireAuth } from '@angular/fire/auth'
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private auth: AngularFireAuth, private router: Router) { }

  ngOnInit(): void {
  }

  loginForm = new FormGroup({
    loginEmail: new FormControl(''),
    loginPassword: new FormControl('')
  })

  registerForm = new FormGroup({
    registerEmail: new FormControl(''),
    registerPassword: new FormControl('')
  })

  login () {
    if (this.loginForm.valid) {
      this.auth.signInWithEmailAndPassword(this.loginForm.value.loginEmail, this.loginForm.value.loginPassword)
      .then(response => {
        console.log(response)
        this.router.navigate(['/marvel'])
      })
    }
  }

  register () {
    if (this.registerForm.valid) {
      this.auth.createUserWithEmailAndPassword(this.registerForm.value.registerEmail, this.registerForm.value.registerPassword)
      .then(response => {
        console.log(response)
        this.router.navigate(['/marvel'])
      })
    }
  }

  toggleMenu () {
    const menuToggle = document.querySelector('.menuToggle')
    const navigation = document.querySelector('.navigation')
    menuToggle.classList.toggle('active')
    navigation.classList.toggle('active')
  }
  blurBackground () {
    const blur = document.getElementById('blur')
    const navigationUl = document.querySelector('.navigation ul')
    const popup = document.getElementById('popup')
    blur.classList.toggle('blurActive')
    navigationUl.classList.toggle('blurActive')
    popup.classList.toggle('blurActive')
  }

}
