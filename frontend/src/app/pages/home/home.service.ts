import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthService } from '../../auth/auth.service'; // Importe o AuthService
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class HomeService {
  private apiUrl = 'http://localhost:8080/product';

  constructor(
    private httpClient: HttpClient,
    private authService: AuthService
  ) {}

  // Método para obter todos os produtos
  getAllProducts(): Observable<any> {
    const token = this.authService.getToken();

    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`, // Adiciona o token no cabeçalho
    });
    console.log(headers);
    return this.httpClient.get(this.apiUrl, { headers });
  }
}
