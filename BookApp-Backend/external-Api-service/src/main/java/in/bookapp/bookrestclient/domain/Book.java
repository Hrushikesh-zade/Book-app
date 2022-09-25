package in.bookapp.bookrestclient.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

// import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {


    // @JsonProperty("docs")
    private Docs[] docs;

}
