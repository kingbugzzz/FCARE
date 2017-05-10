package io.quangvu.fcare.helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import io.quangvu.fcare.bean.Clone;

public class CookieHelper {

	public static void updateCookie(String cloneId, PhantomJSDriver driver) {
		String cookieString = "";
		Set<Cookie> cookies = driver.manage().getCookies();
		for (Cookie cookie : cookies) {
			cookieString += cookie.getName() + "#" + cookie.getValue() + "#" + cookie.getDomain() + "#"
					+ cookie.getPath() + "#" + cookie.getExpiry() + "@";
		}
		cookieString = cookieString.substring(0, cookieString.length() - 1);

		String query = "UPDATE clones SET cookie='" + cookieString + "' WHERE id='" + cloneId + "' AND owner = '"
				+ SessionHelper.getSessionUser() + "'";
		System.out.println(query);

		DBHelper.execute(query);
	}

	public static void updateCookie(String cloneId, String cookieString) {
		String query = "UPDATE clones SET cookie='" + cookieString + "' WHERE id='" + cloneId + "' AND owner = '"
				+ SessionHelper.getSessionUser() + "'";
		System.out.println(query);

		DBHelper.execute(query);
	}

	public static String getCookieString(PhantomJSDriver driver) {
		String cookieString = "";
		Set<Cookie> cookies = driver.manage().getCookies();
		for (Cookie cookie : cookies) {
			cookieString += cookie.getName() + "#" + cookie.getValue() + "#" + cookie.getDomain() + "#"
					+ cookie.getPath() + "#" + cookie.getExpiry() + "@";
		}

		return cookieString.substring(0, cookieString.length() - 1);
	}

	public static void login(Clone clone, PhantomJSDriver driver) {
				
		String[] cookieParts = clone.getCookie().split("@");
		Cookie cookie = null;
		String[] cookieVals = null;
		
		SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		Date expiry = null;
		for (int i = 0; i < cookieParts.length; i++) {
			cookieVals = cookieParts[i].split("#");
			try {
				expiry = formatter.parse(cookieVals[4]);
			} catch (ParseException e) {
				e.printStackTrace();
				continue;
			}
			cookie = new Cookie(cookieVals[0], cookieVals[1], cookieVals[2], cookieVals[3], expiry);
			driver.manage().addCookie(cookie);
		}
	}
}
