package io.quangvu.fcare.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import io.quangvu.fcare.config.AppConfig;

public class DBHelper {

	private static Connection connection = null;
	private static Statement statement = null;

	private DBHelper() {
	}

	public static boolean cnt() {
		if (connection == null) {
			try {
				String[] sessionData = IOHelper.read(".session/.temp").split("#");
				String connectionString = "jdbc:mysql://" + AppConfig.get("server") + ":3306/" + AppConfig.get("server")
						+ "?useUnicode=true&characterEncoding=utf-8";
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(connectionString, sessionData[1],sessionData[2]);
				if (connection != null) {
					System.out.println(">>Connection was created!");
					return true;
				}
				return false;
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				return false;
			}
		} else {
			return true;
		}
	}

	public static boolean connect() {
		if (connection == null) {
			try {
				String connectionString = "jdbc:mysql://" + AppConfig.get("host") + ":" + AppConfig.get("port") + "/"
						+ AppConfig.get("database") + "?useUnicode=true&characterEncoding=utf-8";
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(connectionString, AppConfig.get("user"),
						AppConfig.get("pass"));

				if (connection != null) {
					System.out.println("Connection was created!");
					return true;
				}
				return false;
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				return false;
			}
		} else {
			return true;
		}
	}

	public static boolean connect(String host, String port, String user, String pass, String dbname) {
		if (connection == null) {
			try {
				String connectionString = "jdbc:mysql://" + host + ":" + port + "/" + dbname
						+ "?useUnicode=true&characterEncoding=utf-8";
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(connectionString, user, pass);

				if (connection != null) {
					System.out.println(">>Connection was created!");
					return true;
				}
				return false;
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				return false;
			}
		} else {
			return true;
		}
	}

	public static boolean execute(String query) {
		try {
			if (query == null || query == "") {
				return false;
			}
			statement = connection.createStatement();
			return statement.execute(query);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	public static ResultSet executeQuery(String query) {
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			return rs;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	public static void disconnect() {
		if (connection != null) {
			try {
				connection.close();
				System.out.println(">>Connection was closed!");
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
}
