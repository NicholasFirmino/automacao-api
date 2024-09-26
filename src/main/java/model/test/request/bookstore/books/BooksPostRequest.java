package model.test.request.bookstore.books;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "userId",
    "collectionOfIsbns"
})
public class BooksPostRequest {

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("collectionOfIsbns")
    private List<Isbn> collectionOfIsbns;

    // Construtor vazio
    public BooksPostRequest() {
    }

    // Construtor com parâmetros
    public BooksPostRequest(String userId, List<Isbn> collectionOfIsbns) {
        this.userId = userId;
        this.collectionOfIsbns = collectionOfIsbns;
    }

    // Getters e Setters
    @JsonProperty("userId")
    public String getUserId() {
        return userId;
    }

    @JsonProperty("userId")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonProperty("collectionOfIsbns")
    public List<Isbn> getCollectionOfIsbns() {
        return collectionOfIsbns;
    }

    @JsonProperty("collectionOfIsbns")
    public void setCollectionOfIsbns(List<Isbn> collectionOfIsbns) {
        this.collectionOfIsbns = collectionOfIsbns;
    }

    // Método builder para facilitar a construção do objeto
    public static BooksPostRequest builder() {
        return new BooksPostRequest();
    }

    public BooksPostRequest withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public BooksPostRequest withCollectionOfIsbns(List<Isbn> collectionOfIsbns) {
        this.collectionOfIsbns = collectionOfIsbns;
        return this;
    }

    // Classe Isbn para representar os itens da lista
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
        "isbn"
    })
    public static class Isbn {

        @JsonProperty("isbn")
        private String isbn;

        // Construtor vazio
        public Isbn() {
        }

        // Construtor com parâmetros
        public Isbn(String isbn) {
            this.isbn = isbn;
        }

        // Getters e Setters
        @JsonProperty("isbn")
        public String getIsbn() {
            return isbn;
        }

        @JsonProperty("isbn")
        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        // Método builder
        public static Isbn builder() {
            return new Isbn();
        }

        public Isbn withIsbn(String isbn) {
            this.isbn = isbn;
            return this;
        }
    }
}

