import { Component, Input, OnInit } from '@angular/core';
import { Book } from 'src/app/models/Book';
import { BookService } from 'src/app/services/book.service';
import { WishlistService } from 'src/app/services/wishlist.service';

@Component({
  selector: 'app-related-books',
  templateUrl: './related-books.component.html',
  styleUrls: ['./related-books.component.css'],
})
export class RelatedBooksComponent implements OnInit {
  books: any = [];
  constructor(
    private bookService: BookService,
    private wishlistService: WishlistService
  ) {}

  ngOnInit() {
    this.bookService.getAllBooks().subscribe(
      (response) => {
        this.books = response;
      },

      (error) => {
        console.log(error);
      }
    );
  }

  onBookClicked(book: Book) {
    var myJsonString = JSON.stringify(book);
    var myJsonObject = JSON.parse(myJsonString);
    myJsonObject.email = localStorage.getItem('email');

    this.wishlistService.addToWishlist(myJsonObject).subscribe(
      (res) => {},
      (err) => {
        console.log(err);
      }
    );
  }
}
