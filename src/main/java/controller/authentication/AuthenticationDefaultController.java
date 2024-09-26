package controller.authentication;

import java.util.HashMap;
import java.util.Map;

import controller.request.ApiRest;
import lombok.extern.log4j.Log4j2;
import model.authentication.AuthenticationDefault;

@Log4j2
public class AuthenticationDefaultController extends ApiRest {
	private String baseUrl;
	private static String endPointAuthentication = "/api/auth/token";

	private String accessToken;
	private String tokenType;
	private String clientId;
	private String clientSecret;
	private String username;
	private String password;

	private Map<String, String> headers;
	private Map<String, Object> body;
	
	private AuthenticationDefault autheDefault;

	/**
	 * Construtor da classe `AuthenticationDefaultController`.
	 * Inicializa as variáveis de configuração, incluindo a URL base e as credenciais
	 * necessárias para a autenticação.
	 */
	public AuthenticationDefaultController() {
		baseUrl = getConfigurationsProperties().getAutheTokenUrlToBeExecute();
		accessToken = getConfigurationsProperties().getAutheTokenToBeExecute();
		tokenType = getConfigurationsProperties().getAutheType();
		clientId = getConfigurationsProperties().getAutheClientIdToBeExecute();
		clientSecret = getConfigurationsProperties().getAutheClientSecretToBeExecute();
		username = getConfigurationsProperties().getAutheTokenUsernameToBeExecute();
		password = getConfigurationsProperties().getAutheTokenPasswordToBeExecute();
		headers = new HashMap<>();
		body = new HashMap<>();
		autheDefault = new AuthenticationDefault();
	}

	/**
	 * Gera o token de acesso e o tipo de token usando as credenciais armazenadas.
	 *
	 * @return `AuthenticationDefaultController` retorna a instância da própria classe.
	 */
	public AuthenticationDefaultController generateTokenAndType() {
		body.put("username", username);
		body.put("password", password);
		response = postMethod(baseUrl.concat(endPointAuthentication), body);
		return this;
	}

	/**
	 * Gera o token de acesso usando campos personalizados para `username` e `password`.
	 *
	 * @param fieldUsername Campo para o nome de usuário.
	 * @param fieldPassword Campo para a senha.
	 * @return `AuthenticationDefaultController` retorna a instância da própria classe.
	 */
	public AuthenticationDefaultController generateTokenAndType(String fieldUsername, String fieldPassword) {
		body.put(fieldUsername, username);
		body.put(fieldPassword, password);
		response = postMethod(baseUrl.concat(endPointAuthentication), body);
		return this;
	}

	/**
	 * Gera o token de acesso com valores personalizados para `username` e `password`.
	 *
	 * @param fieldUsername Campo para o nome de usuário.
	 * @param valueUsername Valor do nome de usuário.
	 * @param fieldPassword Campo para a senha.
	 * @param valuePassword Valor da senha.
	 * @return `AuthenticationDefaultController` retorna a instância da própria classe.
	 */
	public AuthenticationDefaultController generateTokenAndType(String fieldUsername, String valueUsername,
			String fieldPassword, String valuePassword) {
		body.put(fieldUsername, valueUsername);
		body.put(fieldPassword, valuePassword);
		response = postMethod(baseUrl.concat(endPointAuthentication), body);
		return this;
	}

	/**
	 * Gera o token de acesso usando `clientId` e `clientSecret` juntamente com `username` e `password`.
	 *
	 * @return `AuthenticationDefaultController` retorna a instância da própria classe.
	 */
	public AuthenticationDefaultController generateTokenAndTypeWithClientIdAndSecret() {
		headers.put("client_id", clientId);
		headers.put("client_secret", clientSecret);
		body.put("username", username);
		body.put("password", password);
		response = postMethod(body, headers, baseUrl.concat(endPointAuthentication));
		return this;
	}

	/**
	 * Gera o token de acesso usando campos personalizados de `username` e `password` com `clientId` e `clientSecret`.
	 *
	 * @param fieldUsername Campo para o nome de usuário.
	 * @param fieldPassword Campo para a senha.
	 * @return `AuthenticationDefaultController` retorna a instância da própria classe.
	 */
	public AuthenticationDefaultController generateTokenAndTypeWithClientIdAndSecret(String fieldUsername,
			String fieldPassword) {
		headers.put("client_id", clientId);
		headers.put("client_secret", clientSecret);
		body.put(fieldUsername, username);
		body.put(fieldPassword, password);
		response = postMethod(body, headers, baseUrl.concat(endPointAuthentication));
		return this;
	}

