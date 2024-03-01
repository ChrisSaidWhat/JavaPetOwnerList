package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import model.Animal;
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
		AnimalHelper dao2 = new AnimalHelper();
		
		List<Owner> abc = dao.showAllOwners();
		List<Animal> abc2 = dao2.showAllAnimals();
		
		request.setAttribute("ownerEntries", abc);
		request.setAttribute("animalEntries", abc2);
	
		if(abc.isEmpty() || abc2.isEmpty()) {
			request.setAttribute("ownerEntries", "");
			request.setAttribute("animalEntries", "");
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
