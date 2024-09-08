import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { inject } from '@angular/core';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor() {}

  httpClient = inject(HttpClient);
  baseUrl = 'http://localhost:8080';
  signup(data: any) {
    console.log('stasd');
    return this.httpClient.post(`${this.baseUrl}/auth/signup`, data);
  }

  login(data: any) {
    return this.httpClient.post(`${this.baseUrl}/auth/login`, data).pipe(
      tap((result: any) => {
        localStorage.setItem('authToken', result.token);
        console.log(result.token);
      })
    );
  }

  logout() {
    localStorage.removeItem('authToken');
  }

  isLoggedIn() {
    return localStorage.getItem('authToken') !== null;
  }

  getToken() {
    return localStorage.getItem('authToken');
  }
}
