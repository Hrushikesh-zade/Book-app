package in.bookapp.bookrestclient.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.bookapp.bookrestclient.domain.Book;
import in.bookapp.bookrestclient.service.BookService;

@RestController
@RequestMapping("/api/v1/apibooks")
@CrossOrigin(origins = "*")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{title}")
    public ResponseEntity<Book> getBookByTitle(@PathVariable String title) {
        Book movie = bookService.getBookByTitle(title);
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/Author/{author}")
    public ResponseEntity<Book> getBookByAuthor(@PathVariable String author) {
        Book movie = bookService.getBookByAuthor(author);
        return ResponseEntity.ok(movie);
    }

    
}
