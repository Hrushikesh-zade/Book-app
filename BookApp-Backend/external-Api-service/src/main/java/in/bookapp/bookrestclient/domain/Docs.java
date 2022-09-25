package in.bookapp.bookrestclient.domain;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Docs {

    @JsonProperty("title")
    private String title;

    @JsonProperty("isbn")
    private String[] isbn;

    @JsonProperty("first_sentence")
    private String[] firstSentense;

    @JsonProperty("author_name")
    private String[] authorname;
    

}
