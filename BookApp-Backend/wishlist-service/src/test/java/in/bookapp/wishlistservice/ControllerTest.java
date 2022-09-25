package in.bookapp.wishlistservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

import java.util.List;

import org.apache.tomcat.util.http.parser.MediaType;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.PostMapping;

import in.bookapp.wishlistservice.controller.WishlistController;
import in.bookapp.wishlistservice.model.Wishlist;
import in.bookapp.wishlistservice.repository.WishlistRepository;
import in.bookapp.wishlistservice.service.WishlistService;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Mock
    private WishlistService wishlistService;

    private Wishlist wishlist1,wishlist2;
    List<Wishlist> bookWishlist;
    
    @InjectMocks
    private WishlistController wishlistController;


    @BeforeEach
    public void setUp() {

        wishlist1 = new Wishlist("test@gmail.com", "1", "harry potter", "JKRowling", "something", "url", "150");
        wishlist2 = new Wishlist("test@gmail.com", "2", "good man", "unknown", "something", "url", "250");
        // bookWishlist = Arrays.asList(wishlist1,wishlist2);
        // mockMvc = MockMvcBuilder.standaloneSetup(wishlistController).build();
    mockMvc = MockMvcBuilders.standaloneSetup(wishlistController).build();
    
    }

    @AfterEach
    public void tearDown() {
        wishlist1 = null;
        wishlist2 = null;

    }

/* 
    @Test
    public void givenCustomerToSaveReturnSaveProductSuccess(){
    //   when(wishlistService.save(any())).thenReturn(wishlist1);
    //   mockMvc.perform(post("/api/v1/wishlistService")
    //           .contentType(org.springframework.http.MediaType.APPLICATION_JSON))
    //         //   .content(jsonToString(wishlist1)))
    //           .andExpect(HttpStatus.CREATED);
    //     verify(wishlistService,times(1)).save(any());

    }*/
    



    
}
