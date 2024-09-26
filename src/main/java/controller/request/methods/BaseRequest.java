package controller.request.methods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.restassured.config.ConnectionConfig;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import utils.readers.properties.configuration.ConfigurationsProperties;

@Log4j2
public class BaseRequest {

	protected Response response;

	protected String defaultFirstMessage;
	protected String defaultLastMessage;
	protected Map<String, Object> map;
	protected Random random;

	protected ConfigurationsProperties configurationsProperties;

	protected Integer connectionTimeout;
	protected Integer readTimeout;
	protected Integer retryCount;

	public BaseRequest() {
		defaultFirstMessage = "calling the ";
		defaultLastMessage = "method with params: ";
		map = new HashMap<String, Object>();
		random = new Random();
		configurationsProperties = new ConfigurationsProperties();
		connectionTimeout = configurationsProperties.getConnectionTimeout();
		readTimeout = configurationsProperties.getReadTimeout();
		retryCount = configurationsProperties.getRetryCount();
	}

	/**
	 * Retorna a resposta atual armazenada na variável estática `response`.
	 *
	 * @return Response objeto contendo a resposta da requisição.
	 */
	public Response getResponse() {
		return response;
	}
	
	/**
	 * Define a resposta atual na variável estática `response`.
	 *
	 * @param response Objeto do tipo `Response` contendo a resposta da requisição.
	 */
	public void setResponse(Response response) {
	    this.response = response;
	}

	/**
	 * Extrai uma lista de objetos a partir de um caminho (path) no corpo da
	 * resposta.
	 *
	 * @param path Caminho no corpo da resposta de onde a lista será extraída.
	 * @return ArrayList contendo os valores extraídos do caminho especificado.
	 */
	public ArrayList<Object> getListForPath(String path) {
		log.info("Extraindo lista de objetos para o caminho: " + path);
		return getResponse().then().extract().path(path);
	}

	/**
	 * Obtém o código de status HTTP da resposta.
	 *
	 * @return int código de status da resposta.
	 */
	public Integer getStatusCode() {
		int statusCode = getResponse().then().extract().statusCode();
		log.info("Código de status da resposta: " + statusCode);
		return statusCode;
	}

	/**
	 * Verifica se o corpo da resposta contém um determinado texto.
	 *
	 * @param text Texto a ser verificado no corpo da resposta.
	 * @return boolean true se o texto estiver presente, caso contrário false.
	 */
	public Boolean bodyContains(Object text) {
		boolean contains = getResponse().then().extract().body().asString().contains(String.valueOf(text));
		log.info("Verificando se o corpo da resposta contém o texto: " + text + " - Resultado: " + contains);
		return contains;
	}

	/**
	 * Retorna o corpo da resposta como uma String.
	 *
	 * @return String contendo o corpo da resposta.
	 */
	public String getBody() {
		String body = response.then().extract().body().asString();
		log.info("Corpo da resposta extraído: " + body);
		return body;
	}

	/**
	 * Extrai o corpo da resposta em uma única linha, removendo quebras de linha e
	 * espaços extras.
	 *
	 * @return String contendo o corpo da resposta em uma única linha.
	 */
	public String getResponseOneLine() {
		String responseOneLine = Arrays.stream(response.then().extract().body().asString().split("\\n"))
				.map(String::trim).reduce(String::concat).toString();
		String result = responseOneLine.substring(9, responseOneLine.length() - 1);
		log.info("Resposta em uma linha extraída: " + result);
		return result;
	}

	/**
	 * Método para validar o status code da resposta.
	 * 
	 * @param response           A resposta da requisição.
	 * @param expectedStatusCode O status code esperado.
	 */
	public void validateStatusCode(Response response, int expectedStatusCode) {
		int actualStatusCode = response.getStatusCode();
		if (actualStatusCode != expectedStatusCode) {
			log.error("Status code mismatch: Expected: " + expectedStatusCode + ", Actual: " + actualStatusCode);
			throw new AssertionError("Unexpected status code: " + actualStatusCode);
		}
		log.info("Status code validation passed: " + actualStatusCode);
	}

	/**
	 * Método para validar a estrutura JSON da resposta.
	 * 
	 * @param response A resposta da requisição.
	 */
	public void validateJsonStructure(Response response) {
		try {
			response.getBody().jsonPath();
			log.info("JSON structure validated successfully.");
		} catch (Exception e) {
			log.error("Invalid JSON structure: " + e.getMessage());
			throw new AssertionError("Invalid JSON structure.");
		}
	}

	/**
	 * Método para validar o tempo de resposta.
	 * 
	 * @param response        A resposta da requisição.
	 * @param maxResponseTime Tempo máximo permitido para a resposta.
	 */
	public void validateResponseTime(Response response, long maxResponseTime) {
		long actualResponseTime = response.getTime();
		if (actualResponseTime > maxResponseTime) {
			log.warn("Response time exceeded: " + actualResponseTime + "ms (Expected: <= " + maxResponseTime + "ms)");
		} else {
			log.info("Response time validation passed: " + actualResponseTime + "ms");
		}
	}

	/**
	 * Método para validação geral de resposta.
	 * 
	 * @param response A resposta da requisição.
	 */
	public void validateResponse(Response response) {
		validateStatusCode(response, 200); // Exemplo: validar se o status é 200
		validateJsonStructure(response); // Validar se a resposta tem uma estrutura JSON válida
	}

	// Função auxiliar para configuração de timeouts
	public RestAssuredConfig getConfigWithTimeouts() {
		return RestAssuredConfig.config()
				.connectionConfig(ConnectionConfig.connectionConfig().closeIdleConnectionsAfterEachResponseAfter(2,
						TimeUnit.SECONDS))
				.httpClient(HttpClientConfig.httpClientConfig().setParam("http.connection.timeout", connectionTimeout)
						.setParam("http.socket.timeout", readTimeout));
	}
	
	

	// Função auxiliar para executar com retry
	public Response executeWithRetry(Callable<Response> action) {
		int attempt = 0;
		while (attempt < retryCount) {
			try {
				return action.call(); // Tenta executar a ação
			} catch (Exception e) {
				log.error("Erro na tentativa " + (attempt + 1) + ": " + e.getMessage());
				attempt++;
				if (attempt >= retryCount) {
					throw new RuntimeException("Falha após " + retryCount + " tentativas");
				}
			}
		}
		return null;
	}

	@FunctionalInterface
	protected interface Callable<V> {
		V call() throws Exception;
	}
	
}
