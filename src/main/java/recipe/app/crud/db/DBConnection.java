package recipe.app.crud.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/recipe_app";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "root";
	private static Connection connection = null;

	public static Connection getConnection() throws SQLException {
		try {
			System.out.println("Starting connection...");
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			if (connection != null) {
				System.out.println("Connected!");
				return connection;
			}
			return null;
		} catch (Exception e) {
			throw new SQLException("Connection failed", e);
		}
	}

	public static void main(String[] args) {
		try {
			System.out.print(DBConnection.getConnection());
		} catch (Exception e) {

		}
	}

}
