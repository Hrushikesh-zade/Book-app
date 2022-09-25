package in.bookapp.wishlistservice.service;

import java.util.List;
import java.util.Optional;

// import in.bookapp.wishlistservice.exceptions.BookAlreadyExistException;
import in.bookapp.wishlistservice.model.Wishlist;

public interface WishlistService {
    
        // method 1
        Wishlist save(Wishlist wishedbook);

        //method 2
        public List<Wishlist> getAll();

        //method 4
        public Wishlist deleteFromWishlist(String id);

        //method 3
        public List<Wishlist> getWishlistByEmail(String email);

    
}
