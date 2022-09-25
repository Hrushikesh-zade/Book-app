package in.bookapp.wishlistservice.model;

// import com.fasterxml.jackson.databind.annotation.JsonSerialize;
// import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
// import org.springframework.data.mongodb.core.mapping.MongoId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Wishbooks")
public class Wishlist {

    @Id
    // @JsonSerialize(using = ToStringSerializer.class)
    private String wislistId;

    private String email;

    private String Id;

    private String bookName;

    private String authorName;

    private String description;

    private String imageUrl;

    private String price;

    public Wishlist(String email,String Id, String bookName, String authorName, String description, String imageUrl, String price) {
        this.email = email;
        this.Id = Id;
        this.bookName = bookName;
        this.authorName = authorName;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
    }
    public Wishlist(int wishlistId ,String email,String Id, String bookName, String authorName, String description, String imageUrl, String price) {
        this.email = email;
        this.Id = Id;
        this.bookName = bookName;
        this.authorName = authorName;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
    }

} 
