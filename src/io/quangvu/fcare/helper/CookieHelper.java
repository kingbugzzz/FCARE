package io.quangvu.fcare.helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class CookieHelper {

	public static void updateCookie(String cloneId, PhantomJSDriver driver) {
		String cookieString = "";
		Set<Cookie> cookies = driver.manage().getCookies();
		for (Cookie cookie : cookies) {
			cookieString += cookie.getName() + "#" + cookie.getValue() + "#" + cookie.getDomain() + "#"
					+ cookie.getPath() + "#" + cookie.getExpiry();
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
					+ cookie.getPath() + "#" + cookie.getExpiry();
		}
		return cookieString.substring(0, cookieString.length() - 1);
	}

	public static void cookieLogin(String cloneId, PhantomJSDriver driver) {

		String query = "SELECT cookie FROM clones WHERE id='" + cloneId + "' AND owner = '"
				+ SessionHelper.getSessionUser() + "'";
		ResultSet rs = DBHelper.executeQuery(query);
		String cookieString = null;
		try {
			while(rs.next()) {
				cookieString = rs.getString(0);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		String[] cookieParts = cookieString.split("$");
		Cookie[] cookies = new Cookie[cookieParts.length];
		Cookie cookie = null;
		String[] cookieVals = null;
		Date expiry = null;
		for (int i = 0; i < cookies.length; i++) {
			cookieVals = cookieParts[i].split("#");
			try {
				expiry = formatter.parse(cookieVals[4]);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			cookie = new Cookie(cookieVals[0], cookieVals[1], cookieVals[2], cookieVals[3], expiry);
			driver.manage().addCookie(cookie);
		}
	}
}
