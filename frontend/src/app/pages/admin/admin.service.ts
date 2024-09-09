import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthService } from '../../auth/auth.service'; 
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AdminService {
  private apiUrl = 'http://localhost:8080/product';

  constructor(
    private httpClient: HttpClient,
    private authService: AuthService
  ) {}

  getUserProducts(): Observable<any> {
    const token = this.authService.getToken();
    const userId = this.authService.getUserId();
    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`,
    });

    return this.httpClient.get(`${this.apiUrl}/user/${userId}`, { headers });
  }

  deletetUserProduct(idProduct: Number): Observable<any> {
    const token = this.authService.getToken();
    console.log('aqui');
    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`,
    });
    return this.httpClient.delete(`${this.apiUrl}/${idProduct}`, { headers });
  }
}
