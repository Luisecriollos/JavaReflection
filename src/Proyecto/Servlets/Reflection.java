package Proyecto.Servlets;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;

import org.json.JSONException;
import org.json.JSONObject;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Reflection
 */
@WebServlet("/Reflection")
public class Reflection extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Reflection() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		JSONObject body = new JSONObject(new String(request.getInputStream().readAllBytes(), StandardCharsets.UTF_8));
		try {
			Method method = this.getClass().getDeclaredMethod(body.getString("method"));
			String result = (String) method.invoke(null);
			
			out.println(result);
			return;
		} catch (NoSuchMethodException e) {
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		out.println("Esta funcion no existe");

	}

	public static String funcionExistente() {
		return "Esto es una funcion Existente";
	}

	public static String funcionReflectiva() {
		return "Esto es una funcion Reflectiva";
	}
	
	public static String funcionLoca() {
		return "Esto es una funcion loca";
	}

}
