package in.bookapp.bookservice.service;

import java.util.List;
import java.util.Optional;

import in.bookapp.bookservice.model.Book;

public interface BookService {
    
        public Book save(Book book);
    
        public Optional<Book> getBookById(String id);

        public List<Book> getByIds(List<String> ids );
    
        public Book update(Book book);
    
        public void delete(String id);

        public List<Book> getAll();
    
}
