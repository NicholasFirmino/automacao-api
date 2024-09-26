package model.authentication;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true) // Ignora campos desconhecidos
@JsonPropertyOrder({
    "accessToken",    // Campo que a API pode retornar como accessToken ou token
    "tokenType",      // Campo que pode ser tokenType ou type
    "expiresToken",   // Expiração do token
    "statusToken",    // Status do token
    "resultToken"     // Resultado do token
})
public class AuthenticationDefault {

    @JsonAlias({"accessToken", "token"}) // Mapear accessToken e token para o mesmo campo
    @JsonProperty("accessToken")
    private String accessToken;

    @JsonAlias({"tokenType", "type"}) // Mapear tokenType e type para o mesmo campo
    @JsonProperty("tokenType")
    private String tokenType;

    @JsonAlias({"expires", "expiration"}) // Mapear expires e expiration
    @JsonProperty("expires")
    private String expiresToken;

    @JsonAlias({"status"}) // Mapear status
    @JsonProperty("status")
    private String statusToken;

    @JsonAlias({"result", "output"}) // Mapear result e output
    @JsonProperty("result")
    private String resultToken;

    // Getters e Setters
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getExpiresToken() {
        return expiresToken;
    }

    public void setExpiresToken(String expiresToken) {
        this.expiresToken = expiresToken;
    }

    public String getStatusToken() {
        return statusToken;
    }

    public void setStatusToken(String statusToken) {
        this.statusToken = statusToken;
    }

    public String getResultToken() {
        return resultToken;
    }

    public void setResultToken(String resultToken) {
        this.resultToken = resultToken;
    }
}
