package controller.request.methods;

import static io.restassured.RestAssured.given;

import java.util.Map;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class HeadRequest extends GetRequest {
    
    private String headMessage = "head ";

    /**
     * Realiza uma requisição HEAD simples a uma URL.
     *
     * @param url URL do endpoint onde a requisição será realizada.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response headMethod(String url) {
        return executeWithRetry(() -> {
            try {
                response = given().when().head(url);
                log.info(defaultFirstMessage + headMessage + defaultLastMessage + "url=" + url);
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
        });
    }

    /**
     * Realiza uma requisição HEAD simples a uma URL com configuração de timeout e retry.
     *
     * @param url               URL do endpoint.
     * @param connectionTimeout  Tempo limite de conexão.
     * @param readTimeout        Tempo limite de leitura.
     * @param retryCount         Número de tentativas de repetição.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response headMethod(String url, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return headMethod(url);
    }

    /**
     * Realiza uma requisição HEAD com autenticação (token).
     *
     * @param url         URL do endpoint.
     * @param tokenType   Tipo de token (ex: Bearer).
     * @param accessToken Token de acesso.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response headMethod(String url, String tokenType, String accessToken) {
        return executeWithRetry(() -> {
            try {
                response = given().headers("Authorization", tokenType + " " + accessToken).when().head(url);
                log.info(defaultFirstMessage + headMessage + defaultLastMessage + "url=" + url + ", headers=(Authorization: "
                        + tokenType + " " + accessToken + ")");
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
        });
    }

    /**
     * Realiza uma requisição HEAD com autenticação (token) e configuração de timeout e retry.
     *
     * @param url               URL do endpoint.
     * @param tokenType         Tipo de token (ex: Bearer).
     * @param accessToken       Token de acesso.
     * @param connectionTimeout  Tempo limite de conexão.
     * @param readTimeout        Tempo limite de leitura.
     * @param retryCount         Número de tentativas de repetição.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response headMethod(String url, String tokenType, String accessToken, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return headMethod(url, tokenType, accessToken);
    }

    /**
     * Realiza uma requisição HEAD com cabeçalhos adicionais.
     *
     * @param url     URL do endpoint.
     * @param headers Map com cabeçalhos HTTP adicionais.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response headMethod(String url, Map<String, String> headers) {
        return executeWithRetry(() -> {
            try {
                response = given().headers(headers).when().head(url);
                log.info(defaultFirstMessage + headMessage + defaultLastMessage + "url=" + url + ", headers=("
                        + headers.toString() + ")");
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
        });
    }

    /**
     * Realiza uma requisição HEAD com cabeçalhos adicionais e configuração de timeout e retry.
     *
     * @param url               URL do endpoint.
     * @param headers           Map com cabeçalhos HTTP adicionais.
     * @param connectionTimeout  Tempo limite de conexão.
     * @param readTimeout        Tempo limite de leitura.
     * @param retryCount         Número de tentativas de repetição.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response headMethod(String url, Map<String, String> headers, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return headMethod(url, headers);
    }

    /**
     * Realiza uma requisição HEAD com cabeçalhos e token de autenticação.
     *
     * @param url         URL do endpoint.
     * @param headers     Map com cabeçalhos HTTP adicionais.
     * @param tokenType   Tipo de token (ex: Bearer).
     * @param accessToken Token de acesso.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response headMethod(String url, Map<String, String> headers, String tokenType, String accessToken) {
        return executeWithRetry(() -> {
            try {
                response = given().headers("Authorization", tokenType + " " + accessToken).headers(headers).when()
                        .head(url);
                log.info(defaultFirstMessage + headMessage + defaultLastMessage + "url=" + url
                        + ", headers=(Authorization: " + tokenType + " " + accessToken + ", " + headers.toString() + ")");
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
        });
    }

    /**
     * Realiza uma requisição HEAD com cabeçalhos e token de autenticação, com configuração de timeout e retry.
     *
     * @param url               URL do endpoint.
     * @param headers           Map com cabeçalhos HTTP adicionais.
     * @param tokenType         Tipo de token (ex: Bearer).
     * @param accessToken       Token de acesso.
     * @param connectionTimeout  Tempo limite de conexão.
     * @param readTimeout        Tempo limite de leitura.
     * @param retryCount         Número de tentativas de repetição.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response headMethod(String url, Map<String, String> headers, String tokenType, String accessToken, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return headMethod(url, headers, tokenType, accessToken);
    }

    /**
     * Realiza uma requisição HEAD com cabeçalhos e parâmetros de consulta (query params).
     *
     * @param url         URL do endpoint.
     * @param headers     Map com cabeçalhos HTTP.
     * @param queryParams Map com os parâmetros de consulta.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response headMethod(String url, Map<String, String> headers, Map<String, Object> queryParams) {
        return executeWithRetry(() -> {
            try {
                response = given().headers(headers).queryParams(queryParams).when().head(url);
                log.info(defaultFirstMessage + headMessage + defaultLastMessage + "url=" + url + ", headers=("
                        + headers.toString() + "), queryParams=(" + queryParams.toString() + ")");
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
        });
    }

    /**
     * Realiza uma requisição HEAD com cabeçalhos e parâmetros de consulta (query params), com configuração de timeout e retry.
     *
     * @param url               URL do endpoint.
     * @param headers           Map com cabeçalhos HTTP.
     * @param queryParams       Map com os parâmetros de consulta.
     * @param connectionTimeout  Tempo limite de conexão.
     * @param readTimeout        Tempo limite de leitura.
     * @param retryCount         Número de tentativas de repetição.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response headMethod(String url, Map<String, String> headers, Map<String, Object> queryParams, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return headMethod(url, headers, queryParams);
    }

    /**
     * Realiza uma requisição HEAD com tipo de conteúdo, cabeçalhos e parâmetros de consulta (query params).
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
    public Response headMethod(String url, ContentType contentType, boolean urlEncodingEnabled, Boolean logAll,
                                  Map<String, String> headers, Map<String, Object> queryParams, String tokenType, String accessToken) {
        return executeWithRetry(() -> {
            try {
                response = given().contentType(contentType).relaxedHTTPSValidation().urlEncodingEnabled(urlEncodingEnabled)
                        .log().all(logAll).headers("Authorization", tokenType + " " + accessToken).headers(headers)
                        .queryParams(queryParams).when().head(url).then().extract().response();
                log.info(defaultFirstMessage + headMessage + defaultLastMessage + "url=" + url + ", contentType="
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
     * Realiza uma requisição HEAD com tipo de conteúdo, cabeçalhos e parâmetros de consulta (query params),
     * com configuração de timeout e retry.
     *
     * @param url               URL do endpoint.
     * @param contentType       Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param logAll            Boolean para logar a requisição inteira.
     * @param headers           Map com cabeçalhos HTTP.
     * @param queryParams       Map com os parâmetros de consulta.
     * @param tokenType         Tipo de token (ex: Bearer).
     * @param accessToken       Token de acesso.
     * @param connectionTimeout  Tempo limite de conexão.
     * @param readTimeout        Tempo limite de leitura.
     * @param retryCount         Número de tentativas de repetição.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response headMethod(String url, ContentType contentType, boolean urlEncodingEnabled, Boolean logAll,
                                  Map<String, String> headers, Map<String, Object> queryParams, String tokenType, String accessToken,
                                  Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return headMethod(url, contentType, urlEncodingEnabled, logAll, headers, queryParams, tokenType, accessToken);
    }

    /**
     * Realiza uma requisição HEAD com tipo de conteúdo, cabeçalhos e parâmetros de consulta (query params) e corpo da requisição.
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
    public Response headMethod(String url, ContentType contentType, boolean urlEncodingEnabled, Boolean logAll,
                                  Map<String, String> headers, Map<String, Object> queryParams, Map<String, Object> body, String tokenType,
                                  String accessToken) {
        return executeWithRetry(() -> {
            try {
                response = given().contentType(contentType).relaxedHTTPSValidation().urlEncodingEnabled(urlEncodingEnabled)
                        .log().all(logAll).headers("Authorization", tokenType + " " + accessToken).headers(headers)
                        .queryParams(queryParams).body(body).when().head(url).then().extract().response();
                log.info(defaultFirstMessage + headMessage + defaultLastMessage + "url=" + url + ", contentType="
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
     * Realiza uma requisição HEAD com tipo de conteúdo, cabeçalhos, parâmetros de consulta (query params) e corpo da requisição,
     * com configuração de timeout e retry.
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
     * @param connectionTimeout  Tempo limite de conexão.
     * @param readTimeout        Tempo limite de leitura.
     * @param retryCount         Número de tentativas de repetição.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response headMethod(String url, ContentType contentType, boolean urlEncodingEnabled, Boolean logAll,
                                  Map<String, String> headers, Map<String, Object> queryParams, Map<String, Object> body, String tokenType,
                                  String accessToken, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return headMethod(url, contentType, urlEncodingEnabled, logAll, headers, queryParams, body, tokenType, accessToken);
    }

    /**
     * Realiza uma requisição HEAD com tipo de conteúdo, cabeçalhos, parâmetros de URL e corpo da requisição.
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
    public Response headMethod(String url, ContentType contentType, boolean urlEncodingEnabled,
                                  Map<String, Object> params, Boolean logAll, Map<String, String> headers, String tokenType,
                                  String accessToken) {
        return executeWithRetry(() -> {
            try {
                response = given().contentType(contentType).relaxedHTTPSValidation().urlEncodingEnabled(urlEncodingEnabled)
                        .log().all(logAll).headers("Authorization", tokenType + " " + accessToken).headers(headers)
                        .params(params).when().head(url).then().extract().response();
                log.info(defaultFirstMessage + headMessage + defaultLastMessage + "url=" + url + ", contentType="
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
     * Realiza uma requisição HEAD com tipo de conteúdo, cabeçalhos, parâmetros de URL e corpo da requisição,
     * com configuração de timeout e retry.
     *
     * @param url               URL do endpoint.
     * @param contentType       Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param params            Parâmetros da URL.
     * @param logAll            Boolean para logar a requisição inteira.
     * @param headers           Map com cabeçalhos HTTP.
     * @param tokenType         Tipo de token (ex: Bearer).
     * @param accessToken       Token de acesso.
     * @param connectionTimeout  Tempo limite de conexão.
     * @param readTimeout        Tempo limite de leitura.
     * @param retryCount         Número de tentativas de repetição.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response headMethod(String url, ContentType contentType, boolean urlEncodingEnabled,
                                  Map<String, Object> params, Boolean logAll, Map<String, String> headers, String tokenType,
                                  String accessToken, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return headMethod(url, contentType, urlEncodingEnabled, params, logAll, headers, tokenType, accessToken);
    }
}
