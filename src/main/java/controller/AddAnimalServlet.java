package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Animal;
import model.Owner;

/**
 * Servlet implementation class AddAnimalServlet
 */
@WebServlet("/addAnimalServlet")
public class AddAnimalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAnimalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String date = request.getParameter("adoptDate");
		
		//	needed different implementation based on how the Animal model developed
		
//		String month = request.getParameter("month");
//		String day = request.getParameter("day");
//		String year = request.getParameter("year");
		
//		LocalDate date;
//		try {
//			date = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
//		}catch (NumberFormatException ex){
//			date = LocalDate.now();
//		}
		
		System.out.println(name);
		System.out.println(type);
		System.out.println(date);
		
		if (name == null || type == null || date == null || name.equals("") || type.equals("") || date.equals("")) {
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		} else {
			Animal animal = new Animal(name,type,date);
			AnimalHelper dao = new AnimalHelper();
			dao.addAnimal(animal);

			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}
		
	}

}
