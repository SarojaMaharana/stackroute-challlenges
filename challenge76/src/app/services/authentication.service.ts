import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http: HttpClient) { }

  validateUser(user): Observable<Object> {
    return this.http.post('http://localhost:3001/auth/v1', user);
  }
}
