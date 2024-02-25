package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Animal;
import model.Owner;

/**
 * Servlet implementation class OwnerNavigationServlet
 */
@WebServlet("/ownerNavigationServlet")
public class OwnerNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OwnerNavigationServlet() {
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
		OwnerHelper dao = new OwnerHelper();
		String act = request.getParameter("doThisToItem");
		
		String path="/viewOwnerEntriesServlet";
		
		if(act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Owner toDelete = dao.searchForOwnerById(tempId);
				dao.deleteOwner(toDelete);
			}catch(NumberFormatException e) {
				System.out.println("Forgot to select an owner");
			}
			
		}else if(act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Owner toEdit = dao.searchForOwnerById(tempId);
				request.setAttribute("toEdit", toEdit);
				path="/editOwnerServlet.jsp";
			}catch(NumberFormatException e) {
				System.out.println("Forgot to select an owner");
			}
			
		}else if(act.equals("add")) {
			path="/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request,response);
	}

}
