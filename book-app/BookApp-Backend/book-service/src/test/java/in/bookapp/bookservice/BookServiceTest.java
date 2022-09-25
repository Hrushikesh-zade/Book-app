package in.bookapp.bookservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import in.bookapp.bookservice.model.Book;
import in.bookapp.bookservice.repository.BookRepository;
import in.bookapp.bookservice.service.BookServiceImpl;

@DataMongoTest
@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;
    private Book book1, book2;
    List<Book> book;

    @BeforeEach
    public void setUp() {

        book1 = new Book( "Wings of Fire", "A.P.J. Abdul Kalam" , "Wings of Fire (1999), is the autobiography of the Missile Man of India and President of India, Dr. A. P. J. Abdul Kalam.",  "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1588286863i/634583._UY862_SS862_.jpg", "250");

        book1 = new Book( "xyz", "abc" , "qwerty",  "https://i.gr-assets.com/images/S/compressed.photo.goodreads2.com/books/1588286863i/634583._UY862_SS862_.jpg", "150");
        
    }

    @AfterEach
    public void tearDown() {
        bookRepository.deleteAll();
        book1 = null;
        book2 = null;

    }

    @Test
    public void givenCustomerToSaveReturnSavedCustomerSuccess() {
        when(bookRepository.save(any())).thenReturn(book1);
        assertEquals(book1, bookService.save(book1));
        verify(bookRepository, times(1)).save(any());

    }


    
}
