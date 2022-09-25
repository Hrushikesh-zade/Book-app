package in.bookapp.bookrestclient.service;

import in.bookapp.bookrestclient.domain.Book;

public interface BookService {
    
    Book getBookByTitle(String title);
    
    Book getBookByAuthor(String author);

}
