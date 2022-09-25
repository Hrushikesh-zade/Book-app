package in.bookapp.wishlistservice.controller;

import java.util.List;
// import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import in.bookapp.wishlistservice.exceptions.BookAlreadyExistException;
import in.bookapp.wishlistservice.model.Wishlist;
import in.bookapp.wishlistservice.service.WishlistService;
import in.bookapp.wishlistservice.service.WishlistServiceImpl;

@RestController
@RequestMapping("/api/v1/wishlist")
@CrossOrigin(origins = "*")
public class WishlistController {

    private static Logger logger = LoggerFactory.getLogger(WishlistController.class);

    @Autowired
    private WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService, WishlistServiceImpl wsi) {
        this.wishlistService = wishlistService;
    }

    // save the book
    // method 1
    @PostMapping({ "", "/" })
    public ResponseEntity<Wishlist> saveBook(@RequestBody Wishlist book){
        Wishlist savedBook = wishlistService.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    // method 2
    @GetMapping({ "", "/" })
    public ResponseEntity<List<Wishlist>> getAllBooks() {
        List<Wishlist> bookList = wishlistService.getAll();
        if (bookList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(bookList);
    }

    // get the book by email
    @GetMapping({ "/{email}" })
    public ResponseEntity<List<Wishlist>> getWishlistByEmail(@PathVariable String email) {
        logger.info("getting the data from the server .....");
        List<Wishlist> bookList = wishlistService.getWishlistByEmail(email);
        if (bookList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        logger.info("got the data from the server .....");
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    //deleting the data based on id
    @DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteFromWishlist(@PathVariable("id") String id){
		logger.info("inside deleteFromFavourites method");
		ResponseEntity<?> response = null;
		wishlistService.deleteFromWishlist(id);
		response = ResponseEntity.status(HttpStatus.OK).build();
		logger.info("the favourite has been deleted by the given gifId");
		return response;
	}


}
