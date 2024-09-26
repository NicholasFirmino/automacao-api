package controller.request.methods;

import static io.restassured.RestAssured.given;

import java.util.Map;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class OptionsRequest extends HeadRequest {

    private String optionsMessage = "options ";

    /**
     * Método para realizar uma requisição OPTIONS simples a uma URL.
     *
     * @param url URL do endpoint onde a requisição será realizada.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response optionsMethod(String url) {
        return executeWithRetry(() -> {
            try {
                response = given().when().options(url);
                log.info(defaultFirstMessage + optionsMessage + defaultLastMessage + "url=" + url);
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
        });
    }

    /**
     * Método para realizar uma requisição OPTIONS simples a uma URL com timeout e retry.
     *
     * @param url               URL do endpoint.
     * @param connectionTimeout Tempo limite de conexão.
     * @param readTimeout       Tempo limite de leitura.
     * @param retryCount        Número de tentativas.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response optionsMethod(String url, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return optionsMethod(url);
    }

    /**
     * Método para realizar uma requisição OPTIONS com autenticação (token).
     *
     * @param url         URL do endpoint.
     * @param tokenType   Tipo de token (ex: Bearer).
     * @param accessToken Token de acesso.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response optionsMethod(String url, String tokenType, String accessToken) {
        return executeWithRetry(() -> {
            try {
                response = given().headers("Authorization", tokenType + " " + accessToken).when().options(url);
                log.info(defaultFirstMessage + optionsMessage + defaultLastMessage + "url=" + url + ", headers=(Authorization: "
                        + tokenType + " " + accessToken + ")");
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
        });
    }

    /**
     * Método para realizar uma requisição OPTIONS com autenticação (token) e timeout/retry.
     *
     * @param url               URL do endpoint.
     * @param tokenType         Tipo de token (ex: Bearer).
     * @param accessToken       Token de acesso.
     * @param connectionTimeout Tempo limite de conexão.
     * @param readTimeout       Tempo limite de leitura.
     * @param retryCount        Número de tentativas.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response optionsMethod(String url, String tokenType, String accessToken, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return optionsMethod(url, tokenType, accessToken);
    }

    /**
     * Método para realizar uma requisição OPTIONS com cabeçalhos adicionais.
     *
     * @param url     URL do endpoint.
     * @param headers Map com cabeçalhos HTTP adicionais.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response optionsMethod(String url, Map<String, String> headers) {
        return executeWithRetry(() -> {
            try {
                response = given().headers(headers).when().options(url);
                log.info(defaultFirstMessage + optionsMessage + defaultLastMessage + "url=" + url + ", headers=("
                        + headers.toString() + ")");
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
        });
    }

    /**
     * Método para realizar uma requisição OPTIONS com cabeçalhos e timeout/retry.
     *
     * @param url               URL do endpoint.
     * @param headers           Map com cabeçalhos HTTP adicionais.
     * @param connectionTimeout Tempo limite de conexão.
     * @param readTimeout       Tempo limite de leitura.
     * @param retryCount        Número de tentativas.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response optionsMethod(String url, Map<String, String> headers, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return optionsMethod(url, headers);
    }

    /**
     * Método para realizar uma requisição OPTIONS com cabeçalhos e token de autenticação.
     *
     * @param url         URL do endpoint.
     * @param headers     Map com cabeçalhos HTTP adicionais.
     * @param tokenType   Tipo de token (ex: Bearer).
     * @param accessToken Token de acesso.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response optionsMethod(String url, Map<String, String> headers, String tokenType, String accessToken) {
        return executeWithRetry(() -> {
            try {
                response = given().headers("Authorization", tokenType + " " + accessToken).headers(headers).when().options(url);
                log.info(defaultFirstMessage + optionsMessage + defaultLastMessage + "url=" + url + ", headers=(Authorization: "
                        + tokenType + " " + accessToken + ", " + headers.toString() + ")");
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
        });
    }

    /**
     * Método para realizar uma requisição OPTIONS com cabeçalhos e token de autenticação, com timeout/retry.
     *
     * @param url               URL do endpoint.
     * @param headers           Map com cabeçalhos HTTP adicionais.
     * @param tokenType         Tipo de token (ex: Bearer).
     * @param accessToken       Token de acesso.
     * @param connectionTimeout Tempo limite de conexão.
     * @param readTimeout       Tempo limite de leitura.
     * @param retryCount        Número de tentativas.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response optionsMethod(String url, Map<String, String> headers, String tokenType, String accessToken, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return optionsMethod(url, headers, tokenType, accessToken);
    }

    /**
     * Método para realizar uma requisição OPTIONS com cabeçalhos e parâmetros de consulta (query params).
     *
     * @param url         URL do endpoint.
     * @param headers     Map com cabeçalhos HTTP.
     * @param queryParams Map com os parâmetros de consulta.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response optionsMethod(String url, Map<String, String> headers, Map<String, Object> queryParams) {
        return executeWithRetry(() -> {
            try {
                response = given().headers(headers).queryParams(queryParams).when().options(url);
                log.info(defaultFirstMessage + optionsMessage + defaultLastMessage + "url=" + url + ", headers=("
                        + headers.toString() + "), queryParams=(" + queryParams.toString() + ")");
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
        });
    }

    /**
     * Método para realizar uma requisição OPTIONS com cabeçalhos e parâmetros de consulta (query params), com timeout/retry.
     *
     * @param url               URL do endpoint.
     * @param headers           Map com cabeçalhos HTTP.
     * @param queryParams       Map com os parâmetros de consulta.
     * @param connectionTimeout Tempo limite de conexão.
     * @param readTimeout       Tempo limite de leitura.
     * @param retryCount        Número de tentativas.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response optionsMethod(String url, Map<String, String> headers, Map<String, Object> queryParams, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return optionsMethod(url, headers, queryParams);
    }

    /**
     * Método para realizar uma requisição OPTIONS com tipo de conteúdo, cabeçalhos e parâmetros de consulta (query params).
     *
     * @param url               URL do endpoint.
     * @param contentType       Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param logAll            Boolean para logar a requisição inteira.
     * @param headers           Map com cabeçalhos HTTP.
     * @param queryParams       Map com os parâmetros de consulta.
     * @param tokenType         Tipo de token (ex: Bearer).
     * @param accessToken       Token de acesso.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response optionsMethod(String url, ContentType contentType, Boolean urlEncodingEnabled, Boolean logAll,
                                     Map<String, String> headers, Map<String, Object> queryParams, String tokenType,
                                     String accessToken) {
        return executeWithRetry(() -> {
            try {
                response = given().contentType(contentType).relaxedHTTPSValidation().urlEncodingEnabled(urlEncodingEnabled)
                        .log().all(logAll).headers("Authorization", tokenType + " " + accessToken).headers(headers)
                        .queryParams(queryParams).when().options(url).then().extract().response();
                log.info(defaultFirstMessage + optionsMessage + defaultLastMessage + "url=" + url + ", contentType="
                        + contentType + ", urlEncodingEnabled=" + urlEncodingEnabled + ", logAll=" + logAll
                        + ", headers=(Authorization: " + tokenType + " " + accessToken + ", " + headers.toString()
                        + "), queryParams=(" + queryParams.toString() + ")");
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
        });
    }

    /**
     * Método para realizar uma requisição OPTIONS com tipo de conteúdo, cabeçalhos e parâmetros de consulta (query params), com timeout/retry.
     *
     * @param url               URL do endpoint.
     * @param contentType       Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param logAll            Boolean para logar a requisição inteira.
     * @param headers           Map com cabeçalhos HTTP.
     * @param queryParams       Map com os parâmetros de consulta.
     * @param tokenType         Tipo de token (ex: Bearer).
     * @param accessToken       Token de acesso.
     * @param connectionTimeout Tempo limite de conexão.
     * @param readTimeout       Tempo limite de leitura.
     * @param retryCount        Número de tentativas.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response optionsMethod(String url, ContentType contentType, Boolean urlEncodingEnabled, Boolean logAll,
                                     Map<String, String> headers, Map<String, Object> queryParams, String tokenType, String accessToken, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return optionsMethod(url, contentType, urlEncodingEnabled, logAll, headers, queryParams, tokenType, accessToken);
    }

    /**
     * Método para realizar uma requisição OPTIONS com tipo de conteúdo, cabeçalhos, parâmetros de consulta (query params) e corpo da requisição.
     *
     * @param url               URL do endpoint.
     * @param contentType       Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param logAll            Boolean para logar a requisição inteira.
     * @param headers           Map com cabeçalhos HTTP.
     * @param queryParams       Map com os parâmetros de consulta.
     * @param body              Corpo da requisição.
     * @param tokenType         Tipo de token (ex: Bearer).
     * @param accessToken       Token de acesso.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response optionsMethod(String url, ContentType contentType, Boolean urlEncodingEnabled, Boolean logAll,
                                     Map<String, String> headers, Map<String, Object> queryParams, Map<String, Object> body, String tokenType,
                                     String accessToken) {
        return executeWithRetry(() -> {
            try {
                response = given().contentType(contentType).relaxedHTTPSValidation().urlEncodingEnabled(urlEncodingEnabled)
                        .log().all(logAll).headers("Authorization", tokenType + " " + accessToken).headers(headers)
                        .queryParams(queryParams).body(body).when().options(url).then().extract().response();
                log.info(defaultFirstMessage + optionsMessage + defaultLastMessage + "url=" + url + ", contentType="
                        + contentType + ", urlEncodingEnabled=" + urlEncodingEnabled + ", logAll=" + logAll
                        + ", headers=(Authorization: " + tokenType + " " + accessToken + ", " + headers.toString()
                        + "), queryParams=(" + queryParams.toString() + "), body=(" + body.toString() + ")");
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
        });
    }

    /**
     * Método para realizar uma requisição OPTIONS com tipo de conteúdo, cabeçalhos, parâmetros de consulta (query params) e corpo da requisição, com timeout/retry.
     *
     * @param url               URL do endpoint.
     * @param contentType       Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param logAll            Boolean para logar a requisição inteira.
     * @param headers           Map com cabeçalhos HTTP.
     * @param queryParams       Map com os parâmetros de consulta.
     * @param body              Corpo da requisição.
     * @param tokenType         Tipo de token (ex: Bearer).
     * @param accessToken       Token de acesso.
     * @param connectionTimeout Tempo limite de conexão.
     * @param readTimeout       Tempo limite de leitura.
     * @param retryCount        Número de tentativas.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response optionsMethod(String url, ContentType contentType, Boolean urlEncodingEnabled, Boolean logAll,
                                     Map<String, String> headers, Map<String, Object> queryParams, Map<String, Object> body, String tokenType,
                                     String accessToken, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return optionsMethod(url, contentType, urlEncodingEnabled, logAll, headers, queryParams, body, tokenType, accessToken);
    }

    /**
     * Método para realizar uma requisição OPTIONS com tipo de conteúdo, cabeçalhos, parâmetros de URL e corpo da requisição.
     *
     * @param url               URL do endpoint.
     * @param contentType       Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param params            Parâmetros da URL.
     * @param logAll            Boolean para logar a requisição inteira.
     * @param headers           Map com cabeçalhos HTTP.
     * @param tokenType         Tipo de token (ex: Bearer).
     * @param accessToken       Token de acesso.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response optionsMethod(String url, ContentType contentType, Boolean urlEncodingEnabled,
                                     Map<String, Object> params, Boolean logAll, Map<String, String> headers, String tokenType,
                                     String accessToken) {
        return executeWithRetry(() -> {
            try {
                response = given().contentType(contentType).relaxedHTTPSValidation().urlEncodingEnabled(urlEncodingEnabled)
                        .log().all(logAll).headers("Authorization", tokenType + " " + accessToken).headers(headers)
                        .params(params).when().options(url).then().extract().response();
                log.info(defaultFirstMessage + optionsMessage + defaultLastMessage + "url=" + url + ", contentType="
                        + contentType + ", urlEncodingEnabled=" + urlEncodingEnabled + ", logAll=" + logAll
                        + ", headers=(Authorization: " + tokenType + " " + accessToken + ", " + headers.toString()
                        + "), params=(" + params.toString() + ")");
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
        });
    }

    /**
     * Método para realizar uma requisição OPTIONS com tipo de conteúdo, cabeçalhos, parâmetros de URL e corpo da requisição, com timeout/retry.
     *
     * @param url               URL do endpoint.
     * @param contentType       Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param params            Parâmetros da URL.
     * @param logAll            Boolean para logar a requisição inteira.
     * @param headers           Map com cabeçalhos HTTP.
     * @param tokenType         Tipo de token (ex: Bearer).
     * @param accessToken       Token de acesso.
     * @param connectionTimeout Tempo limite de conexão.
     * @param readTimeout       Tempo limite de leitura.
     * @param retryCount        Número de tentativas.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response optionsMethod(String url, ContentType contentType, Boolean urlEncodingEnabled,
                                     Map<String, Object> params, Boolean logAll, Map<String, String> headers, String tokenType,
                                     String accessToken, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return optionsMethod(url, contentType, urlEncodingEnabled, params, logAll, headers, tokenType, accessToken);
    }
}
