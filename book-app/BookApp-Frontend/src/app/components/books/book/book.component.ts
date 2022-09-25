import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Book } from 'src/app/models/Book';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {

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
