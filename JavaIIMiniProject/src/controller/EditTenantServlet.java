package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Tenant;

/**
 * Servlet implementation class EditTenantServlet
 */
@WebServlet("/editTenantServlet")
public class EditTenantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTenantServlet() {
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
		TenantHelper dao = new TenantHelper();
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Tenant tenantToUpdate = dao.searchForTenantById(tempId);
		tenantToUpdate.setTenantName(name);
		tenantToUpdate.setPhone(phone);
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		tenantToUpdate.setDob(ld);
		dao.updateTenant(tenantToUpdate);
		getServletContext().getRequestDispatcher("/tenantNavigationServlet").forward(request, response);

	}

}
