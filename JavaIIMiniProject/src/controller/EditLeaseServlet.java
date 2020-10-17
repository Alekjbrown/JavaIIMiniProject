package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Tenant;
import model.Unit;
import model.Lease;

/**
 * Servlet implementation class EditLeaseServlet
 */
@WebServlet("/editLeaseServlet")
public class EditLeaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditLeaseServlet() {
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

		UnitHelper uh = new UnitHelper();
		TenantHelper th = new TenantHelper();
		LeaseHelper lh= new LeaseHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Lease leaseToUpdate = lh.searchForLeaseById(tempId);
		Tenant tenant = th.searchForTenantById(leaseToUpdate.getTenant().getId());

		
		String newTenantName = request.getParameter("name");
		String newPhone = request.getParameter("phone");
		System.out.println("tenant name: " + newTenantName);
		
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
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
		
		tenant.setTenantName(newTenantName);
		tenant.setPhone(newPhone);
		tenant.setDob(ld);
//		th.updateTenant(tenant);
		
		String term = request.getParameter("term");
		LocalDate ed = leaseToUpdate.getEndDate();
				
		leaseToUpdate.setEndDate(ed);
		leaseToUpdate.setTenant(tenant);
		leaseToUpdate.setTerm(Integer.parseInt(term));
		leaseToUpdate.setUnit(u);
		lh.updateLease(leaseToUpdate);
		
		System.out.println("Success");
		System.out.println(leaseToUpdate.toString());
		
		getServletContext().getRequestDispatcher("/viewLeasesServlet").forward(request, response);
		
		
		
		
		
		
		//		// TODO Auto-generated method stub
//		UnitHelper dao = new UnitHelper();
//		String add = request.getParameter("");
//		Unit unit = (Unit) dao.searchForUnitByAddress(add);
//		String name = request.getParameter("name");
//		TenantHelper th = new TenantHelper();
//		Tenant tenant = (Tenant) th.searchForTenantByName(name);
//		String phone = request.getParameter("phone");
//		Integer term = Integer.parseInt(request.getParameter("term"));
//		Integer end_date = Integer.parseInt(request.getParameter("endDate"));
//		LeaseHelper lp = new LeaseHelper();
//		Integer tempId = Integer.parseInt(request.getParameter("id"));
//		Lease leaseToUpdate = lp.searchForLeaseById(tempId);
//		leaseToUpdate.setTenant(tenant);
//		leaseToUpdate.setUnit(unit);
//		leaseToUpdate.setTerm(term);
//		
//		//lease end date
//		String month = request.getParameter("month");
//		String day = request.getParameter("day");
//		String year = request.getParameter("year");
//		LocalDate ld;
//		try {
//			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
//		} catch (NumberFormatException ex) {
//			ld = LocalDate.now();
//		}
//		leaseToUpdate.setEndDate(ld);
//		
//		lp.updateLease(leaseToUpdate);
//		getServletContext().getRequestDispatcher("/leaseNavigationServlet").forward(request, response);
	}
	
}
