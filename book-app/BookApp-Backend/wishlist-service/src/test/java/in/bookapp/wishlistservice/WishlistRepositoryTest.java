package in.bookapp.wishlistservice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import in.bookapp.wishlistservice.model.Wishlist;
import in.bookapp.wishlistservice.repository.WishlistRepository;

@DataMongoTest
@ExtendWith(SpringExtension.class)
public class WishlistRepositoryTest {
    

    @Autowired
    private  WishlistRepository wishlistRepository;

    Wishlist wishlist1, wishlist2, wishlist3;


    @BeforeEach
    public void setup(){
        wishlist1 = new Wishlist("test@gmail.com","1","harry potter", "JKRowling","something","url","150");
        wishlist2 = new Wishlist("test@gmail.com","2","good man", "unknown","something","url","250");
        wishlist3 = new Wishlist("wrongtest@gmail.com","3","good man", "unknown","something","url","250");
    }


    @AfterEach
    public void tearDown(){
        wishlistRepository.deleteAll();
        wishlist1 = null;
        wishlist2 = null;
        wishlist3 = null;
    }



    @Test
    @DisplayName("Test to check if data can be found by email")
    public void findWishlistByEmailTest(){

        Wishlist wish1 = wishlistRepository.save(wishlist1);
        Wishlist wish2 = wishlistRepository.save(wishlist2);
        Wishlist wish3 = wishlistRepository.save(wishlist3);
        List<Wishlist> data = wishlistRepository.findWishlistByEmail("test@gmail.com");
        List<Wishlist> data2 = wishlistRepository.findWishlistByEmail("wrongtest@gmail.com");
        List<Wishlist> data3 = wishlistRepository.findWishlistByEmail("wrong@gmail.com");

        assertEquals(data.size(), 2 );

        assertEquals(data2.size(),1 );

        assertEquals(data3.size(),0 );

    }
    @Test
    @DisplayName("Test to check if data can be found by email for null case")
    public void findWishlistByEmailForNullTest(){

        Wishlist wish3 = wishlistRepository.save(wishlist3);
        List<Wishlist> data3 = wishlistRepository.findWishlistByEmail("wrong@gmail.com");

        assertEquals(data3.size(),0 );

    }

    
}
