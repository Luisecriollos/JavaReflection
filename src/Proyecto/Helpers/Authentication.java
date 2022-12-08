package Proyecto.Helpers;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Authentication {

	public static int Auth(String userLogin, String passLogin) {
		int verificado = 0;

		String query = String.format("SELECT * FROM users WHERE username = '%s' AND passHash = '%s'", userLogin,
				passLogin);
		System.out.println(query);
		ResultSet respuestaAuthentication = ConnectionDB.executeQuery(query);

		try {

			if (respuestaAuthentication != null && respuestaAuthentication.next()) {
				verificado = 1;
				System.out.println("Autenticado");
				return verificado;
			} else
				System.out.println("error al autenticar");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return verificado;

	}
}