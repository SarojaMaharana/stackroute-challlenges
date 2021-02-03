import { Component, OnInit } from '@angular/core';
import { AngularFireAuth } from '@angular/fire/auth';
import { Router } from '@angular/router';

@Component({
  selector: 'app-marvel-navigation',
  templateUrl: './marvel-navigation.component.html',
  styleUrls: ['./marvel-navigation.component.css']
})
export class MarvelNavigationComponent implements OnInit {

  constructor(private auth: AngularFireAuth, private router: Router) { }

  ngOnInit(): void {
  }

  toggleMenu () {
    const menuToggle = document.querySelector('.menuToggle')
    const navigation = document.querySelector('.navigation')
    menuToggle.classList.toggle('active')
    navigation.classList.toggle('active')
  }

  signout() {
    this.auth.signOut()
    .then(res => {
      this.router.navigate(['/home'])
    })
  }

}
