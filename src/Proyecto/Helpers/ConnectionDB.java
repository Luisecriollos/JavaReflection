package Proyecto.Helpers;

import java.sql.*;

public class ConnectionDB {

	public Connection ConenectDB;
	private static final String DB_HOST = "localhost";
	private static final int DB_PORT = 5432;
	private static final String DB_NAME = "alquiler";
	private static final String DB_USER = "postgres";
	private static final String DB_PASS = "postgres";

	private static Connection connection = null;

	private static Connection getConnection() {

		try {
			Class.forName("org.postgresql.Driver");
			if (connection == null) {
				connection = DriverManager.getConnection(
						String.format("jdbc:postgresql://%s:%s/%s", DB_HOST, DB_PORT, DB_NAME), DB_USER, DB_PASS);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;

	}

	public static boolean executeUpdate(String sql) {

		try {
			// I created connection to DataBase
			Connection ConnectDB = getConnection();

			// Crear Statement
			Statement st = ConnectDB.createStatement();

			// rellenar base de datos
			st.executeUpdate(sql);
			st.close();

			System.out.println("Query ejecutado");
			return true;
		}

		catch (SQLException e) {
			System.out.println("error en el query: " + e);
			return false;
		}

	}

	public static ResultSet executeQuery(String sql) {

		try {

			// I created connection to DataBase
			Connection ConnectDB = getConnection();

			// Crear Statement
			Statement st = ConnectDB.createStatement();

			// rellenar base de datos
			ResultSet rs = st.executeQuery(sql);

			System.out.println("Query ejecutado");
			return rs;
		}

		catch (SQLException e) {
			System.out.println("error en el query: " + e);

			return null;
		}

	}

}