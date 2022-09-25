package in.bookapp.wishlistservice;

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

import in.bookapp.wishlistservice.model.Wishlist;
import in.bookapp.wishlistservice.repository.WishlistRepository;
import in.bookapp.wishlistservice.service.WishlistServiceImpl;

@DataMongoTest
@ExtendWith(MockitoExtension.class)
public class WishlistServiceTest {

    @Mock
    private WishlistRepository wishlistRepository;

    @InjectMocks
    private WishlistServiceImpl wishlistService;
    private Wishlist wishlist1,wishlist2;
    List<Wishlist> wishlist;

    @BeforeEach
    public void setUp() {

        wishlist1 = new Wishlist("test@gmail.com", "1", "harry potter", "JKRowling", "something", "url", "150");
        wishlist2 = new Wishlist("test@gmail.com", "2", "good man", "unknown", "something", "url", "250");

    }

    @AfterEach
    public void tearDown() {
        wishlistRepository.deleteAll();
        wishlist1 = null;
        wishlist2 = null;

    }

    @Test
    public void givenCustomerToSaveReturnSavedCustomerSuccess() {
        when(wishlistRepository.save(any())).thenReturn(wishlist1);
        assertEquals(wishlist1, wishlistService.save(wishlist1));
        verify(wishlistRepository, times(1)).save(any());

    }


    @Test
    public void givenCustomerToDeleteShouldDeleteSuccess() {
        Wishlist data = wishlistService.deleteFromWishlist(wishlist1.getWislistId());

        assertEquals(null, data);
        verify(wishlistRepository, times(1)).deleteById(any());

    }

    @Test
    @DisplayName("Test to check if data can be found by email")
    public void findWishlistByEmailTest(){

        wishlistRepository.save(wishlist1);
        wishlistRepository.save(wishlist2);
        List<Wishlist> data = wishlistRepository.findWishlistByEmail("test1@gmail.com");
        List<Wishlist> data2 = wishlistRepository.findWishlistByEmail("wrongtest@gmail.com");

        assertEquals(data.size(), 0 );

        assertEquals(data2.size(),0);

    }

    

}
