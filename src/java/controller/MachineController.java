package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import beans.Machine;
import responses.MachineStatusCountResponse;
import responses.MachinesCount;
import responses.PricePerSalleResponse;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.MachineService;
import service.SalleService;

/**
 *
 * @author Lachgar
 */
@WebServlet(urlPatterns = { "/MachineController" })
public class MachineController extends HttpServlet {

	private MachineService ms = new MachineService();
	private SalleService ss = new SalleService();

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("op") != null) {
			if (request.getParameter("op").equals("load")) {
				response.setContentType("application/json");
				List<Machine> machines = ms.findAll();
				Gson json = new Gson();
				response.getWriter().write(json.toJson(machines));
			}

			if (request.getParameter("op").equals("delete")) {
				response.setContentType("application/json");
				Machine machine = ms.findById(Integer.parseInt(request.getParameter("id")));
				Boolean success = ms.delete(machine);
				Gson json = new Gson();
				response.getWriter().write(json.toJson(success));
			}

			if (request.getParameter("op").equals("find")) {
				response.setContentType("application/json");
				Machine machine = ms.findById(Integer.parseInt(request.getParameter("id")));
				Gson json = new Gson();
				response.getWriter().write(json.toJson(machine));
			}

			if (request.getParameter("op").equals("findBySalle")) {
				response.setContentType("application/json");
				List<Machine> machines = ms.findAll(Integer.parseInt(request.getParameter("idSalle")));
				Gson json = new Gson();
				response.getWriter().write(json.toJson(machines));
			}

			if (request.getParameter("op").equals("update")) {
				String reference = request.getParameter("reference");
				String status = request.getParameter("status");
				double prix = Double.parseDouble(request.getParameter("prix"));
				@SuppressWarnings("deprecation")
				Date dateAchat = new Date(request.getParameter("date").replace("-", "/"));
				int idSalle = Integer.parseInt(request.getParameter("salle"));
				int machineId = Integer.parseInt(request.getParameter("machineId"));
				System.out.println(prix + " " + reference + " " + dateAchat + " " + idSalle);

				response.setContentType("application/json");
				Boolean success = ms
						.update(new Machine(machineId, reference, dateAchat, prix, ss.findById(idSalle), status));
				Gson json = new Gson();
				response.getWriter().write(json.toJson(success));
			}

			if (request.getParameter("op").equals("findDate")) {
				@SuppressWarnings("deprecation")
				Date date1 = new Date(request.getParameter("startDate").replace("-", "/"));
				Date date2 = new Date(request.getParameter("endDate").replace("-", "/"));
				List<Machine> machines = ms.findAll(date1, date2);
				response.setContentType("application/json");
				Gson json = new Gson();
				response.getWriter().write(json.toJson(machines));
			}
			if (request.getParameter("op").equals("pricePerSalle")) {

				List<PricePerSalleResponse> results = ms.pricePerSalle();
				response.setContentType("application/json");
				Gson json = new Gson();
				response.getWriter().write(json.toJson(results));
			}

			if (request.getParameter("op").equals("statusCount")) {

				List<MachineStatusCountResponse> results = ms.statusCount();
				response.setContentType("application/json");
				Gson json = new Gson();
				response.getWriter().write(json.toJson(results));
			}
			
			if (request.getParameter("op").equals("machinesCount")) {

				List<MachinesCount> results = ms.machinesCount();
				response.setContentType("application/json");
				Gson json = new Gson();
				response.getWriter().write(json.toJson(results));
			}
		} else {
			String reference = request.getParameter("reference");
			double prix = Double.parseDouble(request.getParameter("prix"));
			@SuppressWarnings("deprecation")
			Date dateAchat = new Date(request.getParameter("date").replace("-", "/"));
			System.out.println(prix + reference);
			int idSalle = Integer.parseInt(request.getParameter("salle"));

			ms.create(new Machine(reference, dateAchat, prix, ss.findById(idSalle), "off"));

			response.setContentType("application/json");
			List<Machine> machines = ms.findAll();
			Gson json = new Gson();
			response.getWriter().write(json.toJson(machines));
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

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
