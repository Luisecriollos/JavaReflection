package Proyecto.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import org.json.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import Proyecto.Entities.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bodyStr = new String(request.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
		JSONObject body = new JSONObject(bodyStr);

		response.setContentType("text/html");

		// Obtener parametros
		User user = new User();
		user.setUsername(body.getString("username"));
		user.setPasswordHsh(body.getString("password"));
		user.setEmail(body.getString("email"));
		user.setAge(body.getInt("age"));
		user.setCountry(body.getString("country"));
		user.setGender(body.getString("gender"));

		
		// Intanciar el metodo Registrar y darle valor a sus parametros
		String message = "";
		if (user.save()) {
			response.setStatus(201);
			message = "Usuario creado con exito";
		} else {
			response.setStatus(500);
			message = "Hubo un error al crear el usuario";
		}

		PrintWriter out = response.getWriter();

		// Generar Respuesta
		out.println(message);
	}

}
