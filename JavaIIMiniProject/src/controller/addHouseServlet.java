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
 * Servlet implementation class addHouseServlet
 */
@WebServlet("/addHouseServlet")
public class addHouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public addHouseServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tenName = request.getParameter("tenant_name");
		LocalDate dob = request.getParameter("dob");
		String phone = request.getParameter("phone");
		Tenant tenant = new Tenant(tenName, dob, phone);
		tenantHelper dao = new tenantHelper();
		dao.insertTenant(tenant);
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		
	}

}
