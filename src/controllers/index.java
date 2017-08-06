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
		
		
		
		request.getRequestDispatcher("WEB-INF/views/home.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String guess = request.getParameter("number");
		Integer randomsession = (Integer) session.getAttribute("randomsession");
		int guesstoInt = Integer.parseInt(guess);
		String correct = null;
		if (guesstoInt > randomsession) {
			correct = "Too high";
		} else if (guesstoInt < randomsession){
			correct = "Too low";
		} else {
			correct = "Correct";
			session.invalidate();
			doGet(request, response);
		}
		session.setAttribute("randomsession", randomsession);
		session.setAttribute("correct", correct);
		session.setAttribute("guesstoInt", guesstoInt);
		response.sendRedirect("/NumberGame/index");
	}

}
