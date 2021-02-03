import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  validateUser(user): Observable<object> {
    return this.http.post('http://localhost:3001/auth/v1', user);
  }

  setToken(token: string) {
    localStorage.setItem('authToken', token);
  }

  getToken(): string {
    return localStorage.getItem('authToken');
  }

  removeToken() {
    localStorage.removeItem('authToken');
  }

  authentication(token: any): Promise<any> {
    return this.http.post("http://localhost:3001/auth/v1/isAuthenticated", {}, {
      headers: new HttpHeaders().set('Authorization', 'Bearer'+token)
    }).toPromise();
  }
}
