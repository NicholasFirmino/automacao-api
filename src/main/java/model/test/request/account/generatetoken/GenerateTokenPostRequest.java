package model.test.request.account.generatetoken;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "userName",
    "password"
})
public class GenerateTokenPostRequest {

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("password")
    private String password;

    // Construtor vazio
    public GenerateTokenPostRequest() {
    }

    // Construtor com parâmetros
    public GenerateTokenPostRequest(String userName, String password) {
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
    public static GenerateTokenPostRequest builder() {
        return new GenerateTokenPostRequest();
    }

    public GenerateTokenPostRequest withUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public GenerateTokenPostRequest withPassword(String password) {
        this.password = password;
        return this;
    }
}
