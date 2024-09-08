import { Component, inject } from '@angular/core';
import { AuthService } from '../../auth/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  standalone: true,
  imports: [],
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css',
})

export class AdminComponent {

  userEmail = ''


  authService = inject(AuthService);
  router = inject(Router);
  public logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }

  public getMyProducts(){
    //aqui vai a função que faz um get no enpoint: http://localhost:8080/product/user/{id}
    
    

  }
}
