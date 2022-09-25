import { Component, OnInit } from '@angular/core';
import { Book } from 'src/app/models/Book';
import { WishlistService } from 'src/app/services/wishlist.service';

@Component({
  selector: 'app-wished-books',
  templateUrl: './wished-books.component.html',
  styleUrls: ['./wished-books.component.css'],
})
export class WishedBooksComponent implements OnInit {
  books: any = [];
  constructor(private wishlistService: WishlistService) {}

  ngOnInit() {
    this.wishlistService.getAllWishedBooks().subscribe(
      (response) => {
        this.books = response;
        // console.log(response);
      },

      (error) => {
        console.log(error);
      }
    );
  }

  onWishedBookClicked(book: Book) {
    console.log('Product clicked [Parent compoenent]: ', book);
    var myJsonString = JSON.stringify(book);
    var myJsonObject = JSON.parse(myJsonString);
    var x = myJsonObject['wislistId'];
    myJsonObject.email = localStorage.getItem('email');


    console.log(myJsonObject);
    
    // make a post request to the wishlist server
    // by calling add method in wishlist service

    this.wishlistService.removeFromWishlist(x).subscribe((res) => {
      // console.log(res);

      location.reload();

      (err: any) => {
        console.log(err);
      };
    });
  }
}
