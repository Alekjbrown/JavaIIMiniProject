package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Tenant;
import controller.tenantHelper;

/**
 * Servlet implementation class AddTenantServlet
 */

// RENAMED addHouseServlet to update tenant only
@WebServlet("/addTenantServlet")
public class AddTenantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddTenantServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tenName = request.getParameter("name");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String phone = request.getParameter("phone");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}catch(NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		Tenant tenant = new Tenant(tenName, ld, phone);
		tenantHelper dao = new tenantHelper();
		dao.insertTenant(tenant);
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		
	}

}
