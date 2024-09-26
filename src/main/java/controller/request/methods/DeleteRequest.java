package controller.request.methods;

import static io.restassured.RestAssured.given;

import java.util.Map;

import com.google.gson.Gson;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class DeleteRequest extends BaseRequest {

    private String deleteMessage = "delete ";

    /**
     * Método para realizar uma requisição DELETE simples a uma URL.
     *
     * @param url URL do endpoint onde a requisição será realizada.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response deleteMethod(String url) {
        return executeWithRetry(() -> {
            try {
                response = given().config(getConfigWithTimeouts()).when().delete(url);
                log.info(defaultFirstMessage + deleteMessage + defaultLastMessage + "url=" + url);
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
        });
    }

    /**
     * Método para realizar uma requisição DELETE simples a uma URL com parâmetros de timeout e tentativas de repetição.
     *
     * @param url              URL do endpoint onde a requisição será realizada.
     * @param connectionTimeout Tempo limite de conexão (em milissegundos).
     * @param readTimeout       Tempo limite de leitura (em milissegundos).
     * @param retryCount        Número de tentativas de repetição em caso de falha.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response deleteMethod(String url, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
        this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = retryCount;
        return deleteMethod(url);
    }

    /**
     * Método para realizar uma requisição DELETE com autenticação (token).
     *
     * @param url         URL do endpoint.
     * @param tokenType   Tipo de token (ex: Bearer).
     * @param accessToken Token de acesso.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response deleteMethod(String url, String tokenType, String accessToken) {
        return executeWithRetry(() -> {
            try {
                response = given().config(getConfigWithTimeouts()).headers("Authorization", tokenType + " " + accessToken)
                        .when().delete(url);
                log.info(defaultFirstMessage + deleteMessage + defaultLastMessage + "url=" + url
                        + ", headers=(Authorization: " + tokenType + " " + accessToken + ")");
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
        });
    }

    /**
     * Método para realizar uma requisição DELETE com autenticação (token) e parâmetros de timeout e tentativas de repetição.
     *
     * @param url              URL do endpoint.
     * @param tokenType        Tipo de token (ex: Bearer).
     * @param accessToken      Token de acesso.
     * @param connectionTimeout Tempo limite de conexão (em milissegundos).
     * @param readTimeout       Tempo limite de leitura (em milissegundos).
     * @param retryCount        Número de tentativas de repetição em caso de falha.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response deleteMethod(String url, String tokenType, String accessToken, Integer connectionTimeout,
            Integer readTimeout, Integer retryCount) {
        this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = retryCount;
        return deleteMethod(url, tokenType, accessToken);
    }

    /**
     * Método para realizar uma requisição DELETE com cabeçalhos HTTP adicionais.
     *
     * @param url     URL do endpoint.
     * @param headers Map com cabeçalhos HTTP adicionais.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response deleteMethod(String url, Map<String, String> headers) {
        return executeWithRetry(() -> {
            try {
                response = given().config(getConfigWithTimeouts()).headers(headers).when().delete(url);
                log.info(defaultFirstMessage + deleteMessage + defaultLastMessage + "url=" + url + ", headers=("
                        + headers.toString() + ")");
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
        });
    }

    /**
     * Método para realizar uma requisição DELETE com cabeçalhos HTTP adicionais e parâmetros de timeout e tentativas de repetição.
     *
     * @param url              URL do endpoint.
     * @param headers          Map com cabeçalhos HTTP adicionais.
     * @param connectionTimeout Tempo limite de conexão (em milissegundos).
     * @param readTimeout       Tempo limite de leitura (em milissegundos).
     * @param retryCount        Número de tentativas de repetição em caso de falha.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response deleteMethod(String url, Map<String, String> headers, Integer connectionTimeout,
            Integer readTimeout, Integer retryCount) {
        this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = retryCount;
        return deleteMethod(url, headers);
    }

    /**
     * Método para realizar uma requisição DELETE com cabeçalhos e token de
     * autenticação.
     *
     * @param url         URL do endpoint.
     * @param headers     Map com cabeçalhos HTTP adicionais.
     * @param tokenType   Tipo de token (ex: Bearer).
     * @param accessToken Token de acesso.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response deleteMethod(String url, Map<String, String> headers, String tokenType, String accessToken) {
        return executeWithRetry(() -> {
            try {
                response = given().config(getConfigWithTimeouts()).headers("Authorization", tokenType + " " + accessToken)
                        .headers(headers).when().delete(url);
                log.info(defaultFirstMessage + deleteMessage + defaultLastMessage + "url=" + url + ", headers=(Authorization: "
                        + tokenType + " " + accessToken + ", " + headers.toString() + ")");
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
        });
    }

    /**
     * Método para realizar uma requisição DELETE com cabeçalhos, token de autenticação e parâmetros de timeout e tentativas de repetição.
     *
     * @param url              URL do endpoint.
     * @param headers          Map com cabeçalhos HTTP adicionais.
     * @param tokenType        Tipo de token (ex: Bearer).
     * @param accessToken      Token de acesso.
     * @param connectionTimeout Tempo limite de conexão (em milissegundos).
     * @param readTimeout       Tempo limite de leitura (em milissegundos).
     * @param retryCount        Número de tentativas de repetição em caso de falha.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response deleteMethod(String url, Map<String, String> headers, String tokenType, String accessToken,
            Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
        this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return deleteMethod(url, headers, tokenType, accessToken);
    }

    /**
     * Método para realizar uma requisição DELETE com cabeçalhos e parâmetros de
     * consulta (query params).
     *
     * @param url         URL do endpoint.
     * @param headers     Map com cabeçalhos HTTP.
     * @param queryParams Map com os parâmetros de consulta.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response deleteMethod(String url, Map<String, String> headers, Map<String, Object> queryParams) {
        return executeWithRetry(() -> {
            try {
                response = given().config(getConfigWithTimeouts()).headers(headers).queryParams(queryParams).when().delete(url);
                log.info(defaultFirstMessage + deleteMessage + defaultLastMessage + "url=" + url + ", headers=("
                        + headers.toString() + "), queryParams=(" + queryParams.toString() + ")");
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
        });
    }

    /**
     * Método para realizar uma requisição DELETE com cabeçalhos e parâmetros de
     * consulta (query params), e parâmetros de timeout e tentativas de repetição.
     *
     * @param url              URL do endpoint.
     * @param headers          Map com cabeçalhos HTTP.
     * @param queryParams      Map com os parâmetros de consulta.
     * @param connectionTimeout Tempo limite de conexão (em milissegundos).
     * @param readTimeout       Tempo limite de leitura (em milissegundos).
     * @param retryCount        Número de tentativas de repetição em caso de falha.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response deleteMethod(String url, Map<String, String> headers, Map<String, Object> queryParams,
            Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return deleteMethod(url, headers, queryParams);
    }

    /**
     * Método para realizar uma requisição DELETE com tipo de conteúdo, cabeçalhos e
     * parâmetros de consulta (query params).
     *
     * @param url                URL do endpoint.
     * @param contentType        Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param logAll             Boolean para logar a requisição inteira.
     * @param headers            Map com cabeçalhos HTTP.
     * @param queryParams        Map com os parâmetros de consulta.
     * @param tokenType          Tipo de token (ex: Bearer).
     * @param accessToken        Token de acesso.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response deleteMethod(String url, ContentType contentType, Boolean urlEncodingEnabled, Boolean logAll,
            Map<String, String> headers, Map<String, Object> queryParams, String tokenType, String accessToken) {
        return executeWithRetry(() -> {
            try {
                response = given().config(getConfigWithTimeouts()).contentType(contentType).relaxedHTTPSValidation()
                        .urlEncodingEnabled(urlEncodingEnabled).log().all(logAll)
                        .headers("Authorization", tokenType + " " + accessToken).headers(headers).queryParams(queryParams)
                        .when().delete(url).then().extract().response();
                log.info(defaultFirstMessage + deleteMessage + defaultLastMessage + "url=" + url + ", contentType="
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
     * Método para realizar uma requisição DELETE com tipo de conteúdo, cabeçalhos e
     * parâmetros de consulta (query params), e parâmetros de timeout e tentativas de repetição.
     *
     * @param url                URL do endpoint.
     * @param contentType        Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param logAll             Boolean para logar a requisição inteira.
     * @param headers            Map com cabeçalhos HTTP.
     * @param queryParams        Map com os parâmetros de consulta.
     * @param tokenType          Tipo de token (ex: Bearer).
     * @param accessToken        Token de acesso.
     * @param connectionTimeout  Tempo limite de conexão (em milissegundos).
     * @param readTimeout        Tempo limite de leitura (em milissegundos).
     * @param retryCount         Número de tentativas de repetição em caso de falha.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response deleteMethod(String url, ContentType contentType, Boolean urlEncodingEnabled, Boolean logAll,
            Map<String, String> headers, Map<String, Object> queryParams, String tokenType, String accessToken,
            Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return deleteMethod(url, contentType, urlEncodingEnabled, logAll, headers, queryParams, tokenType, accessToken);
    }

    /**
     * Método para realizar uma requisição DELETE com tipo de conteúdo, cabeçalhos,
     * parâmetros de consulta (query params) e corpo da requisição.
     *
     * @param url                URL do endpoint.
     * @param contentType        Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param logAll             Boolean para logar a requisição inteira.
     * @param headers            Map com cabeçalhos HTTP.
     * @param queryParams        Map com os parâmetros de consulta.
     * @param body               Corpo da requisição.
     * @param tokenType          Tipo de token (ex: Bearer).
     * @param accessToken        Token de acesso.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response deleteMethod(String url, ContentType contentType, Boolean urlEncodingEnabled, Boolean logAll,
            Map<String, String> headers, Map<String, Object> queryParams, Map<String, Object> body, String tokenType,
            String accessToken) {
        return executeWithRetry(() -> {
            try {
                response = given().config(getConfigWithTimeouts()).contentType(contentType).relaxedHTTPSValidation()
                        .urlEncodingEnabled(urlEncodingEnabled).log().all(logAll)
                        .headers("Authorization", tokenType + " " + accessToken).headers(headers).queryParams(queryParams)
                        .body(new Gson().toJson(body)).when().delete(url).then().extract().response();
                log.info(defaultFirstMessage + deleteMessage + defaultLastMessage + "url=" + url + ", contentType="
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
     * Método para realizar uma requisição DELETE com tipo de conteúdo, cabeçalhos,
     * parâmetros de consulta (query params) e corpo da requisição, e parâmetros de timeout e tentativas de repetição.
     *
     * @param url                URL do endpoint.
     * @param contentType        Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param logAll             Boolean para logar a requisição inteira.
     * @param headers            Map com cabeçalhos HTTP.
     * @param queryParams        Map com os parâmetros de consulta.
     * @param body               Corpo da requisição.
     * @param tokenType          Tipo de token (ex: Bearer).
     * @param accessToken        Token de acesso.
     * @param connectionTimeout  Tempo limite de conexão (em milissegundos).
     * @param readTimeout        Tempo limite de leitura (em milissegundos).
     * @param retryCount         Número de tentativas de repetição em caso de falha.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response deleteMethod(String url, ContentType contentType, Boolean urlEncodingEnabled, Boolean logAll,
            Map<String, String> headers, Map<String, Object> queryParams, Map<String, Object> body, String tokenType,
            String accessToken, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return deleteMethod(url, contentType, urlEncodingEnabled, logAll, headers, queryParams, body, tokenType,
                accessToken);
    }

    /**
     * Método para realizar uma requisição DELETE com tipo de conteúdo, cabeçalhos,
     * parâmetros de consulta (query params) e corpo da requisição, incluindo
     * parâmetros de URL.
     *
     * @param url                URL do endpoint.
     * @param contentType        Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param params             Parâmetros da URL.
     * @param logAll             Boolean para logar a requisição inteira.
     * @param headers            Map com cabeçalhos HTTP.
     * @param body               Corpo da requisição.
     * @param tokenType          Tipo de token (ex: Bearer).
     * @param accessToken        Token de acesso.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response deleteMethod(String url, ContentType contentType, Boolean urlEncodingEnabled,
            Map<String, Object> params, Boolean logAll, Map<String, String> headers, Map<String, Object> body,
            String tokenType, String accessToken) {
        return executeWithRetry(() -> {
            try {
                response = given().config(getConfigWithTimeouts()).contentType(contentType).relaxedHTTPSValidation()
                        .urlEncodingEnabled(urlEncodingEnabled).log().all(logAll)
                        .headers("Authorization", tokenType + " " + accessToken).headers(headers).params(params)
                        .body(new Gson().toJson(body)).when().delete(url).then().extract().response();
                log.info(defaultFirstMessage + deleteMessage + defaultLastMessage + "url=" + url + ", contentType="
                        + contentType + ", urlEncodingEnabled=" + urlEncodingEnabled + ", logAll=" + logAll
                        + ", headers=(Authorization: " + tokenType + " " + accessToken + ", " + headers.toString()
                        + "), params=(" + params.toString() + "), body=(" + body.toString() + ")");
            } catch (Exception e) {
                log.error("error: " + e);
            }
            return response;
        });
    }

    /**
     * Método para realizar uma requisição DELETE com tipo de conteúdo, cabeçalhos,
     * parâmetros de consulta (query params) e corpo da requisição, incluindo
     * parâmetros de URL, com parâmetros de timeout e tentativas de repetição.
     *
     * @param url                URL do endpoint.
     * @param contentType        Tipo de conteúdo (Content-Type).
     * @param urlEncodingEnabled Habilita ou desabilita codificação de URL.
     * @param params             Parâmetros da URL.
     * @param logAll             Boolean para logar a requisição inteira.
     * @param headers            Map com cabeçalhos HTTP.
     * @param body               Corpo da requisição.
     * @param tokenType          Tipo de token (ex: Bearer).
     * @param accessToken        Token de acesso.
     * @param connectionTimeout  Tempo limite de conexão (em milissegundos).
     * @param readTimeout        Tempo limite de leitura (em milissegundos).
     * @param retryCount         Número de tentativas de repetição em caso de falha.
     * @return Response objeto contendo a resposta da requisição.
     */
    public Response deleteMethod(String url, ContentType contentType, Boolean urlEncodingEnabled,
            Map<String, Object> params, Boolean logAll, Map<String, String> headers, Map<String, Object> body,
            String tokenType, String accessToken, Integer connectionTimeout, Integer readTimeout, Integer retryCount) {
    	this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.retryCount = readTimeout;
        return deleteMethod(url, contentType, urlEncodingEnabled, params, logAll, headers, body, tokenType, accessToken);
    }
}
