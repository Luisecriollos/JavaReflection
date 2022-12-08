package Proyecto.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import org.json.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Proyecto.Controllers.LoginController;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
@MultipartConfig
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String bodyStr = new String(request.getInputStream().readAllBytes(), StandardCharsets.UTF_8);

		JSONObject body = new JSONObject(bodyStr);

		response.setContentType("text/html");

		// Obtener parametros

		String username = body.getString("username");
		String password = body.getString("password");

		// Intanciar el metodo login y darle valor a sus parametros
		boolean respuesta = LoginController.IniciarSesion(username, password);

		String message = "Sesion Iniciada Correctamente";
		if (respuesta) {
			response.setStatus(200);
			request.getSession(true);
		} else {
			response.setStatus(401);
			message = "Ocurrio un error al intentar iniciar la sesion, por favor verifique sus credenciales!";
		}

		PrintWriter out = response.getWriter();

		// Generar Respuesta

		out.println(message);

	}

}
