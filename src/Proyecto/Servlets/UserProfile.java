package Proyecto.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import Proyecto.Controllers.UserController;

/**
 * Servlet implementation class UserProfile
 */
@WebServlet("/UserProfile")
@MultipartConfig
public class UserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		// Obtener Valores

		// Valores Viejos
		String usernameUpdate = request.getParameter("usernameUpdate");
		String passwordUpdateOld = request.getParameter("passwordUpdateOld");
		String emailUpdateOld = request.getParameter("emailUpdateOld");
		String ageUpdateOld = request.getParameter("ageUpdateOld");
		String countryUpdateOld = request.getParameter("countryUpdateOld");
		String genderUpdateOld = request.getParameter("genderUpdateOld");

		// Valores Nuevos
		String passwordUpdateNew = request.getParameter("passwordUpdateNew");
		String emailUpdateNew = request.getParameter("emailUpdateNew");
		String ageUpdateNew = request.getParameter("ageUpdateNew");
		String countryUpdateNew = request.getParameter("countryUpdateNew");
		String genderUpdateNew = request.getParameter("genderUpdateNew");

		// Intanciar el metodo "Actualizar" y darle valor a sus parametros
		String respuesta = UserController.Update(usernameUpdate, passwordUpdateOld, emailUpdateOld, ageUpdateOld,
				countryUpdateOld, genderUpdateOld, passwordUpdateNew, emailUpdateNew, ageUpdateNew, countryUpdateNew,
				genderUpdateNew);

		PrintWriter out = response.getWriter();

		// Generar Respuesta
		out.println("<html><body>");
		out.println(respuesta);
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		// Obtener Valores
		String usernameDelete = request.getParameter("usernameDelete");
		String passwordDelete = request.getParameter("passwordDelete");

		// Ejecutar el metodo y obtener una respuesta
		String respuesta = UserController.Delete(usernameDelete, passwordDelete);

		PrintWriter out = response.getWriter();

		// Generar Respuesta
		out.println("<html><body>");
		out.println(respuesta);
		out.println("</body></html>");
	}

}
