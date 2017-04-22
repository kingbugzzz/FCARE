package io.quangvu.fcare.config;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class AppConfig {

	private static final String CONFIG_PATH = "config/app.conf";
	
	private static Map<String, String> configs = null;
	
	private static AppConfig instance = null;
	
	private AppConfig() {}
	
	public static AppConfig getInstance() {
		if(instance == null) {
			instance = new AppConfig();
		}
		return instance;
	}
	
	
	private static void init() {
		try {
			Properties properties = new Properties();
			configs = new HashMap<String, String>();
			properties.load(new FileInputStream(CONFIG_PATH));
			for (Object key : properties.keySet()) {
				configs.put((String)key, properties.getProperty((String)key));
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static String get(String key) {
		if(configs == null) {
			init();
		}
		return configs.get(key);
	}
}