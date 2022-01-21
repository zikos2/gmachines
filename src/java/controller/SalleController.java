package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.Machine;
import beans.Salle;
import service.SalleService;

/**
 * Servlet implementation class SalleController
 */
@WebServlet("/Salle")
public class SalleController extends HttpServlet {
	private SalleService ss = new SalleService();

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("op") != null) {
			if (request.getParameter("op").equals("load")) {
				response.setContentType("application/json");
				List<Salle> salles = ss.findAll();
				//System.out.println(salles);
				Gson json = new Gson();
				response.getWriter().write(json.toJson(salles));
			}
			
			if (request.getParameter("op").equals("add")) {
				response.setContentType("application/json");
				String code = request.getParameter("code");
				String type = request.getParameter("type");
				Boolean success = ss.create(new Salle(code,type));
				Gson json = new Gson();
				response.getWriter().write(json.toJson(success));
			}
			
			if (request.getParameter("op").equals("del")) {
				response.setContentType("application/json");
				Salle salle = ss.findById(Integer.parseInt(request.getParameter("id"))); 
				Boolean success = ss.delete(salle);
				Gson json = new Gson();
				response.getWriter().write(json.toJson(success));
			}
			
			if (request.getParameter("op").equals("find")) {
				response.setContentType("application/json");
				Salle salle = ss.findById(Integer.parseInt(request.getParameter("id"))); 
				Gson json = new Gson();
				response.getWriter().write(json.toJson(salle));
			}
			
			
			if (request.getParameter("op").equals("update")) {
				int id = Integer.parseInt(request.getParameter("salleId"));
				String code = request.getParameter("code");
				String type = request.getParameter("type");
				System.out.println(id+" "+code+" "+type);
				response.setContentType("application/json");
				Boolean success = ss.update(new Salle(id,code, type));
				Gson json = new Gson();
				response.getWriter().write(json.toJson(success));
			}
			
			
		} else {

		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}
}
