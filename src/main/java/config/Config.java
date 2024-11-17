package config;

import java.io.IOException;

import utils.Utilities;

public class Config {
	
	public static String getChromeDriverPath() throws IOException {
		return Utilities.getPropertiesFileData("ChromeDriverPath");
	}
	public static String getURL() throws IOException {
		return Utilities.getPropertiesFileData("URL");
	}
	public static String getBrowser() throws IOException {
		return Utilities.getPropertiesFileData("browser");
	}
	public static String getUser() throws IOException {
		return Utilities.getPropertiesFileData("user");
	}
}
