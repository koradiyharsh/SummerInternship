package com.harsh128.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.harsh128.dao.UserDao;
import com.harsh128.entities.User;
import com.harsh128.helper.ConnectionProvider;


@WebServlet("/RegisterServlet")
@MultipartConfig
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegisterServlet() {
        super();
         
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		String check = request.getParameter("check");
		if(check ==null)
		{
			out.println("please check term and condition.");
		}
		else{
			//baki ka data
			
			
			
			
			String name = request.getParameter("user_name");
			String email = request.getParameter("user_email");
			String password =  request.getParameter("user_password");
			String gender =  request.getParameter("gender");
			String about =  request.getParameter("about");
			
			// create user data and set all data to that object.
			
			
			User user = new User(name , email , password , gender , about);
			
			// userDao Obj
			
			UserDao dao = new UserDao(ConnectionProvider.getConnection());
			 if(dao.saveUser(user)){
				 out.println("done");
				 response.sendRedirect("login_page.jsp");
			 }
			 else{
				 out.println("error");
			 }


			
			
			
			
			
			
			
			
			
			
			
			
		}
		
	}

}
