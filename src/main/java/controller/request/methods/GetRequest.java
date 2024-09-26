package controller.request.methods;

import static io.restassured.RestAssured.given;

import java.util.Map;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class GetRequest extends DeleteRequest {

    private String getMessage = "get ";

    /**
     * Realiza uma requisição GET simples a uma URL.
     *
     * @param url URL do endpoint onde a requisição será realizada.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response getMethod(String url) {
        return executeWithRetry(() -> {
            try {
                response = given().when().get(url);
                log.info(defaultFirstMessage + getMessage + defaultLastMessage + "url=" + url);
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
        });
    }

    /**
     * Realiza uma requisição GET simples a uma URL com configuração de timeout e retry.
     *
     * @param url               URL do endpoint.
     * @param connectionTimeout  Tempo limite de conexão.
     * @param readTimeout        Tempo limite de leitura.
     * @param retryCount         Número de tentativas de repetição.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response getMethod(String url, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return getMethod(url);
    }

    /**
     * Realiza uma requisição GET com cabeçalhos.
     *
     * @param url     URL do endpoint.
     * @param headers Map com cabeçalhos HTTP adicionais.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response getMethod(String url, Map<String, String> headers) {
        return executeWithRetry(() -> {
            try {
                response = given().relaxedHTTPSValidation().headers(headers).when().get(url);
                log.info(defaultFirstMessage + getMessage + defaultLastMessage + "url=" + url + ", headers=(" + headers.toString() + ")");
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
        });
    }

    /**
     * Realiza uma requisição GET com cabeçalhos e configuração de timeout e retry.
     *
     * @param url               URL do endpoint.
     * @param headers           Map com cabeçalhos HTTP adicionais.
     * @param connectionTimeout  Tempo limite de conexão.
     * @param readTimeout        Tempo limite de leitura.
     * @param retryCount         Número de tentativas de repetição.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response getMethod(String url, Map<String, String> headers, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return getMethod(url, headers);
    }

    /**
     * Realiza uma requisição GET com proxy.
     *
     * @param url   URL do endpoint.
     * @param proxy Proxy para a requisição.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response getMethod(String url, String proxy) {
        return executeWithRetry(() -> {
            try {
                response = given().relaxedHTTPSValidation().proxy(proxy).when().get(url);
                log.info(defaultFirstMessage + getMessage + defaultLastMessage + "url=" + url + ", proxy=" + proxy);
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
        });
    }

    /**
     * Realiza uma requisição GET com proxy e configuração de timeout e retry.
     *
     * @param url               URL do endpoint.
     * @param proxy             Proxy para a requisição.
     * @param connectionTimeout  Tempo limite de conexão.
     * @param readTimeout        Tempo limite de leitura.
     * @param retryCount         Número de tentativas de repetição.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response getMethod(String url, String proxy, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return getMethod(url, proxy);
    }

    /**
     * Realiza uma requisição GET com parâmetros de consulta e cabeçalhos.
     *
     * @param url               URL do endpoint.
     * @param contentType       Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param logAll            Boolean para logar a requisição inteira.
     * @param headers           Map com cabeçalhos HTTP.
     * @param queryParams       Map com os parâmetros de consulta.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response getMethod(String url, ContentType contentType, Boolean urlEncodingEnabled, Boolean logAll,
                                 Map<String, String> headers, Map<String, Object> queryParams) {
        return executeWithRetry(() -> {
            try {
                response = given().contentType(contentType).relaxedHTTPSValidation().urlEncodingEnabled(urlEncodingEnabled)
                        .log().all(logAll).headers(headers).queryParams(queryParams).get(url).then().extract().response();
                log.info(defaultFirstMessage + getMessage + defaultLastMessage + "url=" + url + ", contentType=" + contentType
                        + ", urlEncodingEnabled=" + urlEncodingEnabled + ", logAll=" + logAll + ", headers=(" + headers.toString()
                        + "), queryParams=(" + queryParams.toString() + ")");
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
        });
    }

    /**
     * Realiza uma requisição GET com parâmetros de consulta, cabeçalhos e configuração de timeout e retry.
     *
     * @param url               URL do endpoint.
     * @param contentType       Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param logAll            Boolean para logar a requisição inteira.
     * @param headers           Map com cabeçalhos HTTP.
     * @param queryParams       Map com os parâmetros de consulta.
     * @param connectionTimeout  Tempo limite de conexão.
     * @param readTimeout        Tempo limite de leitura.
     * @param retryCount         Número de tentativas de repetição.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response getMethod(String url, ContentType contentType, Boolean urlEncodingEnabled, Boolean logAll,
                                 Map<String, String> headers, Map<String, Object> queryParams, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return getMethod(url, contentType, urlEncodingEnabled, logAll, headers, queryParams);
    }

    /**
     * Realiza uma requisição GET com parâmetros de URL e cabeçalhos.
     *
     * @param url               URL do endpoint.
     * @param contentType       Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param params            Parâmetros da URL.
     * @param logAll            Boolean para logar a requisição inteira.
     * @param headers           Map com cabeçalhos HTTP.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response getMethod(String url, ContentType contentType, boolean urlEncodingEnabled,
                                 Map<String, Object> params, Boolean logAll, Map<String, String> headers) {
        return executeWithRetry(() -> {
            try {
                response = given().contentType(contentType).relaxedHTTPSValidation().urlEncodingEnabled(urlEncodingEnabled)
                        .log().all(logAll).headers(headers).params(params).get(url).then().extract().response();
                log.info(defaultFirstMessage + getMessage + defaultLastMessage + "url=" + url + ", contentType=" + contentType
                        + ", urlEncodingEnabled=" + urlEncodingEnabled + ", logAll=" + logAll + ", headers=(" + headers.toString()
                        + "), params=(" + params.toString() + ")");
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
        });
    }

    /**
     * Realiza uma requisição GET com parâmetros de URL, cabeçalhos e configuração de timeout e retry.
     *
     * @param url               URL do endpoint.
     * @param contentType       Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param params            Parâmetros da URL.
     * @param logAll            Boolean para logar a requisição inteira.
     * @param headers           Map com cabeçalhos HTTP.
     * @param connectionTimeout  Tempo limite de conexão.
     * @param readTimeout        Tempo limite de leitura.
     * @param retryCount         Número de tentativas de repetição.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response getMethod(String url, ContentType contentType, boolean urlEncodingEnabled,
                                 Map<String, Object> params, Boolean logAll, Map<String, String> headers, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return getMethod(url, contentType, urlEncodingEnabled, params, logAll, headers);
    }

    /**
     * Realiza uma requisição GET com parâmetros de consulta, cabeçalhos e token.
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
    public Response getMethod(String url, ContentType contentType, Boolean urlEncodingEnabled, Boolean logAll,
                                 Map<String, String> headers, Map<String, Object> queryParams, String tokenType, String accessToken) {
        return executeWithRetry(() -> {
            try {
                response = given().contentType(contentType).relaxedHTTPSValidation().urlEncodingEnabled(urlEncodingEnabled)
                        .log().all(logAll).headers("Authorization", tokenType + " " + accessToken).headers(headers)
                        .queryParams(queryParams).get(url).then().extract().response();
                log.info(defaultFirstMessage + getMessage + defaultLastMessage + "url=" + url + ", contentType=" + contentType
                        + ", urlEncodingEnabled=" + urlEncodingEnabled + ", logAll=" + logAll + ", headers=(Authorization: "
                        + tokenType + " " + accessToken + ", " + headers.toString() + "), queryParams=(" + queryParams.toString() + ")");
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
        });
    }

    /**
     * Realiza uma requisição GET com parâmetros de consulta, cabeçalhos, token e configuração de timeout e retry.
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
    public Response getMethod(String url, ContentType contentType, Boolean urlEncodingEnabled, Boolean logAll,
                                 Map<String, String> headers, Map<String, Object> queryParams, String tokenType, String accessToken,
                                 Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return getMethod(url, contentType, urlEncodingEnabled, logAll, headers, queryParams, tokenType, accessToken);
    }

    /**
     * Realiza uma requisição GET com parâmetros de URL, cabeçalhos e token.
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
    public Response getMethod(String url, ContentType contentType, boolean urlEncodingEnabled,
                                 Map<String, Object> params, Boolean logAll, Map<String, String> headers, String tokenType,
                                 String accessToken) {
        return executeWithRetry(() -> {
            try {
                response = given().contentType(contentType).relaxedHTTPSValidation().urlEncodingEnabled(urlEncodingEnabled)
                        .log().all(logAll).headers("Authorization", tokenType + " " + accessToken).headers(headers)
                        .params(params).get(url).then().extract().response();
                log.info(defaultFirstMessage + getMessage + defaultLastMessage + "url=" + url + ", contentType=" + contentType
                        + ", urlEncodingEnabled=" + urlEncodingEnabled + ", logAll=" + logAll + ", headers=(Authorization: "
                        + tokenType + " " + accessToken + ", " + headers.toString() + "), params=(" + params.toString() + ")");
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
        });
    }

    /**
     * Realiza uma requisição GET com parâmetros de URL, cabeçalhos, token e configuração de timeout e retry.
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
    public Response getMethod(String url, ContentType contentType, boolean urlEncodingEnabled,
                                 Map<String, Object> params, Boolean logAll, Map<String, String> headers, String tokenType,
                                 String accessToken, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return getMethod(url, contentType, urlEncodingEnabled, params, logAll, headers, tokenType, accessToken);
    }
}
