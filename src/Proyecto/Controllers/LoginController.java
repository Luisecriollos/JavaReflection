package Proyecto.Controllers;

import Proyecto.Helpers.Authentication;
import Proyecto.Helpers.Hash;

public class LoginController {

	public static boolean IniciarSesion(String UNameLog, String PassLog) {

		String passHasheada = Hash.Encriptar(PassLog);
		int respuestaLogin = Authentication.Auth(UNameLog, passHasheada);

		return respuestaLogin == 1;
	}

}
