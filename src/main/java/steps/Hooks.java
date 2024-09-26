package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Hooks {

	@Before
	public void before(Scenario scenario) {
		RestAssured.config = RestAssured
				.config()
				.sslConfig(SSLConfig.sslConfig()
						.allowAllHostnames()
						.relaxedHTTPSValidation()
				);
		log.info("Iniciando o cenário: " + scenario.getName());
		log.info("ID do cenário: " + scenario.getId());
	}

	@After
	public void after(Scenario scenario) {
		log.info("Finalizando o cenário: " + scenario.getName());
		log.info("ID do cenário: " + scenario.getId());
		log.info("Status do cenário: " + scenario.getStatus());
	}
}