	/**
	 * Gera o token de acesso com campos personalizados e cabeçalhos para `clientId` e `clientSecret`.
	 *
	 * @param fieldUsername  Campo para o nome de usuário.
	 * @param fieldPassword  Campo para a senha.
	 * @param fieldClientId  Campo para o client ID.
	 * @param fieldClientSecret Campo para o client secret.
	 * @return `AuthenticationDefaultController` retorna a instância da própria classe.
	 */
	public AuthenticationDefaultController generateTokenAndTypeWithClientIdAndSecret(String fieldUsername,
			String fieldPassword, String fieldClientId, String fieldClientSecret) {
		headers.put(fieldClientId, clientId);
		headers.put(fieldClientSecret, clientSecret);
		body.put(fieldUsername, username);
		body.put(fieldPassword, password);
		response = postMethod(body, headers, baseUrl.concat(endPointAuthentication));
		return this;
	}

	/**
	 * Gera o token de acesso com valores personalizados para `username`, `password`, `clientId` e `clientSecret`.
	 *
	 * @param fieldUsername Campo para o nome de usuário.
	 * @param valueUsername Valor do nome de usuário.
	 * @param fieldPassword Campo para a senha.
	 * @param valuePassword Valor da senha.
	 * @param fieldClientId Campo para o client ID.
	 * @param fieldClientSecret Campo para o client secret.
	 * @return `AuthenticationDefaultController` retorna a instância da própria classe.
	 */
	public AuthenticationDefaultController generateTokenAndTypeWithClientIdAndSecret(String fieldUsername,
			String valueUsername, String fieldPassword, String valuePassword, String fieldClientId,
			String fieldClientSecret) {
		headers.put(fieldClientId, clientId);
		headers.put(fieldClientSecret, clientSecret);
		body.put(fieldUsername, valueUsername);
		body.put(fieldPassword, valuePassword);
		response = postMethod(body, headers, baseUrl.concat(endPointAuthentication));
		return this;
	}

	/**
	 * Obtém o token de acesso a partir da resposta da API.
	 *
	 * @return String contendo o token de acesso.
	 */
	public String getAccessToken() {
		try {
			String token;
	        AuthenticationDefault authResponse = response.as(autheDefault.getClass());
	        token = authResponse.getAccessToken().toString();
	        log.info("Obtendo token de acesso: " + token);
	        return token;
		} catch (Exception e) {
			log.info("Erro ao obter token de acesso: " + e);
			return null;
		}
    }

	/**
	 * Obtém o tipo de token a partir da resposta da API.
	 *
	 * @return String contendo o tipo de token.
	 */
	public String getTokenType() {
		try {
			String type;
	        AuthenticationDefault authResponse = response.as(autheDefault.getClass());
	        type = authResponse.getTokenType().toString();
	        log.info("Obtendo tipo de token de acesso: " + type);
	        return type;
		} catch (Exception e) {
			log.info("Erro ao obter tipo de token de acesso: " + e);
			return null;
		}
    }
	
	/**
	 * Obtém o token e o tipo de token concatenados em uma única string.
	 *
	 * @return String contendo o tipo e o token de acesso concatenados.
	 */
	public String getAccessTokenAndTokenType() {
		try {
			String typeToken;
			AuthenticationDefault authResponse = response.as(autheDefault.getClass());
			if(accessToken.isBlank()) {
				accessToken = authResponse.getAccessToken().toString();
			}
			if(tokenType.isBlank()) {
				tokenType = authResponse.getTokenType().toString();
			}
	        typeToken = tokenType.concat(" ").concat(accessToken);
	        log.info("Obtendo tipo e token de acesso: " + typeToken);
	        return typeToken;
		} catch (Exception e) {
			log.info("Erro ao obter tipo e token: " + e);
			return null;
		}
    }
	
	/**
	 * Obtém a data e hora de expiração do token a partir da resposta da API.
	 *
	 * @return String contendo a data e hora de expiração do token.
	 */
	public String getExpiresToken() {
		try {
			String expires;
			AuthenticationDefault authResponse = response.as(autheDefault.getClass());
			expires = authResponse.getExpiresToken().toString();
	        log.info("Obtendo data e hora de expiração do token: " + expires);
	        return expires;
		} catch (Exception e) {
			log.info("Erro ao obter data e hora de expiração do token: " + e);
			return null;
		}
	}

	/**
	 * Obtém o status do token a partir da resposta da API.
	 *
	 * @return String contendo o status do token.
	 */
	public String getStatusToken() {
		try {
			String status;
			AuthenticationDefault authResponse = response.as(autheDefault.getClass());
			status = authResponse.getStatusToken().toString();
	        log.info("Obtendo status do token: " + status);
	        return status;
		} catch (Exception e) {
			log.info("Erro ao obter status do token: " + e);
			return null;
		}
	}

	/**
	 * Obtém o resultado do token a partir da resposta da API.
	 *
	 * @return String contendo o resultado do token.
	 */
	public String getResultToken() {
		try {
			String result;
			AuthenticationDefault authResponse = response.as(autheDefault.getClass());
			result = authResponse.getResultToken().toString();
	        log.info("Obtendo resultado do token: " + result);
	        return result;
		} catch (Exception e) {
			log.info("Erro ao obter resultado do token: " + e);
			return null;
		}
	}
}
