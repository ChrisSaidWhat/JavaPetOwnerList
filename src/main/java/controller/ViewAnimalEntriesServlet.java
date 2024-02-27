package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewAnimalEntriesServlet
 */
@WebServlet("/viewAnimalEntriesServlet")
public class ViewAnimalEntriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAnimalEntriesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnimalHelper dao = new AnimalHelper();
		
		request.setAttribute("allAnimals", dao.showAllAnimals());
		
		String path ="/viewAnimalEntries.jsp";
		
		if(dao.showAllAnimals().isEmpty()) {
			path = "/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnimalHelper dao = new AnimalHelper();
		
		request.setAttribute("allAnimals", dao.showAllAnimals());
		
		String path ="/viewAnimalEntries.jsp";
		
		if(dao.showAllAnimals().isEmpty()) {
			path = "/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request,response);
	}

}
