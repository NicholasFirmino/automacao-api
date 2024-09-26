package controller.test.account;

import java.util.HashMap;
import java.util.Map;

import controller.request.ApiRest;
import lombok.extern.log4j.Log4j2;
import model.test.request.account.authorized.AuthorizedPostRequest;
import model.test.response.account.authorized.AuthorizedPostSuccessResponse;
import utils.schemas.SchemaValidator;

@Log4j2
public class AuthorizedController {
	
	private final static String URL_AUTHORIZED = "Account/v1/Authorized";
	private final static String FILE_PATH_POST_AUTHORIZED_SCHEMA = "account/post/authorized/";
	private final static String FILE_NAME_POST_AUTHOROZED_SCHEMA = "authorized_post_success_200";
	private final static String FILE_EXTENSION_POST_AUTHOROZED_SCHEMA = ".json";
	
	private ApiRest apiRest;
	private String baseUrl;
	private SchemaValidator schemaValidator;
	
	public AuthorizedController() {
		apiRest = new ApiRest();
		baseUrl = apiRest.getConfigurationsProperties().getBaseUrlToBeExecute();
		schemaValidator = new SchemaValidator();
	}
	
	public void postAuthorizedWithUsernameAndPassword(AuthorizedPostRequest authoRequest) {
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("userName", authoRequest.getUserName());
		body.put("password", authoRequest.getPassword());
		try {
			apiRest.postMethod(baseUrl.concat(URL_AUTHORIZED),body);
		} catch (Exception e) {
			log.info("erro: " + e);
		}
	}
	
	public Boolean isValidPostAuthorizedSuccessWithSchema() {
		try {
			return schemaValidator
					.validateResponseBodyWithJSONSchema(
							FILE_PATH_POST_AUTHORIZED_SCHEMA,
							FILE_NAME_POST_AUTHOROZED_SCHEMA,
							FILE_EXTENSION_POST_AUTHOROZED_SCHEMA,
							apiRest.getResponse());
		} catch (Exception e) {
			log.info("erro de validacao: " + e);
			return false;
		}
	}
	
	public Boolean isValidPostAuthorizedSuccessWithModel() {
	    try {
	        // Converter a resposta da API para o modelo AuthorizedPostSuccessResponse
	        AuthorizedPostSuccessResponse actualResponse = apiRest.getResponse().getBody().as(AuthorizedPostSuccessResponse.class);

	        // Criar uma instância do modelo esperado com sucesso = true
	        AuthorizedPostSuccessResponse expectedResponse = new AuthorizedPostSuccessResponse(true);

	        // Verificar se a resposta da API é igual ao modelo esperado
	        if (expectedResponse.equals(actualResponse)) {
	            log.info("Validação de sucesso: O corpo da resposta é válido.");
	            return true;
	        } else {
	            log.error("Erro na validação: O corpo da resposta não é válido.");
	            return false;
	        }
	    } catch (Exception e) {
	        log.error("Erro durante a validação da resposta com o modelo: " + e.getMessage(), e);
	        return false;
	    }
	}




	
	public Boolean isStatusCodeEquals(Integer statusCode) {
		return apiRest.getStatusCode().equals(statusCode);
	}
}
