package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import beans.Salle;
import beans.User;
import service.SalleService;
import service.UserService;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/User")
public class UserController extends HttpServlet {

	private UserService us = new UserService();

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("op").equals("login")) {
			
				Gson json = new Gson();
				String data = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
				User userData = json.fromJson(data, User.class);
				;

				User user = us.find(userData.getEmail());

				if (user != null) {
					if (user.getPassword().equals(userData.getPassword())) {
						HttpSession session = request.getSession();
						session.setMaxInactiveInterval(0);
						session.setAttribute("user", user);
						System.out.println("ok");
						response.getWriter().write(json.toJson("true"));

					} else {
						System.out.println("not ok");
						
						response.getWriter().write(json.toJson("false"));
					}
				} else {
					System.out.println("not ok");
					
					response.getWriter().write(json.toJson("false"));
				}
			
		} 
		if (request.getParameter("op").equals("logout")) {
			
				try {
					HttpSession session = request.getSession();
					
					session.invalidate();
					response.sendRedirect("/GMachineAajax/pages/login.jsp");
					}catch(IllegalStateException err ) {
					err.printStackTrace();
				}
					
		
	} 
		
		if (request.getParameter("op").equals("register")) {
			Gson json = new Gson();
			String data = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
			User userData = json.fromJson(data, User.class);
			;

			Boolean success = us.create(userData);

			response.setContentType("application/json");
			response.getWriter().write(json.toJson(success));
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
