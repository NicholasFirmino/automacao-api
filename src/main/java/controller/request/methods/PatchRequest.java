package controller.request.methods;

import static io.restassured.RestAssured.given;

import java.util.Map;

import com.google.gson.Gson;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class PatchRequest extends OptionsRequest {

    private String patchMessage = "patch ";

    /**
     * Método para realizar uma requisição PATCH simples com um corpo (body).
     *
     * @param url  URL do endpoint.
     * @param body Mapa com os dados a serem enviados no corpo da requisição.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response patchMethod(String url, Map<String, Object> body) {
        return executeWithRetry(() -> {
            try {
                response = given().body(body).when().patch(url);
                log.info(defaultFirstMessage + patchMessage + defaultLastMessage + "url=" + url + ", body=" + body);
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
        });
    }

    /**
     * Método PATCH simples com corpo, incluindo configuração de timeout e tentativas de retry.
     *
     * @param url               URL do endpoint.
     * @param body              Mapa com os dados a serem enviados no corpo da requisição.
     * @param connectionTimeout Timeout de conexão.
     * @param readTimeout       Timeout de leitura.
     * @param retryCount        Número de tentativas em caso de falha.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response patchMethod(String url, Map<String, Object> body, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return patchMethod(url, body);
    }

    /**
     * Método PATCH com autenticação (token completo).
     *
     * @param url           URL do endpoint.
     * @param body          Mapa com os dados a serem enviados no corpo da requisição.
     * @param tokenAndType  Token completo de autenticação (ex: Bearer token).
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response patchMethod(String url, Map<String, Object> body, String tokenAndType) {
        return executeWithRetry(() -> {
            try {
                response = given().body(body).headers("Authorization", tokenAndType).when().patch(url);
                log.info(defaultFirstMessage + patchMessage + defaultLastMessage + "url=" + url + ", body=" + body + ", Authorization=" + tokenAndType);
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
        });
    }

    /**
     * Método PATCH com autenticação (token completo), incluindo timeout e retry.
     *
     * @param url               URL do endpoint.
     * @param body              Mapa com os dados a serem enviados no corpo da requisição.
     * @param tokenAndType      Token completo de autenticação.
     * @param connectionTimeout Timeout de conexão.
     * @param readTimeout       Timeout de leitura.
     * @param retryCount        Número de tentativas em caso de falha.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response patchMethod(String url, Map<String, Object> body, String tokenAndType, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return patchMethod(url, body, tokenAndType);
    }

    /**
     * Método PATCH com autenticação usando token separado (tokenType e accessToken).
     *
     * @param url         URL do endpoint.
     * @param body        Mapa com os dados a serem enviados no corpo da requisição.
     * @param tokenType   Tipo de token (ex: Bearer).
     * @param accessToken Token de acesso.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response patchMethod(String url, Map<String, Object> body, String tokenType, String accessToken) {
        return executeWithRetry(() -> {
            try {
                response = given().body(body).headers("Authorization", tokenType + " " + accessToken).when().patch(url);
                log.info(defaultFirstMessage + patchMessage + defaultLastMessage + "url=" + url + ", body=" + body + ", Authorization=" + tokenType + " " + accessToken);
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
        });
    }

    /**
     * Método PATCH com autenticação usando token separado, incluindo timeout e retry.
     *
     * @param url               URL do endpoint.
     * @param body              Mapa com os dados a serem enviados no corpo da requisição.
     * @param tokenType         Tipo de token.
     * @param accessToken       Token de acesso.
     * @param connectionTimeout Timeout de conexão.
     * @param readTimeout       Timeout de leitura.
     * @param retryCount        Número de tentativas em caso de falha.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response patchMethod(String url, Map<String, Object> body, String tokenType, String accessToken, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return patchMethod(url, body, tokenType, accessToken);
    }

    /**
     * Método PATCH com cabeçalhos e corpo da requisição.
     *
     * @param url               URL do endpoint.
     * @param contentType       Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param logAll            Define se a requisição inteira deve ser logada.
     * @param headers           Cabeçalhos HTTP.
     * @param body              Corpo da requisição.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response patchMethod(String url, ContentType contentType, boolean urlEncodingEnabled, Boolean logAll, Map<String, String> headers, Map<String, Object> body) {
        return executeWithRetry(() -> {
            try {
                response = given().contentType(contentType).relaxedHTTPSValidation().urlEncodingEnabled(urlEncodingEnabled)
                        .log().all(logAll).headers(headers).body(new Gson().toJson(body)).when().patch(url).then().extract().response();
                log.info(defaultFirstMessage + patchMessage + defaultLastMessage + "url=" + url + ", contentType=" + contentType + ", body=" + body);
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
        });
    }

    /**
     * Método PATCH com cabeçalhos e corpo, incluindo timeout e retry.
     *
     * @param url               URL do endpoint.
     * @param contentType       Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param logAll            Define se a requisição inteira deve ser logada.
     * @param headers           Cabeçalhos HTTP.
     * @param body              Corpo da requisição.
     * @param connectionTimeout Timeout de conexão.
     * @param readTimeout       Timeout de leitura.
     * @param retryCount        Número de tentativas em caso de falha.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response patchMethod(String url, ContentType contentType, boolean urlEncodingEnabled, Boolean logAll, Map<String, String> headers, Map<String, Object> body, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return patchMethod(url, contentType, urlEncodingEnabled, logAll, headers, body);
    }

    /**
     * Método PATCH com queryParams e corpo.
     *
     * @param url               URL do endpoint.
     * @param contentType       Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param logAll            Define se a requisição inteira deve ser logada.
     * @param headers           Cabeçalhos HTTP.
     * @param queryParams       Parâmetros de consulta (query params).
     * @param body              Corpo da requisição.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response patchMethod(String url, ContentType contentType, boolean urlEncodingEnabled, Boolean logAll, Map<String, String> headers, Map<String, Object> queryParams, Map<String, Object> body) {
        return executeWithRetry(() -> {
            try {
                response = given().contentType(contentType).relaxedHTTPSValidation().urlEncodingEnabled(urlEncodingEnabled)
                        .log().all(logAll).headers(headers).queryParams(queryParams).body(new Gson().toJson(body)).when().patch(url)
                        .then().extract().response();
                log.info(defaultFirstMessage + patchMessage + defaultLastMessage + "url=" + url + ", contentType=" + contentType + ", queryParams=" + queryParams + ", body=" + body);
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
        });
    }

    /**
     * Método PATCH com queryParams, corpo, timeout e retry.
     *
     * @param url               URL do endpoint.
     * @param contentType       Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param logAll            Define se a requisição inteira deve ser logada.
     * @param headers           Cabeçalhos HTTP.
     * @param queryParams       Parâmetros de consulta (query params).
     * @param body              Corpo da requisição.
     * @param connectionTimeout Timeout de conexão.
     * @param readTimeout       Timeout de leitura.
     * @param retryCount        Número de tentativas em caso de falha.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response patchMethod(String url, ContentType contentType, boolean urlEncodingEnabled, Boolean logAll, Map<String, String> headers, Map<String, Object> queryParams, Map<String, Object> body, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return patchMethod(url, contentType, urlEncodingEnabled, logAll, headers, queryParams, body);
    }


    /**
     * Método para realizar uma requisição PATCH com autenticação e cabeçalhos.
     *
     * @param url               URL do endpoint.
     * @param contentType       Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita a codificação de URL.
     * @param logAll            Define se a requisição inteira deve ser logada.
     * @param headers           Map com cabeçalhos HTTP adicionais.
     * @param body              Corpo da requisição.
     * @param tokenType         Tipo de token (ex: Bearer).
     * @param accessToken       Token de acesso.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response patchMethod(String url, ContentType contentType, boolean urlEncodingEnabled, Boolean logAll, Map<String, String> headers, Map<String, Object> body, String tokenType, String accessToken) {
        return executeWithRetry(() -> {
            try {
                response = given().contentType(contentType).relaxedHTTPSValidation().urlEncodingEnabled(urlEncodingEnabled)
                        .log().all(logAll).headers("Authorization", tokenType + " " + accessToken).headers(headers)
                        .body(new Gson().toJson(body)).when().patch(url).then().extract().response();
                log.info(defaultFirstMessage + patchMessage + defaultLastMessage + "url=" + url + ", contentType=" + contentType + ", tokenType=" + tokenType + ", accessToken=" + accessToken + ", body=" + body);
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
        });
    }

    /**
     * Método PATCH com autenticação, cabeçalhos, timeout e retry.
     *
     * @param url               URL do endpoint.
     * @param contentType       Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita a codificação de URL.
     * @param logAll            Define se a requisição inteira deve ser logada.
     * @param headers           Map com cabeçalhos HTTP adicionais.
     * @param body              Corpo da requisição.
     * @param tokenType         Tipo de token (ex: Bearer).
     * @param accessToken       Token de acesso.
     * @param connectionTimeout Timeout de conexão.
     * @param readTimeout       Timeout de leitura.
     * @param retryCount        Número de tentativas em caso de falha.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response patchMethod(String url, ContentType contentType, boolean urlEncodingEnabled, Boolean logAll, Map<String, String> headers, Map<String, Object> body, String tokenType, String accessToken, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return patchMethod(url, contentType, urlEncodingEnabled, logAll, headers, body, tokenType, accessToken);
    }

    /**
     * Método PATCH com parâmetros da URL e corpo da requisição.
     *
     * @param url               URL do endpoint.
     * @param contentType       Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita a codificação de URL.
     * @param params            Map com parâmetros da URL.
     * @param logAll            Define se a requisição inteira deve ser logada.
     * @param headers           Map com cabeçalhos HTTP adicionais.
     * @param body              Corpo da requisição.
     * @param tokenType         Tipo de token (ex: Bearer).
     * @param accessToken       Token de acesso.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response patchMethod(String url, ContentType contentType, boolean urlEncodingEnabled, Map<String, Object> params, Boolean logAll, Map<String, String> headers, Map<String, Object> body, String tokenType, String accessToken) {
        return executeWithRetry(() -> {
            try {
                response = given().contentType(contentType).relaxedHTTPSValidation().urlEncodingEnabled(urlEncodingEnabled)
                        .log().all(logAll).headers("Authorization", tokenType + " " + accessToken).headers(headers)
                        .params(params).body(new Gson().toJson(body)).when().patch(url).then().extract().response();
                log.info(defaultFirstMessage + patchMessage + defaultLastMessage + "url=" + url + ", contentType=" + contentType + ", tokenType=" + tokenType + ", accessToken=" + accessToken + ", params=" + params + ", body=" + body);
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
        });
    }

    /**
     * Método PATCH com parâmetros da URL, corpo, timeout e retry.
     *
     * @param url               URL do endpoint.
     * @param contentType       Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita a codificação de URL.
     * @param params            Map com parâmetros da URL.
     * @param logAll            Define se a requisição inteira deve ser logada.
     * @param headers           Map com cabeçalhos HTTP adicionais.
     * @param body              Corpo da requisição.
     * @param tokenType         Tipo de token (ex: Bearer).
     * @param accessToken       Token de acesso.
     * @param connectionTimeout Timeout de conexão.
     * @param readTimeout       Timeout de leitura.
     * @param retryCount        Número de tentativas em caso de falha.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response patchMethod(String url, ContentType contentType, boolean urlEncodingEnabled, Map<String, Object> params, Boolean logAll, Map<String, String> headers, Map<String, Object> body, String tokenType, String accessToken, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return patchMethod(url, contentType, urlEncodingEnabled, params, logAll, headers, body, tokenType, accessToken);
    }

    /**
     * Método PATCH com autenticação via username e password.
     *
     * @param url               URL do endpoint.
     * @param contentType       Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita a codificação de URL.
     * @param logAll            Define se a requisição inteira deve ser logada.
     * @param headers           Map com cabeçalhos HTTP adicionais.
     * @param body              Corpo da requisição.
     * @param userName          Mapa contendo username.
     * @param password          Mapa contendo password.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response patchMethod(String url, ContentType contentType, boolean urlEncodingEnabled, Boolean logAll, Map<String, String> headers, Map<String, Object> body, Map<String, Object> userName, Map<String, Object> password) {
        return executeWithRetry(() -> {
            try {
                response = given().contentType(contentType).relaxedHTTPSValidation().urlEncodingEnabled(urlEncodingEnabled)
                        .log().all(logAll).headers(headers).body(userName).body(password).body(new Gson().toJson(body)).when().patch(url).then().extract().response();
                log.info(defaultFirstMessage + patchMessage + defaultLastMessage + "url=" + url + ", contentType=" + contentType + ", userName=" + userName + ", password=" + password + ", body=" + body);
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
        });
    }

    /**
     * Método PATCH com username, password, timeout e retry.
     *
     * @param url               URL do endpoint.
     * @param contentType       Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita a codificação de URL.
     * @param logAll            Define se a requisição inteira deve ser logada.
     * @param headers           Map com cabeçalhos HTTP adicionais.
     * @param body              Corpo da requisição.
     * @param userName          Mapa contendo username.
     * @param password          Mapa contendo password.
     * @param connectionTimeout Timeout de conexão.
     * @param readTimeout       Timeout de leitura.
     * @param retryCount        Número de tentativas em caso de falha.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response patchMethod(String url, ContentType contentType, boolean urlEncodingEnabled, Boolean logAll, Map<String, String> headers, Map<String, Object> body, Map<String, Object> userName, Map<String, Object> password, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return patchMethod(url, contentType, urlEncodingEnabled, logAll, headers, body, userName, password);
    }

    /**
     * Método PATCH com queryParams, token separados e corpo.
     *
     * @param url               URL do endpoint.
     * @param contentType       Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita a codificação de URL.
     * @param logAll            Define se a requisição inteira deve ser logada.
     * @param headers           Map com cabeçalhos HTTP adicionais.
     * @param queryParams       Parâmetros de consulta (query params).
     * @param body              Corpo da requisição.
     * @param tokenType         Tipo de token (ex: Bearer).
     * @param accessToken       Token de acesso.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response patchMethod(String url, ContentType contentType, boolean urlEncodingEnabled, Boolean logAll, Map<String, String> headers, Map<String, Object> queryParams, Map<String, Object> body, String tokenType, String accessToken) {
        return executeWithRetry(() -> {
            try {
                response = given().contentType(contentType).relaxedHTTPSValidation().urlEncodingEnabled(urlEncodingEnabled)
                        .log().all(logAll).headers("Authorization", tokenType + " " + accessToken).headers(headers)
                        .queryParams(queryParams).body(new Gson().toJson(body)).when().patch(url).then().extract().response();
                log.info(defaultFirstMessage + patchMessage + defaultLastMessage + "url=" + url + ", contentType=" + contentType + ", tokenType=" + tokenType + ", accessToken=" + accessToken + ", queryParams=" + queryParams + ", body=" + body);
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
        });
    }

    /**
     * Método PATCH com queryParams, token separados, timeout e retry.
     *
     * @param url               URL do endpoint.
     * @param contentType       Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita a codificação de URL.
     * @param logAll            Define se a requisição inteira deve ser logada.
     * @param headers           Map com cabeçalhos HTTP adicionais.
     * @param queryParams       Parâmetros de consulta (query params).
     * @param body              Corpo da requisição.
     * @param tokenType         Tipo de token (ex: Bearer).
     * @param accessToken       Token de acesso.
     * @param connectionTimeout Timeout de conexão.
     * @param readTimeout       Timeout de leitura.
     * @param retryCount        Número de tentativas em caso de falha.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response patchMethod(String url, ContentType contentType, boolean urlEncodingEnabled, Boolean logAll, Map<String, String> headers, Map<String, Object> queryParams, Map<String, Object> body, String tokenType, String accessToken, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return patchMethod(url, contentType, urlEncodingEnabled, logAll, headers, queryParams, body, tokenType, accessToken);
    }

}
