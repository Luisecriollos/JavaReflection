package Proyecto.Controllers;

import Proyecto.Entities.User;
import Proyecto.Helpers.*;

public class RegisterController {

	public static String RegistrarDB(User user) {

		String PassHash = Hash.Encriptar(user.getPasswordHsh());

		String query = ("insert into users values ('" + user.getUsername() + "', '" + PassHash + "', '"
				+ user.getEmail() + "', " + user.getAge() + ", '" + user.getCountry() + "', '" + user.getGender()
				+ "')");

		boolean respuestaRegistro = ConnectionDB.executeUpdate(query);
		if (respuestaRegistro) {
			System.out.println("Registro Exitoso");
			return "Felicidades! tu registro se ha realizado exitosamente";
		} else
			System.out.println("error en el registro");
		return "Ocurrio un error al momento Registrarte, intentalo nuevamente";
	}

}
