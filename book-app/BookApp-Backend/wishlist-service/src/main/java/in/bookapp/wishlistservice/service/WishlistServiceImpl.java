package in.bookapp.wishlistservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.bookapp.wishlistservice.model.Wishlist;
import in.bookapp.wishlistservice.repository.WishlistRepository;

@Service
public class WishlistServiceImpl implements WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    // public WishlistServiceImpl(WishlistRepository wishlistRepoitory) {
    //     this.wishlistRepoitory = wishlistRepoitory;
    // } 

    // method 1
    @Override
    public Wishlist save(Wishlist book) {
        return wishlistRepository.save(book);
    }

    // method 2
    @Override
    public List<Wishlist> getAll() {
        return wishlistRepository.findAll();
    }

    @Override
    public List<Wishlist> getWishlistByEmail(String email) {
        List<Wishlist> list = wishlistRepository.findWishlistByEmail(email);
        return list;
    }

    @Override
    public Wishlist deleteFromWishlist(String id) {
        try{
            wishlistRepository.deleteById(id);
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    
}
