package in.bookapp.bookrestclient.service;

// import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.bookapp.bookrestclient.domain.Book;

@Service
public class BookServiceImpl implements BookService {

    private RestTemplate restTemplate;

    public BookServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Book getBookByTitle(String title) {
        return restTemplate.getForObject("http://openlibrary.org/search.json?title={title}", Book.class, title);
    }

    @Override
    public Book getBookByAuthor(String author) {
        return restTemplate.getForObject("http://openlibrary.org/search.json?author={author}", Book.class, author);
    }


}
