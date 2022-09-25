package in.bookapp.bookservice.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "books")
public class Book {

    @MongoId
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;

    private String bookName;

    private String authorName;

    private String description;

    private String imageUrl;

    private String price;

    public Book(String bookName, String authorName, String description, String imageUrl, String price) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
    }

} 
