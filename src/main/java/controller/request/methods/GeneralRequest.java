package controller.request.methods;

import java.util.ArrayList;
import java.util.Arrays;

import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class GeneralRequest extends PutRequest{

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
		String body = getResponse().then().extract().body().asString();
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
		String responseOneLine = Arrays.stream(getResponse().then().extract().body().asString().split("\\n"))
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
}
