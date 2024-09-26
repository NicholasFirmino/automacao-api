package runners;

import lombok.extern.log4j.Log4j2;
import utils.readers.properties.configuration.ConfigurationsProperties;

@Log4j2
public class Runner {

	public static void main(String[] args) {
		// Carrega o arquivo configuration.properties
		ConfigurationsProperties configurationsProperties = new ConfigurationsProperties();
		String runnerType = configurationsProperties.getRunnerExecutionTest();

		// Executa o runner com base na configuração
		switch (runnerType) {
		case "junit4":
			runJUnit4();
		case "junit5":
			runJUnit5();
			break;
		case "cluecumber":
			runCluecumber();
			break;
		case "jenkins":
			runJenkins();
			break;
		case "testng-extent":
			runTestNGExtent();
			break;
		case "testng":
			runTestNG();
			break;
		case "serenity":
			runSerenity();
			break;
		default:
			log.error("Runner não configurado ou não suportado: " + runnerType);
		}
	}

	// Método para executar o runner JUnit4
	private static void runJUnit4() {
		try {
			log.info("Executando testes com JUnit 4...");
			org.junit.runner.JUnitCore.main("runners.types.RunCucumberJUnit4Test");
		} catch (Exception e) {
			log.error("Erro ao executar JUnit 4: " + e.getMessage(), e);
		}
	}
	
	// Método para executar o runner JUnit4
		private static void runJUnit5() {
			log.info("Execução de testes com JUnit 5 não foi implementado ainda");
		}

	// Método para executar o runner Cluecumber
	private static void runCluecumber() {
		try {
			log.info("Executando testes com Cluecumber...");
			org.junit.runner.JUnitCore.main("runners.types.RunCucumberJUnitCluecumberTest");
		} catch (Exception e) {
			log.error("Erro ao executar Cluecumber: " + e.getMessage(), e);
		}
	}

	// Método para executar o runner Jenkins
	private static void runJenkins() {
		try {
			log.info("Executando testes com Jenkins...");
			org.junit.runner.JUnitCore.main("runners.types.RunCucumberJUnitJenkinsTest");
		} catch (Exception e) {
			log.error("Erro ao executar Jenkins: " + e.getMessage(), e);
		}
	}

	// Método para executar o runner TestNG
	private static void runTestNG() {
		try {
			log.info("Executando testes com TestNG...");
			org.testng.TestNG.main(new String[] { "runners.types.RunCucumberTestNGTest" });
		} catch (Exception e) {
			log.error("Erro ao executar TestNG: " + e.getMessage(), e);
		}
	}

	// Método para executar o runner TestNG com Extent Reports
	private static void runTestNGExtent() {
		try {
			log.info("Executando testes com TestNG e Extent Reports...");
			org.testng.TestNG.main(new String[] { "runners.types.RunCucumberTestNGExtentTest" });
		} catch (Exception e) {
			log.error("Erro ao executar TestNG com Extent Reports: " + e.getMessage(), e);
		}
	}

	// Método para executar o runner Serenity
	private static void runSerenity() {
		try {
			log.info("Executando testes com Serenity...");
			org.junit.runner.JUnitCore.main("runners.types.RunSerenityJUnitTest");
		} catch (Exception e) {
			log.error("Erro ao executar Serenity: " + e.getMessage(), e);
		}
	}
}
