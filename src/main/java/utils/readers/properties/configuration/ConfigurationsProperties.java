package utils.readers.properties.configuration;

import utils.readers.properties.PropertyReader;

public class ConfigurationsProperties extends PropertyReader {

	private static final String FILE_LOCATION = "configurations.properties";

	private String defaultEnvironment = "hml";

	private String baseUrlToBeExecute;

	private String autheClientIdToBeExecute;
	private String autheClientSecretToBeExecute;

	private String autheTokenUrlToBeExecute;
	private String autheTokenUsernameToBeExecute;
	private String autheTokenPasswordToBeExecute;
	private String autheTokenToBeExecute;
	private String autheTypeToBeExecute;

	public ConfigurationsProperties() {
		super(FILE_LOCATION);
		selectEnvironment();
	}

	// ------------------- Base URLs ------------------- //
	private String getBaseUrlProd() {
		return getProperty("base.url.prod");
	}

	private String getBaseUrlHml() {
		return getProperty("base.url.hml");
	}

	private String getBaseUrlDev() {
		return getProperty("base.url.dev");
	}

	// ------------------- Authentication ------------------- //
	private String getAutheProdClientId() {
		return getProperty("authe.prod.client.id");
	}

	private String getAutheProdClientSecret() {
		return getProperty("authe.prod.client.secret");
	}

	private String getAutheHmlClientId() {
		return getProperty("authe.hml.client.id");
	}

	private String getAutheHmlClientSecret() {
		return getProperty("authe.hml.client.secret");
	}

	private String getAutheDevClientId() {
		return getProperty("authe.dev.client.id");
	}

	private String getAutheDevClientSecret() {
		return getProperty("authe.dev.client.secret");
	}

	// ------------------- Authorization ------------------- //
	private String getAutheProdTokenUrl() {
		return getProperty("authe.prod.token.url");
	}

	private String getAutheProdTokenUsername() {
		return getProperty("authe.prod.token.username");
	}

	private String getAutheProdTokenPassword() {
		return getProperty("authe.prod.token.password");
	}

	private String getAutheHmlTokenUrl() {
		return getProperty("authe.hml.token.url");
	}

	private String getAutheHmlTokenUsername() {
		return getProperty("authe.hml.token.username");
	}

	private String getAutheHmlTokenPassword() {
		return getProperty("authe.hml.token.password");
	}

	private String getAutheDevTokenUrl() {
		return getProperty("authe.dev.token.url");
	}

	private String getAutheDevTokenUsername() {
		return getProperty("authe.dev.token.username");
	}

	private String getAutheDevTokenPassword() {
		return getProperty("authe.dev.token.password");
	}

	private String getAutheTokenHml() {
		return getProperty("authe.token.hml");
	}

	private String getAutheTokenDev() {
		return getProperty("authe.token.dev");
	}

	private String getAutheTokenProd() {
		return getProperty("authe.token.prod");
	}

	public String getAutheType() {
		return getProperty("authe.type");
	}

	// ------------------- Timeout and Retries ------------------- //
	public Integer getConnectionTimeout() {
		return Integer.parseInt(getProperty("connection.timeout"));
	}

	public Integer getReadTimeout() {
		return Integer.parseInt(getProperty("read.timeout"));
	}

	public Integer getRetryCount() {
		return Integer.parseInt(getProperty("retry.count"));
	}

	// ------------------- Standard Parameters for Requests ------------------- //
	public String getRequestContentType() {
		return getProperty("request.content.type");
	}

	public String getResponseAcceptType() {
		return getProperty("response.accept.type");
	}

	public String getResponseLanguage() {
		return getProperty("response.language");
	}

	// ------------------- Parameters for Logs ------------------- //
	public Boolean isLogRequestsEnabled() {
		return Boolean.parseBoolean(getProperty("log.requests"));
	}

	public Boolean isLogResponsesEnabled() {
		return Boolean.parseBoolean(getProperty("log.responses"));
	}

	public String getLogDirectory() {
		return getProperty("log.directory");
	}

	// ------------------- Specific Endpoints ------------------- //
	public String getEndpointLogin() {
		return getProperty("endpoint.login");
	}

	public String getEndpointGetUsers() {
		return getProperty("endpoint.get.users");
	}

	public String getEndpointPostUser() {
		return getProperty("endpoint.post.user");
	}

	public String getEndpointDeleteUser() {
		return getProperty("endpoint.delete.user");
	}

	// ------------------- Input Data ------------------- //
	public String getTestUsername() {
		return getProperty("test.username");
	}

	public String getTestPassword() {
		return getProperty("test.password");
	}

	// ------------------- Database ------------------- //
	public String getDbUrl() {
		return getProperty("db.url");
	}

	public String getDbUsername() {
		return getProperty("db.username");
	}

	public String getDbPassword() {
		return getProperty("db.password");
	}

	public String getDbDriver() {
		return getProperty("db.driver");
	}

	// ------------------- Email Sending Settings ------------------- //
	public String getEmailSmtpHost() {
		return getProperty("email.smtp.host");
	}

	public String getEmailSmtpPort() {
		return getProperty("email.smtp.port");
	}

	public String getEmailSmtpUsername() {
		return getProperty("email.smtp.username");
	}

	public String getEmailSmtpPassword() {
		return getProperty("email.smtp.password");
	}

	public String getEmailFrom() {
		return getProperty("email.from");
	}

