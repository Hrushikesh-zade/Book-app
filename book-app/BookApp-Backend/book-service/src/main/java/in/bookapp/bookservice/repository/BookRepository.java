package in.bookapp.bookservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import in.bookapp.bookservice.model.Book;

public interface BookRepository extends MongoRepository<Book, String> {
    
}
