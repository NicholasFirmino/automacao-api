package model.test.request.account.authorized;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "userName",
    "password"
})
public class AuthorizedPostRequest {

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("password")
    private String password;

    // Construtor vazio
    public AuthorizedPostRequest() {
    }

    // Construtor com parâmetros
    public AuthorizedPostRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    // Getters e Setters
    @JsonProperty("userName")
    public String getUserName() {
        return userName;
    }

    @JsonProperty("userName")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    // Método builder para facilitar a construção do objeto
    public static AuthorizedPostRequest builder() {
        return new AuthorizedPostRequest();
    }

    public AuthorizedPostRequest withUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public AuthorizedPostRequest withPassword(String password) {
        this.password = password;
        return this;
    }
}