	public String getEmailTo() {
		return getProperty("email.to");
	}

	// ------------------- Security Settings ------------------- //
	public String getSslCertPath() {
		return getProperty("ssl.cert.path");
	}

	public String getSslCertPassword() {
		return getProperty("ssl.cert.password");
	}

	public Boolean isSslEnabled() {
		return Boolean.parseBoolean(getProperty("ssl.enabled"));
	}

	// ------------------- Dynamic Environment Variables ------------------- //
	private String getActiveEnvironment() {
		return getProperty("environment.active");
	}

	// ------------------- Select Runner ------------------- //
	public String getRunnerExecutionTest() {
		String runner = getProperty("runner.execution.test");
		if(runner.isBlank() || runner.isEmpty() || runner.equals("") || runner.equals(null)) {
			runner = "junit4";
		}
		return runner.toLowerCase();
	}

	public void selectEnvironment() {
		String environment = getActiveEnvironment();
		environment = environment.replaceAll("\\s", "");
		if (environment.equals("") || environment.isBlank() || environment.isEmpty()) {
			environment = defaultEnvironment;
		}
		environment = environment.toUpperCase();

		switch (environment) {
		case "PROD":
			setAllConfigurationToEnvironmentPROD();
			break;
		case "HML":
			setAllConfigurationToEnvironmentHML();
			break;
		case "DEV":
			setAllConfigurationToEnvironmentDEV();
			break;
		default:
			setAllConfigurationToEnvironmentHML();
			break;
		}
	}

	private void setAllConfigurationToEnvironmentPROD() {
		setBaseUrlToBeExecute(getBaseUrlProd());

		setAutheClientIdToBeExecute(getAutheProdClientId());
		setAutheClientSecretToBeExecute(getAutheProdClientSecret());

		setAutheTokenUrlToBeExecute(getAutheProdTokenUrl());
		setAutheTokenUsernameToBeExecute(getAutheProdTokenUsername());
		setAutheTokenPasswordToBeExecute(getAutheProdTokenPassword());
		setAutheTokenToBeExecute(getAutheTokenProd());
	}

	private void setAllConfigurationToEnvironmentHML() {
		setBaseUrlToBeExecute(getBaseUrlHml());

		setAutheClientIdToBeExecute(getAutheHmlClientId());
		setAutheClientSecretToBeExecute(getAutheHmlClientSecret());

		setAutheTokenUrlToBeExecute(getAutheHmlTokenUrl());
		setAutheTokenUsernameToBeExecute(getAutheHmlTokenUsername());
		setAutheTokenPasswordToBeExecute(getAutheHmlTokenPassword());
		setAutheTokenToBeExecute(getAutheTokenHml());
	}

	private void setAllConfigurationToEnvironmentDEV() {
		setBaseUrlToBeExecute(getBaseUrlDev());

		setAutheClientIdToBeExecute(getAutheDevClientId());
		setAutheClientSecretToBeExecute(getAutheDevClientSecret());

		setAutheTokenUrlToBeExecute(getAutheDevTokenUrl());
		setAutheTokenUsernameToBeExecute(getAutheDevTokenUsername());
		setAutheTokenPasswordToBeExecute(getAutheDevTokenPassword());
		setAutheTokenToBeExecute(getAutheTokenDev());
	}

	public String getBaseUrlToBeExecute() {
		return baseUrlToBeExecute;
	}

	private void setBaseUrlToBeExecute(String baseUrlToBeExecute) {
		this.baseUrlToBeExecute = baseUrlToBeExecute;
	}

	public String getAutheClientIdToBeExecute() {
		return autheClientIdToBeExecute;
	}

	private void setAutheClientIdToBeExecute(String autheClientIdToBeExecute) {
		this.autheClientIdToBeExecute = autheClientIdToBeExecute;
	}

	public String getAutheClientSecretToBeExecute() {
		return autheClientSecretToBeExecute;
	}

	private void setAutheClientSecretToBeExecute(String autheClientSecretToBeExecute) {
		this.autheClientSecretToBeExecute = autheClientSecretToBeExecute;
	}

	public String getAutheTokenUrlToBeExecute() {
		return autheTokenUrlToBeExecute;
	}

	private void setAutheTokenUrlToBeExecute(String autheTokenUrlToBeExecute) {
		this.autheTokenUrlToBeExecute = autheTokenUrlToBeExecute;
	}

	public String getAutheTokenUsernameToBeExecute() {
		return autheTokenUsernameToBeExecute;
	}

	private void setAutheTokenUsernameToBeExecute(String autheTokenUsernameToBeExecute) {
		this.autheTokenUsernameToBeExecute = autheTokenUsernameToBeExecute;
	}

	public String getAutheTokenPasswordToBeExecute() {
		return autheTokenPasswordToBeExecute;
	}

	private void setAutheTokenPasswordToBeExecute(String autheTokenPasswordToBeExecute) {
		this.autheTokenPasswordToBeExecute = autheTokenPasswordToBeExecute;
	}

	public String getAutheTokenToBeExecute() {
		return autheTokenToBeExecute;
	}

	private void setAutheTokenToBeExecute(String autheTokenToBeExecute) {
		this.autheTokenToBeExecute = autheTokenToBeExecute;
	}

	public String getAutheTypeToBeExecute() {
		return autheTypeToBeExecute;
	}

}