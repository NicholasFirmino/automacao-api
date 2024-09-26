package model.test.response.account.user;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "userId",
        "username",
        "books"
})
public class UserGetSuccessResponse {

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("username")
    private String username;

    @JsonProperty("books")
    private List<Book> books = null;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("userId")
    public String getUserId() {
        return userId;
    }

    @JsonProperty("userId")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("books")
    public List<Book> getBooks() {
        return books;
    }

    @JsonProperty("books")
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public static class Book {

        @JsonProperty("isbn")
        private String isbn;

        @JsonProperty("title")
        private String title;

        @JsonProperty("subTitle")
        private String subTitle;

        @JsonProperty("author")
        private String author;

        @JsonProperty("publish_date")
        private Timestamp publishDate;

        @JsonProperty("publisher")
        private String publisher;

        @JsonProperty("pages")
        private int pages;

        @JsonProperty("description")
        private String description;

        @JsonProperty("website")
        private String website;

        // Getters and setters for each property

        @JsonProperty("isbn")
        public String getIsbn() {
            return isbn;
        }

        @JsonProperty("isbn")
        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        @JsonProperty("title")
        public String getTitle() {
            return title;
        }

        @JsonProperty("title")
        public void setTitle(String title) {
            this.title = title;
        }

        @JsonProperty("subTitle")
        public String getSubTitle() {
            return subTitle;
        }

        @JsonProperty("subTitle")
        public void setSubTitle(String subTitle) {
            this.subTitle = subTitle;
        }

        @JsonProperty("author")
        public String getAuthor() {
            return author;
        }

        @JsonProperty("author")
        public void setAuthor(String author) {
            this.author = author;
        }

        @JsonProperty("publish_date")
        public Timestamp getPublishDate() {
            return publishDate;
        }

        @JsonProperty("publish_date")
        public void setPublishDate(Timestamp publishDate) {
            this.publishDate = publishDate;
        }

        @JsonProperty("publisher")
        public String getPublisher() {
            return publisher;
        }

        @JsonProperty("publisher")
        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        @JsonProperty("pages")
        public int getPages() {
            return pages;
        }

        @JsonProperty("pages")
        public void setPages(int pages) {
            this.pages = pages;
        }

        @JsonProperty("description")
        public String getDescription() {
            return description;
        }

        @JsonProperty("description")
        public void setDescription(String description) {
            this.description = description;
        }

        @JsonProperty("website")
        public String getWebsite() {
            return website;
        }

        @JsonProperty("website")
        public void setWebsite(String website) {
            this.website = website;
        }
    }
}
