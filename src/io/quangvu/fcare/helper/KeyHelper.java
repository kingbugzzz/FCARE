package io.quangvu.fcare.helper;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import io.quangvu.fcare.config.AppConfig;

public class KeyHelper {
	
	private KeyHelper(){}
	
	public static boolean validKey() {
		try {
			boolean result = false;
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpPost postRequest = new HttpPost("http://" + AppConfig.get("server") + "/kc.php");
			List<NameValuePair> options = new ArrayList<NameValuePair>();
			options.add(new BasicNameValuePair("user_key", IOHelper.read("config/key.dat").trim()));
			postRequest.setEntity(new UrlEncodedFormEntity(options));
			CloseableHttpResponse response = httpClient.execute(postRequest);
			HttpEntity entity = response.getEntity();
			String content = EntityUtils.toString(entity, "UTF-8");
			EntityUtils.consume(entity);
			if (content.equalsIgnoreCase("ok")) {
				result = true;
			}
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static boolean reg(String key, String username) {
		try {
			boolean result = false;
			if (key.equals(null) || key.length() < 28) {
				result = false;
			} else {
				String osArch = System.getProperty("os.arch").trim();
				String osName = System.getProperty("os.name").trim();
				String serial = DeviceInfoHelper.getSerialNumber().trim();
				String superkey = osName + "-" + osArch + "-" + serial + "-" + key;
				System.out.println("Superkey=" + superkey);
				CloseableHttpClient httpClient = HttpClients.createDefault();
				HttpPost postRequest = new HttpPost("http://" + AppConfig.get("server") + "/reg.php");
				List<NameValuePair> options = new ArrayList<NameValuePair>();
				options.add(new BasicNameValuePair("username", username));
				options.add(new BasicNameValuePair("user_key", key));
				options.add(new BasicNameValuePair("super_key", superkey));
				postRequest.setEntity(new UrlEncodedFormEntity(options));
				CloseableHttpResponse response = httpClient.execute(postRequest);
				HttpEntity entity = response.getEntity();
				String content = EntityUtils.toString(entity, "UTF-8");
				System.out.println("Response:" + content);
				EntityUtils.consume(entity);
				if (content.equalsIgnoreCase("ok")) {
					result = true;
					IOHelper.writeToFile(key, "config/key.dat");
				}
			}
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
