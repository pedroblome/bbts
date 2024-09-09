import { Component } from '@angular/core'; 
import { CommonModule } from '@angular/common';
import { HeaderComponent } from '../../header/header.component';
import { AdminService } from './admin.service';

@Component({
  selector: 'app-admin',
  standalone: true,
  imports: [HeaderComponent, CommonModule],
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css',
})
export class AdminComponent {
  products: any[] = [];
  pagedProducts: any[] = [];
  errorMessage: string = '';

  currentPage = 1;
  pageSize = 14;
  totalPages = 0;

  constructor(private adminService: AdminService) {}

  ngOnInit(): void {
    this.loadProducts();
  }

  loadProducts() {
    this.adminService.getUserProducts().subscribe(
      (data) => {
        this.products = data;
        console.log(this.products);
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

  deleteProduct(id: number) {
    this.adminService.deletetUserProduct(id).subscribe(
      (response) => {
        console.log('Product deleted successfully');
        this.loadProducts(); 
      },
      (error) => {
        console.error('Error deleting product:', error);
      }
    );
  }
}
