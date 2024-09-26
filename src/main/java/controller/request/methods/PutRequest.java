package controller.request.methods;

import static io.restassured.RestAssured.given;

import java.util.Map;

import com.google.gson.Gson;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class PutRequest extends PostRequest {

    private String putMessage = "put ";

    /**
     * Método para realizar uma requisição PUT simples com um corpo (body).
     *
     * @param url  URL do endpoint.
     * @param body Mapa com os dados a serem enviados no corpo da requisição.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response putMethod(String url, Map<String, Object> body) {
    	return executeWithRetry(() -> {
    		try {
                response = given().body(body).when().put(url);
                log.info(defaultFirstMessage + putMessage + defaultLastMessage + "url=" + url + ", body=" + body);
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
    	});
    }
    
    /**
     * Método para realizar uma requisição PUT simples com um corpo (body).
     *
     * @param url  URL do endpoint.
     * @param body Mapa com os dados a serem enviados no corpo da requisição.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response putMethod(String url, Map<String, Object> body, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
    	return putMethod(url, body);
    }

    /**
     * Método para realizar uma requisição PUT com autenticação (token).
     *
     * @param url          URL do endpoint.
     * @param body         Mapa com os dados a serem enviados no corpo da requisição.
     * @param tokenAndType Token de autenticação (ex: Bearer).
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response putMethod(String url, Map<String, Object> body, String tokenAndType) {
    	return executeWithRetry(() -> {
    		try {
                response = given().body(body).headers("Authorization", tokenAndType).when().put(url);
                log.info(defaultFirstMessage + putMessage + defaultLastMessage + "url=" + url + ", token=" + tokenAndType + ", body=" + body);
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
    	});
    }
    
    /**
     * Método para realizar uma requisição PUT com autenticação (token).
     *
     * @param url          URL do endpoint.
     * @param body         Mapa com os dados a serem enviados no corpo da requisição.
     * @param tokenAndType Token de autenticação (ex: Bearer).
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response putMethod(String url, Map<String, Object> body, String tokenAndType, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
    	return putMethod(url, body, tokenAndType);
    }

    /**
     * Método para realizar uma requisição PUT com autenticação (token) e cabeçalhos adicionais.
     *
     * @param url          URL do endpoint.
     * @param body         Mapa com os dados a serem enviados no corpo da requisição.
     * @param tokenType    Tipo de token (ex: Bearer).
     * @param accessToken  Token de acesso.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response putMethod(String url, Map<String, Object> body, String tokenType, String accessToken) {
    	return executeWithRetry(() -> {
    		try {
                response = given().body(body).headers("Authorization", tokenType + " " + accessToken).when().put(url);
                log.info(defaultFirstMessage + putMessage + defaultLastMessage + "url=" + url + ", token=" + tokenType + " " + accessToken + ", body=" + body);
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
    	});
    }
    
    /**
     * Método para realizar uma requisição PUT com autenticação (token) e cabeçalhos adicionais.
     *
     * @param url          URL do endpoint.
     * @param body         Mapa com os dados a serem enviados no corpo da requisição.
     * @param tokenType    Tipo de token (ex: Bearer).
     * @param accessToken  Token de acesso.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response putMethod(String url, Map<String, Object> body, String tokenType, String accessToken, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
    	return putMethod(url, body, tokenType, accessToken);
    }

    /**
     * Método para realizar uma requisição PUT com cabeçalhos e corpo.
     *
     * @param url                URL do endpoint.
     * @param contentType        Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param logAll             Boolean para logar a requisição inteira.
     * @param headers            Map com cabeçalhos HTTP.
     * @param body               Mapa com os dados a serem enviados no corpo da requisição.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response putMethod(String url, ContentType contentType, boolean urlEncodingEnabled, Boolean logAll,
                                 Map<String, String> headers, Map<String, Object> body) {
    	return executeWithRetry(() -> {
    		try {
                response = given().contentType(contentType).relaxedHTTPSValidation().urlEncodingEnabled(urlEncodingEnabled)
                        .log().all(logAll).headers(headers).body(new Gson().toJson(body)).put(url).then().extract().response();
                log.info(defaultFirstMessage + putMessage + defaultLastMessage + "url=" + url + ", contentType=" + contentType + ", body=" + body);
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
    	});
    }
    
    /**
     * Método para realizar uma requisição PUT com cabeçalhos e corpo.
     *
     * @param url                URL do endpoint.
     * @param contentType        Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param logAll             Boolean para logar a requisição inteira.
     * @param headers            Map com cabeçalhos HTTP.
     * @param body               Mapa com os dados a serem enviados no corpo da requisição.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response putMethod(String url, ContentType contentType, boolean urlEncodingEnabled, Boolean logAll,
                                 Map<String, String> headers, Map<String, Object> body, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
    	return putMethod(url, contentType, urlEncodingEnabled, logAll, headers, body);
    }

    /**
     * Método para realizar uma requisição PUT com cabeçalhos, parâmetros de consulta e corpo.
     *
     * @param url                URL do endpoint.
     * @param contentType        Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param logAll             Boolean para logar a requisição inteira.
     * @param headers            Map com cabeçalhos HTTP.
     * @param queryParams        Mapa com os parâmetros de consulta.
     * @param body               Mapa com os dados a serem enviados no corpo da requisição.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response putMethod(String url, ContentType contentType, boolean urlEncodingEnabled, Boolean logAll,
                                 Map<String, String> headers, Map<String, Object> queryParams, Map<String, Object> body) {
    	return executeWithRetry(() -> {
    		try {
                response = given().contentType(contentType).relaxedHTTPSValidation().urlEncodingEnabled(urlEncodingEnabled)
                        .log().all(logAll).headers(headers).queryParams(queryParams).body(new Gson().toJson(body)).put(url)
                        .then().extract().response();
                log.info(defaultFirstMessage + putMessage + defaultLastMessage + "url=" + url + ", contentType=" + contentType + ", queryParams=" + queryParams + ", body=" + body);
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
    	});
    }
    
    /**
     * Método para realizar uma requisição PUT com cabeçalhos, parâmetros de consulta e corpo.
     *
     * @param url                URL do endpoint.
     * @param contentType        Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param logAll             Boolean para logar a requisição inteira.
     * @param headers            Map com cabeçalhos HTTP.
     * @param queryParams        Mapa com os parâmetros de consulta.
     * @param body               Mapa com os dados a serem enviados no corpo da requisição.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response putMethod(String url, ContentType contentType, boolean urlEncodingEnabled, Boolean logAll,
                                 Map<String, String> headers, Map<String, Object> queryParams, Map<String, Object> body,
                                 Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
    	return putMethod(url, contentType, urlEncodingEnabled, logAll, headers, queryParams, body);
    }

    /**
     * Método para realizar uma requisição PUT com cabeçalhos, corpo e credenciais de autenticação (username e password).
     *
     * @param url                URL do endpoint.
     * @param contentType        Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param logAll             Boolean para logar a requisição inteira.
     * @param headers            Map com cabeçalhos HTTP.
     * @param body               Mapa com os dados a serem enviados no corpo da requisição.
     * @param userName           Mapa com o nome de usuário.
     * @param password           Mapa com a senha.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response putMethod(String url, ContentType contentType, boolean urlEncodingEnabled, Boolean logAll,
                                 Map<String, String> headers, Map<String, Object> body, Map<String, Object> userName,
                                 Map<String, Object> password) {
    	return executeWithRetry(() -> {
    		try {
                response = given().contentType(contentType).relaxedHTTPSValidation().urlEncodingEnabled(urlEncodingEnabled)
                        .log().all(logAll).headers(headers).body(userName).body(password).body(new Gson().toJson(body)).put(url)
                        .then().extract().response();
                log.info(defaultFirstMessage + putMessage + defaultLastMessage + "url=" + url + ", contentType=" + contentType + ", body=" + body);
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
    	});
    }
    
    /**
     * Método para realizar uma requisição PUT com cabeçalhos, corpo e credenciais de autenticação (username e password).
     *
     * @param url                URL do endpoint.
     * @param contentType        Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param logAll             Boolean para logar a requisição inteira.
     * @param headers            Map com cabeçalhos HTTP.
     * @param body               Mapa com os dados a serem enviados no corpo da requisição.
     * @param userName           Mapa com o nome de usuário.
     * @param password           Mapa com a senha.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response putMethod(String url, ContentType contentType, boolean urlEncodingEnabled, Boolean logAll,
                                 Map<String, String> headers, Map<String, Object> body, Map<String, Object> userName,
                                 Map<String, Object> password, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
    	return putMethod(url, contentType, urlEncodingEnabled, logAll, headers, body, userName, password);
    }

    /**
     * Método para realizar uma requisição PUT com autenticação (token), cabeçalhos e corpo.
     *
     * @param url                URL do endpoint.
     * @param contentType        Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param logAll             Boolean para logar a requisição inteira.
     * @param headers            Map com cabeçalhos HTTP.
     * @param body               Mapa com os dados a serem enviados no corpo da requisição.
     * @param tokenType          Tipo de token (ex: Bearer).
     * @param accessToken        Token de acesso.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response putMethod(String url, ContentType contentType, boolean urlEncodingEnabled, Boolean logAll,
                                 Map<String, String> headers, Map<String, Object> body, String tokenType, String accessToken) {
    	return executeWithRetry(() -> {
    		try {
                response = given().contentType(contentType).relaxedHTTPSValidation().urlEncodingEnabled(urlEncodingEnabled)
                        .log().all(logAll).headers("Authorization", tokenType + " " + accessToken).headers(headers)
                        .body(new Gson().toJson(body)).put(url).then().extract().response();
                log.info(defaultFirstMessage + putMessage + defaultLastMessage + "url=" + url + ", token=" + tokenType + " " + accessToken + ", contentType=" + contentType + ", body=" + body);
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
    	});
    }
    
    /**
     * Método para realizar uma requisição PUT com autenticação (token), cabeçalhos e corpo.
     *
     * @param url                URL do endpoint.
     * @param contentType        Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param logAll             Boolean para logar a requisição inteira.
     * @param headers            Map com cabeçalhos HTTP.
     * @param body               Mapa com os dados a serem enviados no corpo da requisição.
     * @param tokenType          Tipo de token (ex: Bearer).
     * @param accessToken        Token de acesso.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response putMethod(String url, ContentType contentType, boolean urlEncodingEnabled, Boolean logAll,
                                 Map<String, String> headers, Map<String, Object> body, String tokenType, String accessToken,
                                 Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
    	return putMethod(url, contentType, urlEncodingEnabled, logAll, headers, body, tokenType, accessToken);
    }

    /**
     * Método para realizar uma requisição PUT com autenticação (token), cabeçalhos, parâmetros de consulta e corpo.
     *
     * @param url                URL do endpoint.
     * @param contentType        Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param logAll             Boolean para logar a requisição inteira.
     * @param headers            Map com cabeçalhos HTTP.
     * @param queryParams        Mapa com os parâmetros de consulta.
     * @param body               Mapa com os dados a serem enviados no corpo da requisição.
     * @param tokenType          Tipo de token (ex: Bearer).
     * @param accessToken        Token de acesso.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response putMethod(String url, ContentType contentType, boolean urlEncodingEnabled, Boolean logAll,
                                 Map<String, String> headers, Map<String, Object> queryParams, Map<String, Object> body, String tokenType,
                                 String accessToken) {
    	return executeWithRetry(() -> {
    		try {
                response = given().contentType(contentType).relaxedHTTPSValidation().urlEncodingEnabled(urlEncodingEnabled)
                        .log().all(logAll).headers("Authorization", tokenType + " " + accessToken).headers(headers)
                        .queryParams(queryParams).body(new Gson().toJson(body)).put(url).then().extract().response();
                log.info(defaultFirstMessage + putMessage + defaultLastMessage + "url=" + url + ", token=" + tokenType + " " + accessToken + ", contentType=" + contentType + ", queryParams=" + queryParams + ", body=" + body);
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
    	});
    }
    
    /**
     * Método para realizar uma requisição PUT com autenticação (token), cabeçalhos, parâmetros de consulta e corpo.
     *
     * @param url                URL do endpoint.
     * @param contentType        Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param logAll             Boolean para logar a requisição inteira.
     * @param headers            Map com cabeçalhos HTTP.
     * @param queryParams        Mapa com os parâmetros de consulta.
     * @param body               Mapa com os dados a serem enviados no corpo da requisição.
     * @param tokenType          Tipo de token (ex: Bearer).
     * @param accessToken        Token de acesso.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response putMethod(String url, ContentType contentType, boolean urlEncodingEnabled, Boolean logAll,
                                 Map<String, String> headers, Map<String, Object> queryParams, Map<String, Object> body, String tokenType,
                                 String accessToken, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
    	return putMethod(url, contentType, urlEncodingEnabled, logAll, headers, queryParams, body, tokenType,
                accessToken);
    }

    /**
     * Método para realizar uma requisição PUT com autenticação (token), cabeçalhos, corpo e parâmetros adicionais.
     *
     * @param url                URL do endpoint.
     * @param contentType        Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param params             Parâmetros adicionais.
     * @param logAll             Boolean para logar a requisição inteira.
     * @param headers            Map com cabeçalhos HTTP.
     * @param body               Mapa com os dados a serem enviados no corpo da requisição.
     * @param tokenType          Tipo de token (ex: Bearer).
     * @param accessToken        Token de acesso.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response putMethod(String url, ContentType contentType, boolean urlEncodingEnabled,
                                 Map<String, Object> params, Boolean logAll, Map<String, String> headers, Map<String, Object> body,
                                 String tokenType, String accessToken) {
    	return executeWithRetry(() -> {
    		try {
                response = given().contentType(contentType).relaxedHTTPSValidation().urlEncodingEnabled(urlEncodingEnabled)
                        .log().all(logAll).headers("Authorization", tokenType + " " + accessToken).headers(headers).params(params)
                        .body(new Gson().toJson(body)).put(url).then().extract().response();
                log.info(defaultFirstMessage + putMessage + defaultLastMessage + "url=" + url + ", token=" + tokenType + " " + accessToken + ", contentType=" + contentType + ", params=" + params + ", body=" + body);
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
    	});
    }
    
    /**
     * Método para realizar uma requisição PUT com autenticação (token), cabeçalhos, corpo e parâmetros adicionais.
     *
     * @param url                URL do endpoint.
     * @param contentType        Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param params             Parâmetros adicionais.
     * @param logAll             Boolean para logar a requisição inteira.
     * @param headers            Map com cabeçalhos HTTP.
     * @param body               Mapa com os dados a serem enviados no corpo da requisição.
     * @param tokenType          Tipo de token (ex: Bearer).
     * @param accessToken        Token de acesso.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response putMethod(String url, ContentType contentType, boolean urlEncodingEnabled,
                                 Map<String, Object> params, Boolean logAll, Map<String, String> headers, Map<String, Object> body,
                                 String tokenType, String accessToken, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
    	return putMethod(url, contentType, urlEncodingEnabled, params, logAll, headers, body, tokenType, accessToken);
    }
}
