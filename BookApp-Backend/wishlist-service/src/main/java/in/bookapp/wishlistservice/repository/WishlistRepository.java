package in.bookapp.wishlistservice.repository;

import java.util.List;
// import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import in.bookapp.wishlistservice.model.Wishlist;

public interface WishlistRepository extends MongoRepository<Wishlist, String> {

    List<Wishlist> findWishlistByEmail(String email);
    
}
