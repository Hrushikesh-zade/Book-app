import { Component, Input, OnInit, EventEmitter, Output } from '@angular/core';
import { Book } from 'src/app/models/Book';

@Component({
  selector: 'app-book-api',
  templateUrl: './book-api.component.html',
  styleUrls: ['./book-api.component.css']
})
export class BookApiComponent implements OnInit {

  @Input() book: any = {} as Book;
  @Output() bookClicked: EventEmitter<Book> = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  addToWishlist(){
    // console.log('Add to cart', this.product);
    this.bookClicked.emit(this.book);
  }

}
