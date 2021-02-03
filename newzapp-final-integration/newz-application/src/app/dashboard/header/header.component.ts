import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  isLoggedIn = true;
  userName = "";

  constructor(private tokenService: TokenStorageService, private router: Router) { }

  ngOnInit(): void {
    this.userName = this.tokenService.getUser();
  }

  logout(): void {
    this.tokenService.signOut();
    this.router.navigate(['/']);
  }

}
