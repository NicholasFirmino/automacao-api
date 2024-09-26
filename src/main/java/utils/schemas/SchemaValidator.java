package utils.schemas;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SchemaValidator {
    
    private static final String FILE_EXTENSION = ".json";
    private static final String FILE_BASE_PATH = "schemas/";

    /**
     * Valida o corpo da resposta JSON com base no arquivo de schema fornecido.
     *
     * @param filePath O caminho do arquivo de schema dentro da pasta "schemas".
     * @param fileName O nome do arquivo de schema (sem extensão).
     * @param responseBody O corpo da resposta JSON a ser validado.
     * @return true se o JSON estiver de acordo com o schema, false caso contrário.
     * @throws FileNotFoundException Se o arquivo de schema não for encontrado.
     */
    public boolean validateResponseBodyWithJSONSchema(String filePath, String fileName, String responseBody) throws FileNotFoundException {
        File schemaFile = getSchemaFile(filePath, fileName);
        try {
            RestAssured
                .given()
                .body(responseBody)
                .then()
                .body(JsonSchemaValidator.matchesJsonSchema(schemaFile));
            return true;
        } catch (AssertionError e) {
            log.error("Erro na validação do schema: " + e.getMessage());
            return false;
        } catch (Exception e) {
            log.error("Erro inesperado durante a validação do schema: " + e.getMessage(), e);
            return false;
        }
    }
    
    /**
     * Valida o corpo da resposta JSON com base no arquivo de schema fornecido.
     *
     * @param filePath O caminho do arquivo de schema dentro da pasta "schemas".
     * @param fileName O nome do arquivo de schema (sem extensão).
     * @param fileExtension A extensão do arquivo de schema (ex: .json).
     * @param responseBody O corpo da resposta JSON a ser validado.
     * @return true se o JSON estiver de acordo com o schema, false caso contrário.
     * @throws FileNotFoundException Se o arquivo de schema não for encontrado.
     */
    public boolean validateResponseBodyWithJSONSchema(String filePath, String fileName, String fileExtension, String responseBody) throws FileNotFoundException {
        File schemaFile = getSchemaFile(filePath, fileName, fileExtension);
        try {
            RestAssured
                .given()
                .body(responseBody)
                .then()
                .body(JsonSchemaValidator.matchesJsonSchema(schemaFile));
            return true;
        } catch (AssertionError e) {
            log.error("Erro na validação do schema: " + e.getMessage());
            return false;
        } catch (Exception e) {
            log.error("Erro inesperado durante a validação do schema: " + e.getMessage(), e);
            return false;
        }
    }

    /**
     * Valida o corpo da resposta JSON com base no arquivo de schema fornecido.
     *
     * @param filePathNameExtension O caminho completo, incluindo nome e extensão do arquivo.
     * @param responseBody O corpo da resposta JSON a ser validado.
     * @return true se o JSON estiver de acordo com o schema, false caso contrário.
     * @throws FileNotFoundException Se o arquivo de schema não for encontrado.
     */
    public boolean validateResponseBodyWithJSONSchema(String filePathNameExtension, String responseBody) throws FileNotFoundException {
        File schemaFile = getSchemaFile(filePathNameExtension);
        try {
            RestAssured
                .given()
                .body(responseBody)
                .then()
                .body(JsonSchemaValidator.matchesJsonSchema(schemaFile));
            return true;
        } catch (AssertionError e) {
            log.error("Erro na validação do schema: " + e.getMessage());
            return false;
        } catch (Exception e) {
            log.error("Erro inesperado durante a validação do schema: " + e.getMessage(), e);
            return false;
        }
    }

    /**
     * Valida o corpo da resposta JSON com base no arquivo de schema fornecido.
     *
     * @param filePath O caminho do arquivo de schema dentro da pasta "schemas".
     * @param fileName O nome do arquivo de schema (sem extensão).
     * @param response O objeto Response da RestAssured contendo a resposta da API.
     * @return true se o JSON estiver de acordo com o schema, false caso contrário.
     * @throws FileNotFoundException Se o arquivo de schema não for encontrado.
     */
    public boolean validateResponseBodyWithJSONSchema(String filePath, String fileName, Response response) throws FileNotFoundException {
        File schemaFile = getSchemaFile(filePath, fileName);
        try {
            response
                .then()
                .body(JsonSchemaValidator.matchesJsonSchema(schemaFile));
            return true;
        } catch (AssertionError e) {
            log.error("Erro na validação do schema: " + e.getMessage());
            return false;
        } catch (Exception e) {
            log.error("Erro inesperado durante a validação do schema: " + e.getMessage(), e);
            return false;
        }
    }
    
    /**
     * Valida o corpo da resposta JSON com base no arquivo de schema fornecido.
     *
     * @param filePath O caminho do arquivo de schema dentro da pasta "schemas".
     * @param fileName O nome do arquivo de schema (sem extensão).
     * @param fileExtension A extensão do arquivo de schema (ex: .json).
     * @param response O objeto Response da RestAssured contendo a resposta da API.
     * @return true se o JSON estiver de acordo com o schema, false caso contrário.
     * @throws FileNotFoundException Se o arquivo de schema não for encontrado.
     */
    public boolean validateResponseBodyWithJSONSchema(String filePath, String fileName, String fileExtension, Response response) throws FileNotFoundException {
        File schemaFile = getSchemaFile(filePath, fileName, fileExtension);
        try {
            response
                .then()
                .body(JsonSchemaValidator.matchesJsonSchema(schemaFile));
            return true;
        } catch (AssertionError e) {
            log.error("Erro na validação do schema: " + e.getMessage());
            return false;
        } catch (Exception e) {
            log.error("Erro inesperado durante a validação do schema: " + e.getMessage(), e);
            return false;
        }
    }

    /**
     * Valida o corpo da resposta JSON com base no arquivo de schema fornecido.
     *
     * @param filePathNameExtension O caminho completo, incluindo nome e extensão do arquivo.
     * @param response O objeto Response da RestAssured contendo a resposta da API.
     * @return true se o JSON estiver de acordo com o schema, false caso contrário.
     * @throws FileNotFoundException Se o arquivo de schema não for encontrado.
     */
    public boolean validateResponseBodyWithJSONSchema(String filePathNameExtension, Response response) throws FileNotFoundException {
        File schemaFile = getSchemaFile(filePathNameExtension);
        try {
            response
                .then()
                .body(JsonSchemaValidator.matchesJsonSchema(schemaFile));
            return true;
        } catch (AssertionError e) {
            log.error("Erro na validação do schema: " + e.getMessage());
            return false;
        } catch (Exception e) {
            log.error("Erro inesperado durante a validação do schema: " + e.getMessage(), e);
            return false;
        }
    }

    //--------------------------------------------------------------------------------------------------
    
    /**
     * Localiza o arquivo de schema JSON dentro da pasta "resources/schemas".
     *
     * @param filePath O caminho dentro da pasta "schemas".
     * @param fileName O nome do arquivo de schema (sem extensão).
     * @return O arquivo de schema.
     * @throws FileNotFoundException Se o arquivo de schema não for encontrado.
     */
    private File getSchemaFile(String filePath, String fileName) throws FileNotFoundException {
        String fullPath = FILE_BASE_PATH.concat(filePath).concat(fileName).concat(FILE_EXTENSION);
        URL resource = getClass().getClassLoader().getResource(fullPath);
        if (resource == null) {
            throw new FileNotFoundException("Arquivo de schema não encontrado: " + fullPath);
        }
        return new File(resource.getFile());
    }

    /**
     * Localiza o arquivo de schema JSON dentro da pasta "resources/schemas".
     *
     * @param filePath O caminho dentro da pasta "schemas".
     * @param fileName O nome do arquivo de schema (sem extensão).
     * @param fileExtension A extensão do arquivo de schema (ex: .json).
     * @return O arquivo de schema.
     * @throws FileNotFoundException Se o arquivo de schema não for encontrado.
     */
    private File getSchemaFile(String filePath, String fileName, String fileExtension) throws FileNotFoundException {
        String fullPath = FILE_BASE_PATH.concat(filePath).concat(fileName).concat(fileExtension);
        URL resource = getClass().getClassLoader().getResource(fullPath);
        if (resource == null) {
            throw new FileNotFoundException("Arquivo de schema não encontrado: " + fullPath);
        }
        return new File(resource.getFile());
    }

    /**
     * Localiza o arquivo de schema JSON dentro da pasta "resources/schemas".
     *
     * @param filePathNameExtension O caminho completo, incluindo nome e extensão do arquivo.
     * @return O arquivo de schema.
     * @throws FileNotFoundException Se o arquivo de schema não for encontrado.
     */
    private File getSchemaFile(String filePathNameExtension) throws FileNotFoundException {
        URL resource = getClass().getClassLoader().getResource(filePathNameExtension);
        if (resource == null) {
            throw new FileNotFoundException("Arquivo de schema não encontrado: " + filePathNameExtension);
        }
        return new File(resource.getFile());
    }
}
