package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Owner;

/**
 * Servlet implementation class AddOwnerServlet
 */
@WebServlet("/addOwnerServlet")
public class AddOwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOwnerServlet() {
        
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		if (firstName.equals("") || lastName.equals("") || firstName == null || lastName == null) {
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		} else {
			Owner owner = new Owner(firstName, lastName);
			OwnerHelper dao = new OwnerHelper();
			dao.addOwner(owner);

			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}
	}

}
