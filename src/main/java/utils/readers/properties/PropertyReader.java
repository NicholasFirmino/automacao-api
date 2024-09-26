package utils.readers.properties;

import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

import lombok.extern.log4j.Log4j2;

@Log4j2
public abstract class PropertyReader {
	private Properties prop;

	/**
	 * Construtor da classe PropertyReader. Recebe o nome do arquivo a ser lido e o
	 * transforma em um objeto Properties.
	 *
	 * @param fileName Nome do arquivo a ser lido.
	 */
	protected PropertyReader(String fileName) {
		prop = new Properties();
		InputStream in = this.getClass().getClassLoader().getResourceAsStream(fileName);
		try {
			prop.load(in);
		} catch (Exception e) {
			log.error("Falha ao carregar o arquivo Property: " + fileName);
			// throw new CoreException.PropertyException("Failed to load Property file: " +
			// fileName, e);
		}
	}

	/**
	 * Retorna o valor de uma propriedade a partir de sua chave.
	 *
	 * @param propKey Chave da propriedade.
	 * @return Valor da propriedade correspondente à chave, ou uma string vazia caso
	 *         não exista.
	 */
	public String getProperty(String propKey) {
		return Optional.ofNullable((String) prop.get(propKey)).orElse("");
	}

}