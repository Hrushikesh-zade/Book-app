package in.bookapp.bookservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import in.bookapp.bookservice.model.Book;
import in.bookapp.bookservice.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepoitory;

    public BookServiceImpl(BookRepository bookRepoitory) {
        this.bookRepoitory = bookRepoitory;
    }

    @Override
    public Book save(Book learner) {
        return bookRepoitory.save(learner);
    }

    @Override
    public Optional<Book> getBookById(String id) {
        return bookRepoitory.findById(id);
    }

    @Override
    public Book update(Book learner) {
        return bookRepoitory.save(learner);
    }

    @Override
    public void delete(String id) {
        bookRepoitory.deleteById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookRepoitory.findAll();
    }

    @Override
    public List<Book> getByIds(List<String> ids) {
        List<Book> book = new ArrayList<>();
        bookRepoitory.findAllById(ids).forEach(book::add);
        return book;
    }

}
