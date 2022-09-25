import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class WishlistService {
  URL = 'http://localhost:9000/api/v1/wishlist/';

  newUrl = '';

  constructor(private http: HttpClient) {}

  getAllWishedBooks() {
    // calling the method to get the new url
    this.getUrlForWishedBooksByUser();
    // sending a get request
    return this.http.get(this.newUrl);
  }

  getUrlForWishedBooksByUser() {
    this.newUrl = '';
    var s = localStorage.getItem('email');
    this.newUrl = this.URL + s;
  }

  getUrlForDeletingWishedBooks(id : string){
    this.newUrl = '';
    this.newUrl = this.URL + "delete/" + id;
  }

  addToWishlist(bookdata: any) {
    return this.http.post(`${this.URL}`, bookdata);
  }

  removeFromWishlist(id : string){
    this.getUrlForDeletingWishedBooks(id);
    return this.http.delete(this.newUrl);
    // return this.getAllWishedBooks();
  }

  
}
