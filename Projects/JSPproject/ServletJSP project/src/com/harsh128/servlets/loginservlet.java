package com.harsh128.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.harsh128.dao.UserDao;
import com.harsh128.entities.User;
import com.harsh128.entities.message;
import com.harsh128.helper.ConnectionProvider;


@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public loginservlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// fetch username and passwod
		PrintWriter out = response.getWriter();
		String useremail =  request.getParameter("email");
		String password =  request.getParameter("password");
		
		UserDao dao = new UserDao(ConnectionProvider.getConnection());
		User u =    dao.getUserByEmailandPassword(useremail, password);
		if(u == null)
		{
			//error
			//out.println("Invalid Deatil .. Try Again");
			message msg = new message("Invalid Deatils ! Try with Another", "error", "alert-danger");
			HttpSession session = request.getSession();
			session.setAttribute("msg", msg);
			response.sendRedirect("login_page.jsp");
		}
		else{
			HttpSession session = request.getSession();
			session.setAttribute("currentUser", u);
			response.sendRedirect("profile.jsp");
		}
	}

}
