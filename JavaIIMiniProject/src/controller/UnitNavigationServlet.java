package controller;

import java.io.IOException;

import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Unit;

/**
 * Servlet implementation class UnitNavigationServlet
 */
@WebServlet("/unitNavigationServlet")
public class UnitNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnitNavigationServlet() {
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
		String act = request.getParameter("doThisToUnit");
		if (act == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/viewUnitsServlet").forward(request, response);
		}
		else if (act.equals("delete")) {
				try {
					Integer tempId = Integer.parseInt(request.getParameter("id"));
					Unit itemToDelete = dao.searchForUnitById(tempId);
					dao.deleteUnit(itemToDelete);
					getServletContext().getRequestDispatcher("/viewUnitsServlet").forward(request, response);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Forgot to select an item");
				} catch (RollbackException ee) {
					ee.printStackTrace();
					System.out.println("Foreign Key Constraint");
					getServletContext().getRequestDispatcher("/viewUnitsServlet").forward(request, response);
				}
	
		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Unit unitToEdit = dao.searchForUnitById(tempId);
				request.setAttribute("UnitToEdit", unitToEdit);
				getServletContext().getRequestDispatcher("/edit-unit.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an item");
			}
		} else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/new-unit.jsp").forward(request, response);
			
		}
						
	}

}
