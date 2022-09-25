package in.bookapp.bookservice.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.bookapp.bookservice.model.Book;
import in.bookapp.bookservice.service.BookService;

@RestController
@RequestMapping("/api/v1/books")
@CrossOrigin(origins = "*")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    // save the book
    @PostMapping({"","/"})
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        Book savedBook = bookService.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }
    
    // get the book by id
    @GetMapping({"/{id}"})
    public ResponseEntity<Book> getBookById(@PathVariable String id) {

        Optional<Book> book = bookService.getBookById(id);
        if(book.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(book.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping({"","/"})
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> bookList = bookService.getAll();
        if(bookList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(bookList);
    }

    // update the book
    @PutMapping({"/{id}"})
    public ResponseEntity<Book> updateBook(@RequestBody Book newBookData, @PathVariable String id) {
        Optional<Book> existingBookOpt = bookService.getBookById(id);
        if(existingBookOpt.isPresent()){
            Book existingBook =  existingBookOpt.get();
            existingBook.setBookName(newBookData.getBookName());
            existingBook.setAuthorName(newBookData.getAuthorName());
            existingBook.setDescription(newBookData.getDescription());
            existingBook.setImageUrl(newBookData.getImageUrl());
            existingBook.setPrice(newBookData.getPrice());
            return ResponseEntity.status(HttpStatus.OK).body(bookService.update(existingBook));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    // delete the book
    @DeleteMapping({"/{id}"})
    public ResponseEntity<Book> deleteBook(@PathVariable String id) {
        bookService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    // get id list
    @GetMapping({"/ids/{ids}"})
    public ResponseEntity<List<Book>> getIds(@PathVariable List<String> ids) {
        System.err.println(ids);
        ids.forEach(String::trim);
        List<Book> books = bookService.getByIds(ids);
        if(books.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }
    
}
