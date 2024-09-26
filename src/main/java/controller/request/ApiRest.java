package controller.request;

import controller.request.methods.GeneralRequest;
import lombok.extern.log4j.Log4j2;
import utils.readers.properties.configuration.ConfigurationsProperties;

@Log4j2
public class ApiRest extends GeneralRequest {

    /**
     * Método que retorna uma instância da classe `ConfigurationsProperties`, utilizada
     * para acessar as propriedades de configuração definidas no arquivo de propriedades.
     *
     * @return ConfigurationsProperties objeto contendo as configurações.
     */
    public ConfigurationsProperties getConfigurationsProperties() {
        log.info("Obtendo as propriedades de configuração...");
        log.info("Propriedades de configuração carregadas com sucesso.");
        return configurationsProperties;
    }
}
