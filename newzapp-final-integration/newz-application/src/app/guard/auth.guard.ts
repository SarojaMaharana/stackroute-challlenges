import { Injectable } from '@angular/core';
import { CanLoad, Route, UrlSegment, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router, CanActivate } from '@angular/router';
import { Observable } from 'rxjs';
import { TokenStorageService } from "../services/token-storage.service";

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanLoad, CanActivate {

  constructor(private tokenService: TokenStorageService, private router: Router) {}

  canActivate() {
    if(this.tokenService.getToken()){
      return true;
    } else {
      this.router.navigate(['/']);
      return false;
    }
  }

  canLoad() {
    if(this.tokenService.getToken()){
      return true;
    } else {
      this.router.navigate(['/']);
      return false;
    }
  }
}
