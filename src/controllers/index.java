package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;


@WebServlet("/index")
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public index() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Random randomGenerator = new Random();
		Integer randomsession = (Integer) session.getAttribute("randomsession");
		if (randomsession == null) {
			randomsession = randomGenerator.nextInt((101-0) +1);
		}
		session.setAttribute("randomsession", randomsession);
		
//		int randomsession = randomGenerator.nextInt(101-0) + 1;
		
		
		request.getRequestDispatcher("WEB-INF/views/home.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		doGet(request, response);
	}

}
