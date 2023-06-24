package core.utility.constants;

import core.utility.ReadProperties;

public class ConfigurationConstants {
	public static String BASE_URL = ReadProperties.readProperty("config.properties", "app.url");

	public static String BROWSER_NAME = ReadProperties.readProperty("config.properties", "browser.name");
	public static boolean IS_HEADLESS = Boolean.parseBoolean(ReadProperties.readProperty("config.properties", "browser.headless"));
	public static String CHROME_VERSION = ReadProperties.readProperty("config.properties", "chrome.version");

	public static long TIMEOUT = Long.parseLong(ReadProperties.readProperty("config.properties", "element.timeout"));
	public static long POLLING = Long.parseLong(ReadProperties.readProperty("config.properties", "element.polling"));}

