package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import model.Owner;

/**
 * Servlet implementation class ViewAllEntriesServlet
 */
@WebServlet("/viewAllEntriesServlet")
public class ViewAllEntriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllEntriesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OwnerHelper dao = new OwnerHelper();
		
		List<Owner> abc = dao.showAllOwners();
		request.setAttribute("allLists", abc);
	
		if(abc.isEmpty()) {
			request.setAttribute("allLists", "");
		}
		
		getServletContext().getRequestDispatcher("/viewAllEntries.jsp").forward(request, response);

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
