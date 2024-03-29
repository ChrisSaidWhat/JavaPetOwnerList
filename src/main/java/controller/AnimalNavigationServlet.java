package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Animal;

/**
 * Servlet implementation class AnimalNavigationServlet
 */
@WebServlet("/animalNavigationServlet")
public class AnimalNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnimalNavigationServlet() {
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
		AnimalHelper dao = new AnimalHelper();
		String act = request.getParameter("doThisToItem");
		
		String path="/viewAnimalEntriesServlet";
		
		if(act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Animal toDelete = dao.searchForAnimalById(tempId);
				dao.deleteAnimal(toDelete);
			}catch(NumberFormatException e) {
				System.out.println("Forgot to select an animal");
			}
			
		}else if(act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Animal toEdit = dao.searchForAnimalById(tempId);
				request.setAttribute("toEdit", toEdit);
				path="/editAnimalServlet.jsp";
			}catch(NumberFormatException e) {
				System.out.println("Forgot to select an animal");
			}
			
		}else if(act.equals("add")) {
			path="/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request,response);
		
	}


}
