package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Unit;

/**
 * Servlet implementation class EditUnitServlet
 */
@WebServlet("/editUnitServlet")
public class EditUnitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUnitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UnitHelper dao = new UnitHelper();
		String bds = request.getParameter("beds");
		String bths = request.getParameter("baths");
		String flr = request.getParameter("floor");
		String address = request.getParameter("address");
		int beds, baths, floor;
		try {
		   beds = Integer.parseInt(bds);
		   baths = Integer.parseInt(bths);
		   floor = Integer.parseInt(flr);
		}
		catch (NumberFormatException e)
		{
			beds = 0;
			baths = 0;
			floor = 0;
		}
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Unit unitToUpdate = dao.searchForUnitById(tempId);
		unitToUpdate.setBeds(beds);
		unitToUpdate.setBaths(baths);
		unitToUpdate.setFloor(floor);
		unitToUpdate.setAddress(address);
		
		dao.updateUnit(unitToUpdate);
		getServletContext().getRequestDispatcher("/viewUnitsServlet").forward(request, response);

	}

}