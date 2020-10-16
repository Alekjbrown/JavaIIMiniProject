package controller;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Tenant;
import controller.TenantHelper;

/**
 * Servlet implementation class TenantNavigationServlet
 */
@WebServlet("/tenantNavigationServlet")
public class TenantNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TenantNavigationServlet() {
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
				TenantHelper dao = new TenantHelper();
				String act = request.getParameter("doThisToTenant");
				if (act == null) {
					// no button has been selected
					getServletContext().getRequestDispatcher("/viewTenantsServlet").forward(request, response);
				}
				else if (act.equals("delete")) {
					try {
						Integer tempId = Integer.parseInt(request.getParameter("id"));
						Tenant itemToDelete = dao.searchForTenantById(tempId);
						dao.deleteTenant(itemToDelete);
						getServletContext().getRequestDispatcher("/viewTenantsServlet").forward(request, response);
					}catch (NumberFormatException e) {
						System.out.println("Forgot to select an item");
					} catch (RollbackException ee) {
						// TODO Auto-generated catch block
						ee.printStackTrace();
						System.out.println("foreign key constraint");
						getServletContext().getRequestDispatcher("/viewTenantsServlet").forward(request, response);
					}			
				} else if (act.equals("edit")) {
					try {
						Integer tempId = Integer.parseInt(request.getParameter("id"));
						Tenant tenantToEdit = dao.searchForTenantById(tempId);
						request.setAttribute("TenantToEdit", tenantToEdit);
						getServletContext().getRequestDispatcher("/edit-tenant.jsp").forward(request, response);
					} catch (NumberFormatException e) {
						System.out.println("Forgot to select an item");
					}
				} else if (act.equals("add")) {
					getServletContext().getRequestDispatcher("/new-tenant.jsp").forward(request, response);
					
				}
								
			}
	

}
