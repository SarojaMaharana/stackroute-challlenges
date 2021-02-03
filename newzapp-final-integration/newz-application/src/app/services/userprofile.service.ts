import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { TokenStorageService } from './token-storage.service';

@Injectable({
  providedIn: 'root'
})
export class UserprofileService {

  tokenHeader: HttpHeaders = new HttpHeaders({
    'Authorization': `Bearer ${this.tokenService.getToken()}`
  });

  constructor(private http: HttpClient, private tokenService: TokenStorageService) { }

  getUserDetails(userId: string) {
    return this.http.get<any>(environment.userProfileServiceUrl+"userprofile/"+userId, {headers: this.tokenHeader}).toPromise();
  }

  createUser(userDetails: any) {
    return this.http.post<any>(environment.userProfileServiceUrl+"user", userDetails).toPromise();
  }

  async updateUser(updatedDetails: any, userId: string) {
    return await this.http.put<any>(environment.userProfileServiceUrl+"userprofile/"+userId, updatedDetails, { headers: this.tokenHeader}).toPromise();
  }
}
