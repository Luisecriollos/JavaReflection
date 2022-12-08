package Proyecto.Controllers;

import Proyecto.Helpers.ConnectionDB;
import Proyecto.Helpers.Hash;

public class UserController {

	/*
	 * Profe aca podra ver un desastre y un pocoton de querys, perdone el desorden
	 * pero no pude configurar correctamente el Archivo de propiedades
	 */

	// Metodo para Actualizar datos
	public static String Update(String userName, String passwordOld, String emailOld, String ageOld, String countryOld,
			String genderOld, String passwordNew, String emailNew, String ageNew, String countryNew, String genderNew) {

		String passHasheadaOld = Hash.Encriptar(passwordOld);
		String passHasheadaNew = Hash.Encriptar(passwordNew);

		String query = String.format(
				"UPDATE users SET password = '%s', email = '%s', age = %s, country = '%s', gender = '%s' WHERE username = '%s' AND password = '%s'",
				passwordNew, emailNew, ageNew, countryNew, genderNew, userName, passwordOld);

		boolean respuesta = ConnectionDB.executeUpdate(query);

		if (respuesta) {
			return ("Tus datos han sido acutalizados correctamentos");
		}
		return ("Ocurrio un error al intentar actulizar sus datos");
	}

	// Metodo para Borrar Usuarios
	public static String Delete(String userName, String password) {

		String passHasheada = Hash.Encriptar(password);
		System.out.println(passHasheada);

		String query = ("DELETE FROM users where username = '" + userName + "' and password = '" + passHasheada + "';");

		boolean respuesta = ConnectionDB.executeUpdate(query);

		if (respuesta) {
			return ("Tus datos han sido Eliminados correctamentos");
		}
		return ("Verfique los datos ingresados!");
	}

}
