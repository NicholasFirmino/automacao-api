package controller.request.methods;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.json.JSONObject;

import com.google.gson.Gson;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class PostRequest extends PatchRequest {

    private String postMessage = "post ";

    /**
     * Método para realizar uma requisição POST simples com um corpo (body).
     *
     * @param url  URL do endpoint.
     * @param body Mapa com os dados a serem enviados no corpo da requisição.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response postMethod(String url, Map<String, Object> body) {
    	return executeWithRetry(() -> {
	        try {
	            response = given().contentType(ContentType.JSON).relaxedHTTPSValidation().urlEncodingEnabled(false)
	                    .log().all(true).body(new Gson().toJson(body)).post(url).then().extract().response();
	            log.info(defaultFirstMessage + postMessage + defaultLastMessage + "url=" + url + ", body=" + body);
	        } catch (Exception e) {
	            log.error("error: " + e);
	        }
	        return response;
    	});
    }

    /**
     * Método para realizar uma requisição POST simples com um corpo (body), com timeout e retry.
     *
     * @param url               URL do endpoint.
     * @param body              Mapa com os dados a serem enviados no corpo da requisição.
     * @param connectionTimeout Timeout de conexão.
     * @param readTimeout       Timeout de leitura.
     * @param retryCount        Número de tentativas em caso de falha.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response postMethod(String url, Map<String, Object> body, Integer connectionTimeout,
                                  Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return postMethod(url, body);
    }

    /**
     * Método para realizar uma requisição POST com headers.
     *
     * @param body    Mapa com os dados a serem enviados no corpo da requisição.
     * @param headers Map com cabeçalhos HTTP.
     * @param url     URL do endpoint.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response postMethod(Map<String, Object> body, Map<String, String> headers, String url) {
    	return executeWithRetry(() -> {
    		try {
               response = given().contentType(ContentType.JSON).relaxedHTTPSValidation().urlEncodingEnabled(false)
                        .log().all(true).headers(headers).body(new Gson().toJson(body)).post(url).then()
                        .extract().response();
                log.info(defaultFirstMessage + postMessage + defaultLastMessage + "url=" + url + ", headers="
                        + headers + ", body=" + body);
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
    	});
    }

    /**
     * Método para realizar uma requisição POST com headers, timeout e retry.
     *
     * @param body              Mapa com os dados a serem enviados no corpo da requisição.
     * @param headers           Map com cabeçalhos HTTP.
     * @param url               URL do endpoint.
     * @param connectionTimeout Timeout de conexão.
     * @param readTimeout       Timeout de leitura.
     * @param retryCount        Número de tentativas em caso de falha.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response postMethod(Map<String, Object> body, Map<String, String> headers, String url,
                                  Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return postMethod(body, headers, url);
    }

    /**
     * Método para realizar uma requisição POST com headers e parâmetros de consulta (query params).
     *
     * @param url         URL do endpoint.
     * @param headers     Map com cabeçalhos HTTP.
     * @param queryParams Map com os parâmetros de consulta.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response postMethod(String url, Map<String, String> headers, Map<String, Object> queryParams) {
    	return executeWithRetry(() -> {
    		try {
    	           response = given().relaxedHTTPSValidation().log().all().headers(headers).queryParams(queryParams)
    	                    .when().post(url);
    	            log.info(defaultFirstMessage + postMessage + defaultLastMessage + "url=" + url + ", headers="
    	                    + headers + ", queryParams=" + queryParams);
    	        } catch (Exception e) {
    	            log.error("error: " + e);
    	        }
    	        return response;
    	});
    }

    /**
     * Método para realizar uma requisição POST com headers, parâmetros de consulta (query params), timeout e retry.
     *
     * @param url               URL do endpoint.
     * @param headers           Map com cabeçalhos HTTP.
     * @param queryParams       Mapa com os parâmetros de consulta.
     * @param connectionTimeout Timeout de conexão.
     * @param readTimeout       Timeout de leitura.
     * @param retryCount        Número de tentativas em caso de falha.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response postMethod(String url, Map<String, String> headers, Map<String, Object> queryParams,
                                  Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return postMethod(url, headers, queryParams);
    }

    /**
     * Método para realizar uma requisição POST com proxy, headers e parâmetros de consulta.
     *
     * @param url         URL do endpoint.
     * @param headers     Map com cabeçalhos HTTP.
     * @param queryParams Mapa com os parâmetros de consulta.
     * @param proxy       Proxy a ser utilizado na requisição.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response postMethod(String url, Map<String, String> headers, Map<String, Object> queryParams,
                                  String proxy) {
    	return executeWithRetry(() -> {
    		try {
    	           response = given().relaxedHTTPSValidation().log().all().headers(headers).proxy(proxy)
    	                    .queryParams(queryParams).when().post(url);
    	            log.info(defaultFirstMessage + postMessage + defaultLastMessage + "url=" + url + ", headers="
    	                    + headers + ", queryParams=" + queryParams + ", proxy=" + proxy);
    	        } catch (Exception e) {
    	            log.error("error: " + e);
    	        }
    	        return response;
    	});
    }

    /**
     * Método para realizar uma requisição POST com proxy, headers, timeout e retry.
     *
     * @param url               URL do endpoint.
     * @param headers           Map com cabeçalhos HTTP.
     * @param queryParams       Mapa com os parâmetros de consulta.
     * @param proxy             Proxy a ser utilizado na requisição.
     * @param connectionTimeout Timeout de conexão.
     * @param readTimeout       Timeout de leitura.
     * @param retryCount        Número de tentativas em caso de falha.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response postMethod(String url, Map<String, String> headers, Map<String, Object> queryParams,
                                  String proxy, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return postMethod(url, headers, queryParams, proxy);
    }


    /**
     * Método para realizar uma requisição POST com autenticação (token) e headers.
     *
     * @param url     URL do endpoint.
     * @param token   Token de autenticação.
     * @param headers Map com cabeçalhos HTTP.
     * @param body    Mapa com os dados a serem enviados no corpo da requisição.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response postMethod(String url, String token, Map<String, String> headers, Map<String, Object> body) {
    	return executeWithRetry(() -> {
    		try {
    	           response = given().relaxedHTTPSValidation().log().all().headers("Authorization", token)
    	                    .headers(headers).body(body).when().post(url);
    	            log.info(defaultFirstMessage + postMessage + defaultLastMessage + "url=" + url + ", token="
    	                    + token + ", headers=" + headers + ", body=" + body);
    	        } catch (Exception e) {
    	            log.error("error: " + e);
    	        }
    	        return response;
    	});
    }

    /**
     * Método para realizar uma requisição POST com autenticação (token), headers, timeout e retry.
     *
     * @param url               URL do endpoint.
     * @param token             Token de autenticação.
     * @param headers           Map com cabeçalhos HTTP.
     * @param body              Mapa com os dados a serem enviados no corpo da requisição.
     * @param connectionTimeout Timeout de conexão.
     * @param readTimeout       Timeout de leitura.
     * @param retryCount        Número de tentativas em caso de falha.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response postMethod(String url, String token, Map<String, String> headers, Map<String, Object> body,
                                  Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return postMethod(url, token, headers, body);
    }

    /**
     * Método para realizar uma requisição POST com corpo JSON.
     *
     * @param url  URL do endpoint.
     * @param body Corpo da requisição no formato JSONObject.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response postMethod(String url, JSONObject body) {
    	return executeWithRetry(() -> {
    		try {
    	           response = given().relaxedHTTPSValidation().body(body).when().post(url);
    	            log.info(defaultFirstMessage + postMessage + defaultLastMessage + "url=" + url + ", body=" + body);
    	        } catch (Exception e) {
    	            log.error("error: " + e);
    	        }
    	        return response;
    	});
    }

    /**
     * Método para realizar uma requisição POST com corpo JSON, timeout e retry.
     *
     * @param url               URL do endpoint.
     * @param body              Corpo da requisição no formato JSONObject.
     * @param connectionTimeout Timeout de conexão.
     * @param readTimeout       Timeout de leitura.
     * @param retryCount        Número de tentativas em caso de falha.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response postMethod(String url, JSONObject body, Integer connectionTimeout,
                                  Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return postMethod(url, body);
    }

    /**
     * Método para realizar uma requisição POST com corpo como String.
     *
     * @param url  URL do endpoint.
     * @param body Corpo da requisição no formato String.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response postMethod(String url, String body) {
    	return executeWithRetry(() -> {
    		try {
    	           response = given().relaxedHTTPSValidation().contentType(ContentType.JSON).body(body).when()
    	                    .post(url);
    	            log.info(defaultFirstMessage + postMessage + defaultLastMessage + "url=" + url + ", body=" + body);
    	        } catch (Exception e) {
    	            log.error("error: " + e);
    	        }
    	        return response;
    	});
    }

    /**
     * Método para realizar uma requisição POST com corpo como String, timeout e retry.
     *
     * @param url               URL do endpoint.
     * @param body              Corpo da requisição no formato String.
     * @param connectionTimeout Timeout de conexão.
     * @param readTimeout       Timeout de leitura.
     * @param retryCount        Número de tentativas em caso de falha.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response postMethod(String url, String body, Integer connectionTimeout,
                                  Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return postMethod(url, body);
    }

    /**
     * Método para realizar uma requisição POST com headers e proxy.
     *
     * @param url     URL do endpoint.
     * @param body    Corpo da requisição no formato String.
     * @param headers Map com cabeçalhos HTTP.
     * @param proxy   Proxy a ser utilizado.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response postMethod(String url, String body, Map<String, String> headers, String proxy) {
    	return executeWithRetry(() -> {
    		try {
    	           response = given().relaxedHTTPSValidation().proxy(proxy).contentType(ContentType.JSON)
    	                    .headers(headers).body(body).when().post(url);
    	            log.info(defaultFirstMessage + postMessage + defaultLastMessage + "url=" + url + ", headers="
    	                    + headers + ", proxy=" + proxy + ", body=" + body);
    	        } catch (Exception e) {
    	            log.error("error: " + e);
    	        }
    	        return response;
    	});
    }

    /**
     * Método para realizar uma requisição POST com headers e proxy, timeout e retry.
     *
     * @param url               URL do endpoint.
     * @param body              Corpo da requisição no formato String.
     * @param headers           Map com cabeçalhos HTTP.
     * @param proxy             Proxy a ser utilizado.
     * @param connectionTimeout Timeout de conexão.
     * @param readTimeout       Timeout de leitura.
     * @param retryCount        Número de tentativas em caso de falha.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response postMethod(String url, String body, Map<String, String> headers, String proxy,
                                  Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return postMethod(url, body, headers, proxy);
    }

    /**
     * Método para realizar uma requisição POST com autenticação (token) e corpo JSON.
     *
     * @param url   URL do endpoint.
     * @param body  Corpo da requisição no formato JSONObject.
     * @param token Token de autenticação.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response postMethod(String url, JSONObject body, String token) {
    	return executeWithRetry(() -> {
    		try {
    	           response = given().headers("Authorization", token).body(body.toString()).log().all()
    	                    .when().post(url);
    	            log.info(defaultFirstMessage + postMessage + defaultLastMessage + "url=" + url + ", token="
    	                    + token + ", body=" + body);
    	        } catch (Exception e) {
    	            log.error("error: " + e);
    	        }
    	        return response;
    	});
    }

    /**
     * Método para realizar uma requisição POST com autenticação (token), corpo JSON, timeout e retry.
     *
     * @param url               URL do endpoint.
     * @param body              Corpo da requisição no formato JSONObject.
     * @param token             Token de autenticação.
     * @param connectionTimeout Timeout de conexão.
     * @param readTimeout       Timeout de leitura.
     * @param retryCount        Número de tentativas em caso de falha.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response postMethod(String url, JSONObject body, String token, Integer connectionTimeout,
                                  Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return postMethod(url, body, token);
    }

    /**
     * Método para realizar uma requisição POST com cabeçalhos e corpo.
     *
     * @param url               URL do endpoint.
     * @param contentType       Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param logAll            Boolean para logar a requisição inteira.
     * @param headers           Map com cabeçalhos HTTP.
     * @param body              Mapa com os dados a serem enviados no corpo da requisição.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response postMethod(String url, ContentType contentType, boolean urlEncodingEnabled,
                                  Boolean logAll, Map<String, String> headers, Map<String, Object> body) {
    	return executeWithRetry(() -> {
    		try {
    	           response = given().contentType(contentType).relaxedHTTPSValidation()
    	                    .urlEncodingEnabled(urlEncodingEnabled).log().all(logAll).headers(headers)
    	                    .body(new Gson().toJson(body)).post(url).then().extract().response();
    	            log.info(defaultFirstMessage + postMessage + defaultLastMessage + "url=" + url
    	                    + ", contentType=" + contentType + ", body=" + body);
    	        } catch (Exception e) {
    	            log.error("error: " + e);
    	        }
    	        return response;
    	});
    }

    /**
     * Método para realizar uma requisição POST com cabeçalhos e corpo, timeout e retry.
     *
     * @param url               URL do endpoint.
     * @param contentType       Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param logAll            Boolean para logar a requisição inteira.
     * @param headers           Map com cabeçalhos HTTP.
     * @param body              Mapa com os dados a serem enviados no corpo da requisição.
     * @param connectionTimeout Timeout de conexão.
     * @param readTimeout       Timeout de leitura.
     * @param retryCount        Número de tentativas em caso de falha.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response postMethod(String url, ContentType contentType, boolean urlEncodingEnabled,
                                  Boolean logAll, Map<String, String> headers, Map<String, Object> body,
                                  Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return postMethod(url, contentType, urlEncodingEnabled, logAll, headers, body);
    }

    /**
     * Método para realizar uma requisição POST com cabeçalhos, parâmetros de consulta e corpo.
     *
     * @param url               URL do endpoint.
     * @param contentType       Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param logAll            Boolean para logar a requisição inteira.
     * @param headers           Map com cabeçalhos HTTP.
     * @param queryParams       Mapa com os parâmetros de consulta.
     * @param body              Mapa com os dados a serem enviados no corpo da requisição.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response postMethod(String url, ContentType contentType, boolean urlEncodingEnabled,
                                  Boolean logAll, Map<String, String> headers, Map<String, Object> queryParams,
                                  Map<String, Object> body) {
    	return executeWithRetry(() -> {
    		try {
    	           response = given().contentType(contentType).relaxedHTTPSValidation()
    	                    .urlEncodingEnabled(urlEncodingEnabled).log().all(logAll).headers(headers)
    	                    .queryParams(queryParams).body(new Gson().toJson(body)).post(url).then().extract()
    	                    .response();
    	            log.info(defaultFirstMessage + postMessage + defaultLastMessage + "url=" + url
    	                    + ", contentType=" + contentType + ", queryParams=" + queryParams + ", body=" + body);
    	        } catch (Exception e) {
    	            log.error("error: " + e);
    	        }
    	        return response;
    	});
    }


    /**
     * Método para realizar uma requisição POST com cabeçalhos, parâmetros de consulta e corpo,
     * incluindo configuração de timeout e tentativas de retry.
     *
     * @param url               URL do endpoint.
     * @param contentType       Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param logAll            Define se a requisição inteira deve ser logada.
     * @param headers           Map com cabeçalhos HTTP.
     * @param queryParams       Map com os parâmetros de consulta.
     * @param body              Corpo da requisição.
     * @param connectionTimeout Timeout de conexão.
     * @param readTimeout       Timeout de leitura.
     * @param retryCount        Número de tentativas em caso de falha.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response postMethod(String url, ContentType contentType, boolean urlEncodingEnabled,
                                  Boolean logAll, Map<String, String> headers, Map<String, Object> queryParams,
                                  Map<String, Object> body, Integer connectionTimeout, Integer readTimeout,
                                  Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return postMethod(url, contentType, urlEncodingEnabled, logAll, headers, queryParams, body);
    }

    /**
     * Método para realizar uma requisição POST com autenticação (token), cabeçalhos e corpo.
     *
     * @param url               URL do endpoint.
     * @param contentType       Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param logAll            Define se a requisição inteira deve ser logada.
     * @param headers           Map com cabeçalhos HTTP.
     * @param body              Corpo da requisição.
     * @param tokenType         Tipo de token (ex: Bearer).
     * @param accessToken       Token de acesso.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response postMethod(String url, ContentType contentType, boolean urlEncodingEnabled,
                                  Boolean logAll, Map<String, String> headers, Map<String, Object> body,
                                  String tokenType, String accessToken) {
    	return executeWithRetry(() -> {
    		try {
    	           response = given().contentType(contentType).relaxedHTTPSValidation()
    	                    .urlEncodingEnabled(urlEncodingEnabled).log().all(logAll)
    	                    .headers("Authorization", tokenType + " " + accessToken).headers(headers)
    	                    .body(new Gson().toJson(body)).post(url).then().extract().response();
    	            log.info(defaultFirstMessage + postMessage + defaultLastMessage + "url=" + url
    	                    + ", token=" + tokenType + " " + accessToken + ", contentType=" + contentType
    	                    + ", body=" + body);
    	        } catch (Exception e) {
    	            log.error("error: " + e);
    	        }
    	        return response;
    	});
    }

    /**
     * Método para realizar uma requisição POST com autenticação (token), cabeçalhos e corpo,
     * incluindo configuração de timeout e tentativas de retry.
     *
     * @param url               URL do endpoint.
     * @param contentType       Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param logAll            Define se a requisição inteira deve ser logada.
     * @param headers           Map com cabeçalhos HTTP.
     * @param body              Corpo da requisição.
     * @param tokenType         Tipo de token (ex: Bearer).
     * @param accessToken       Token de acesso.
     * @param connectionTimeout Timeout de conexão.
     * @param readTimeout       Timeout de leitura.
     * @param retryCount        Número de tentativas em caso de falha.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response postMethod(String url, ContentType contentType, boolean urlEncodingEnabled,
                                  Boolean logAll, Map<String, String> headers, Map<String, Object> body,
                                  String tokenType, String accessToken, Integer connectionTimeout,
                                  Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return postMethod(url, contentType, urlEncodingEnabled, logAll, headers, body, tokenType,
                accessToken);
    }

    /**
     * Método para realizar uma requisição POST com autenticação (token), cabeçalhos, parâmetros de consulta e corpo.
     *
     * @param url               URL do endpoint.
     * @param contentType       Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param logAll            Define se a requisição inteira deve ser logada.
     * @param headers           Map com cabeçalhos HTTP.
     * @param queryParams       Map com os parâmetros de consulta.
     * @param body              Corpo da requisição.
     * @param tokenType         Tipo de token (ex: Bearer).
     * @param accessToken       Token de acesso.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response postMethod(String url, ContentType contentType, boolean urlEncodingEnabled,
                                  Boolean logAll, Map<String, String> headers, Map<String, Object> queryParams,
                                  Map<String, Object> body, String tokenType, String accessToken) {
    	return executeWithRetry(() -> {
    		try {
    	           response = given().contentType(contentType).relaxedHTTPSValidation()
    	                    .urlEncodingEnabled(urlEncodingEnabled).log().all(logAll)
    	                    .headers("Authorization", tokenType + " " + accessToken).headers(headers)
    	                    .queryParams(queryParams).body(new Gson().toJson(body)).post(url).then()
    	                    .extract().response();
    	            log.info(defaultFirstMessage + postMessage + defaultLastMessage + "url=" + url
    	                    + ", token=" + tokenType + " " + accessToken + ", contentType=" + contentType
    	                    + ", queryParams=" + queryParams + ", body=" + body);
    	        } catch (Exception e) {
    	            log.error("error: " + e);
    	        }
    	        return response;
    	});
    }

    /**
     * Método para realizar uma requisição POST com autenticação (token), cabeçalhos, parâmetros de consulta e corpo,
     * incluindo configuração de timeout e tentativas de retry.
     *
     * @param url               URL do endpoint.
     * @param contentType       Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param logAll            Define se a requisição inteira deve ser logada.
     * @param headers           Map com cabeçalhos HTTP.
     * @param queryParams       Map com os parâmetros de consulta.
     * @param body              Corpo da requisição.
     * @param tokenType         Tipo de token (ex: Bearer).
     * @param accessToken       Token de acesso.
     * @param connectionTimeout Timeout de conexão.
     * @param readTimeout       Timeout de leitura.
     * @param retryCount        Número de tentativas em caso de falha.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response postMethod(String url, ContentType contentType, boolean urlEncodingEnabled,
                                  Boolean logAll, Map<String, String> headers, Map<String, Object> queryParams,
                                  Map<String, Object> body, String tokenType, String accessToken,
                                  Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return postMethod(url, contentType, urlEncodingEnabled, logAll, headers, queryParams, body,
                tokenType, accessToken);
    }

    /**
     * Método para realizar uma requisição POST com autenticação (token), cabeçalhos, corpo e parâmetros adicionais.
     *
     * @param url               URL do endpoint.
     * @param contentType       Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param params            Map com os parâmetros adicionais.
     * @param logAll            Define se a requisição inteira deve ser logada.
     * @param headers           Map com cabeçalhos HTTP.
     * @param body              Corpo da requisição.
     * @param tokenType         Tipo de token (ex: Bearer).
     * @param accessToken       Token de acesso.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response postMethod(String url, ContentType contentType, boolean urlEncodingEnabled,
                                  Map<String, Object> params, Boolean logAll, Map<String, String> headers,
                                  Map<String, Object> body, String tokenType, String accessToken) {
    	return executeWithRetry(() -> {
    		try {
    	           response = given().contentType(contentType).relaxedHTTPSValidation()
    	                    .urlEncodingEnabled(urlEncodingEnabled).log().all(logAll)
    	                    .headers("Authorization", tokenType + " " + accessToken).headers(headers)
    	                    .params(params).body(new Gson().toJson(body)).post(url).then().extract()
    	                    .response();
    	            log.info(defaultFirstMessage + postMessage + defaultLastMessage + "url=" + url
    	                    + ", token=" + tokenType + " " + accessToken + ", contentType=" + contentType
    	                    + ", params=" + params + ", body=" + body);
    	        } catch (Exception e) {
    	            log.error("error: " + e);
    	        }
    	        return response;
    	});
    }

    /**
     * Método para realizar uma requisição POST com autenticação (token), cabeçalhos, corpo e parâmetros adicionais,
     * incluindo configuração de timeout e tentativas de retry.
     *
     * @param url               URL do endpoint.
     * @param contentType       Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param params            Map com os parâmetros adicionais.
     * @param logAll            Define se a requisição inteira deve ser logada.
     * @param headers           Map com cabeçalhos HTTP.
     * @param body              Corpo da requisição.
     * @param tokenType         Tipo de token (ex: Bearer).
     * @param accessToken       Token de acesso.
     * @param connectionTimeout Timeout de conexão.
     * @param readTimeout       Timeout de leitura.
     * @param retryCount        Número de tentativas em caso de falha.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response postMethod(String url, ContentType contentType, boolean urlEncodingEnabled,
                                  Map<String, Object> params, Boolean logAll, Map<String, String> headers,
                                  Map<String, Object> body, String tokenType, String accessToken,
                                  Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return postMethod(url, contentType, urlEncodingEnabled, params, logAll, headers, body,
                tokenType, accessToken);
    }

    /**
     * Método para realizar uma requisição POST com autenticação (token), cabeçalhos, corpo e username/password.
     *
     * @param url               URL do endpoint.
     * @param contentType       Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param logAll            Define se a requisição inteira deve ser logada.
     * @param headers           Map com cabeçalhos HTTP.
     * @param body              Corpo da requisição.
     * @param userName          Mapa com o nome de usuário.
     * @param password          Mapa com a senha.
     * @param tokenType         Tipo de token (ex: Bearer).
     * @param accessToken       Token de acesso.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response postMethod(String url, ContentType contentType, boolean urlEncodingEnabled,
                                  Boolean logAll, Map<String, String> headers, Map<String, Object> body,
                                  Map<String, Object> userName, Map<String, Object> password,
                                  String tokenType, String accessToken) {
    	return executeWithRetry(() -> {
    		try {
    	           response = given().contentType(contentType).relaxedHTTPSValidation()
    	                    .urlEncodingEnabled(urlEncodingEnabled).log().all(logAll)
    	                    .headers("Authorization", tokenType + " " + accessToken).headers(headers)
    	                    .body(userName).body(password).body(new Gson().toJson(body)).post(url).then()
    	                    .extract().response();
    	            log.info(defaultFirstMessage + postMessage + defaultLastMessage + "url=" + url
    	                    + ", token=" + tokenType + " " + accessToken + ", contentType=" + contentType
    	                    + ", body=" + body);
    	        } catch (Exception e) {
    	            log.error("error: " + e);
    	        }
    	        return response;
    	});
    }

    /**
     * Método para realizar uma requisição POST com autenticação (token), cabeçalhos, corpo,
     * username/password, incluindo configuração de timeout e tentativas de retry.
     *
     * @param url               URL do endpoint.
     * @param contentType       Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param logAll            Define se a requisição inteira deve ser logada.
     * @param headers           Map com cabeçalhos HTTP.
     * @param body              Corpo da requisição.
     * @param userName          Mapa com o nome de usuário.
     * @param password          Mapa com a senha.
     * @param tokenType         Tipo de token (ex: Bearer).
     * @param accessToken       Token de acesso.
     * @param connectionTimeout Timeout de conexão.
     * @param readTimeout       Timeout de leitura.
     * @param retryCount        Número de tentativas em caso de falha.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response postMethod(String url, ContentType contentType, boolean urlEncodingEnabled,
                                  Boolean logAll, Map<String, String> headers, Map<String, Object> body,
                                  Map<String, Object> userName, Map<String, Object> password,
                                  String tokenType, String accessToken, Integer connectionTimeout,
                                  Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return postMethod(url, contentType, urlEncodingEnabled, logAll, headers, body, userName,
                password, tokenType, accessToken);
    }

}
