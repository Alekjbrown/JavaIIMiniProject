package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Lease;
import model.Tenant;
import model.Unit;

/**
 * Servlet implementation class CreateNewLeaseServlet
 */
@WebServlet("/createNewLeaseServlet")
public class CreateNewLeaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewLeaseServlet() {
        super();
        //  Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//  Auto-generated method stub
		UnitHelper uh = new UnitHelper();
		String tenantName = request.getParameter("name");
		System.out.println("tenant name: " + tenantName);
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String phone = request.getParameter("phone");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException e) {
			// Auto-generated catch block
			ld=LocalDate.now();
		}
		
		String selectedUnit = request.getParameter("unitToAdd");
		Unit u = new Unit();
		if(!selectedUnit.isEmpty()) {
			System.out.println(selectedUnit);
			u = uh.searchForUnitById(Integer.parseInt(selectedUnit));
		}
		
		Tenant t = new Tenant(tenantName, ld, phone);
		
		String term = request.getParameter("term");
		LocalDate ed = LocalDate.now().plusMonths(Integer.parseInt(term));
		
		
		Lease l = new Lease(u,t,Integer.parseInt(term),ed);
		
		LeaseHelper lh = new LeaseHelper();
		lh.insertLease(l);
		
		System.out.println("Success");
		System.out.println(l.toString());
		
		getServletContext().getRequestDispatcher("/viewLeasesServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Auto-generated method stub
		doGet(request, response);
	}

}
