package io.quangvu.fcare.service;

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
import io.quangvu.fcare.helper.IOHelper;

public class LoginService {

	public static boolean login(String username, String password) {
		try {
			boolean result = false;
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpPost postRequest = new HttpPost("http://" + AppConfig.get("server") + "/login.php");
			List<NameValuePair> options = new ArrayList<NameValuePair>();
			options.add(new BasicNameValuePair("username", username));
			options.add(new BasicNameValuePair("password", password));
			postRequest.setEntity(new UrlEncodedFormEntity(options));
			CloseableHttpResponse response = httpClient.execute(postRequest);
			HttpEntity entity = response.getEntity();
			String content = EntityUtils.toString(entity, "UTF-8");
			EntityUtils.consume(entity);
			//System.out.println(content);
			if(content.equalsIgnoreCase("ok")) {
				result = true;
			}
			return result;
		} catch (Exception ex) {
			return false;
		}
	}
}
