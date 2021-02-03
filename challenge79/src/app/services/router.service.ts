import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class RouterService {

  constructor(private router: Router) { }

  gotoDashboard() {
    this.router.navigate(['/dashboard']);
  }
  gotoRegister() {
    this.router.navigate(['register']);
  }
  gotoLogin() {
    this.router.navigate(['/login']);
  }
}
