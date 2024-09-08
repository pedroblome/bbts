import { Component, OnInit } from '@angular/core';
import { HomeService } from './home.service';
import { CommonModule } from '@angular/common'; // Importe o CommonModule
import { HeaderComponent } from '../../header/header.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, HeaderComponent],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  products: any[] = []; 
  pagedProducts: any[] = []; 
  errorMessage: string = '';

  currentPage = 1; 
  pageSize = 14; 
  totalPages = 0; 
  constructor(private homeService: HomeService) {}

  ngOnInit(): void {
    this.loadProducts();
  }

  loadProducts() {
    this.homeService.getAllProducts().subscribe(
      (data) => {
        this.products = data;
        this.totalPages = Math.ceil(this.products.length / this.pageSize);
        this.updatePagedProducts();
      },
      (error) => {
        this.errorMessage = 'Erro ao carregar produtos';
        console.error(error);
      }
    );
  }

  updatePagedProducts() {
    const startIndex = (this.currentPage - 1) * this.pageSize;
    const endIndex = startIndex + this.pageSize;
    this.pagedProducts = this.products.slice(startIndex, endIndex);
  }

  prevPage() {
    if (this.currentPage > 1) {
      this.currentPage--;
      this.updatePagedProducts();
    }
  }

  nextPage() {
    if (this.currentPage < this.totalPages) {
      this.currentPage++;
      this.updatePagedProducts();
    }
  }
}
