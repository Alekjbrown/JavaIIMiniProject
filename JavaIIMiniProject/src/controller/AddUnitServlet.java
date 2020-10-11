package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Unit;

/**
 * Servlet implementation class AddUnitServlet
 */
@WebServlet("/addUnitServlet")
public class AddUnitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUnitServlet() {
        super();
        //  Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Auto-generated method stub
		int beds;
		int baths;
		int floor;
		String address = request.getParameter("address");
		try {
			beds = Integer.parseInt(request.getParameter("beds"));
		} catch (NumberFormatException e) {
			//  Auto-generated catch block
			System.out.println("Invalid Bed Entry");
			beds = 0;
		}
		try {
			baths = Integer.parseInt(request.getParameter("baths"));
		} catch (NumberFormatException e) {
			// Auto-generated catch block
			System.out.println("Invalid Bath Entry");
			baths = 0;
		}
		try {
			floor = Integer.parseInt(request.getParameter("floor"));
		} catch (NumberFormatException e) {
			// Auto-generated catch block
			System.out.println("Invalid Floor Entry");
			floor = 0;
		}
		Unit u = new Unit(beds,baths,floor,address);
		UnitHelper dao = new UnitHelper();
		dao.insertUnit(u);;
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
