package model.test.request.bookstore.books;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "userId",
    "isbn"
})
public class BooksPutRequest {

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("isbn")
    private String isbn;

    // Construtor vazio
    public BooksPutRequest() {
    }

    // Construtor com parâmetros
    public BooksPutRequest(String userId, String isbn) {
        this.userId = userId;
        this.isbn = isbn;
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

    @JsonProperty("isbn")
    public String getIsbn() {
        return isbn;
    }

    @JsonProperty("isbn")
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // Método builder para facilitar a construção do objeto
    public static BooksPutRequest builder() {
        return new BooksPutRequest();
    }

    public BooksPutRequest withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public BooksPutRequest withIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }
}
