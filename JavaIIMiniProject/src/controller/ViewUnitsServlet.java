package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewUnitsServlet
 */
@WebServlet("/viewUnitsServlet")
public class ViewUnitsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewUnitsServlet() {
        super();
        //  Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//  Auto-generated method stub
		UnitHelper dao = new UnitHelper();
		request.setAttribute("allUnits", dao.showAllUnits());
		String path = "/unit-list.jsp";
		if(dao.showAllUnits().isEmpty()) {
			path = "/index.html";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//  Auto-generated method stub
		doGet(request, response);
	}

}
