import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Credentials } from 'src/model/Credentials';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  async createUser(credentials: Credentials) {
    return await this.http.post(environment.authServiceUrl+"register", credentials).toPromise();
  }

  async loginUser(credentials: Credentials) {
    return await this.http.post<any>(environment.authServiceUrl+"login", credentials).toPromise();
  }

}
