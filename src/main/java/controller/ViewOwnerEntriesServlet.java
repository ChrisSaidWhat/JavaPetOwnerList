package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Owner;

/**
 * Servlet implementation class ViewOwnerEntriesServlet
 */
@WebServlet("/viewOwnerEntriesServlet")
public class ViewOwnerEntriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewOwnerEntriesServlet() {
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OwnerHelper dao = new OwnerHelper();
		List<Owner> owners = dao.showAllOwners();
		
		request.setAttribute("allOwners", owners);
		
		String path ="/viewOwnerEntries.jsp";
		System.out.println(request.getAttribute("allOwners"));
		
		if(owners.isEmpty()) { path = "/index.html"; }
		 
		
		getServletContext().getRequestDispatcher(path).forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
