package model.test.response.account.authorized;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"success"})
public class AuthorizedPostSuccessResponse {

    @JsonProperty("success")
    private boolean success;

    // Construtor vazio
    public AuthorizedPostSuccessResponse() {
    }

    // Construtor com o campo success
    public AuthorizedPostSuccessResponse(boolean success) {
        this.success = success;
    }

    // Getter e Setter
    @JsonProperty("success")
    public boolean isSuccess() {
        return success;
    }

    @JsonProperty("success")
    public void setSuccess(boolean success) {
        this.success = success;
    }

    // Sobrescrever equals para comparar as instâncias
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorizedPostSuccessResponse that = (AuthorizedPostSuccessResponse) o;
        return success == that.success;
    }

    @Override
    public int hashCode() {
        return Objects.hash(success);
    }
}
