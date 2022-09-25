import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { Book } from 'src/app/models/Book';

@Component({
  selector: 'app-favourite-book',
  templateUrl: './favourite-book.component.html',
  styleUrls: ['./favourite-book.component.css']
})


export class FavouriteBookComponent implements OnInit {

  
  @Input() book: any = {} as Book;
  @Output() bookClicked: EventEmitter<Book> = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  
  removeFromWishlist(){
    this.bookClicked.emit(this.book);
  }
}
