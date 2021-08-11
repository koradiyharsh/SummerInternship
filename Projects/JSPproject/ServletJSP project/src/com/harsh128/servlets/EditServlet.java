package com.harsh128.servlets;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.harsh128.dao.UserDao;
import com.harsh128.entities.User;
import com.harsh128.helper.ConnectionProvider;


@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	
       
    
    public EditServlet() {
        super();
        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		PrintWriter out =  response.getWriter();
		
		String userEmail = request.getParameter("user_email");
		String userName =  request.getParameter("user_name");
		String password =  request.getParameter("user_password");
		String about =  request.getParameter("about");
		
		// get the user from the session..
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("currentUser");
		
		
		user.setEmail(userEmail);
		user.setName(userName);
		user.setPassword(password);
		user.setAbout(about);
		
		
		
		// update database
		UserDao userDao = new UserDao(ConnectionProvider.getConnection());
		
		boolean ans = userDao.UpdateUser(user);
		
		if(ans == true)
		{
				out.println("Updated");
		}
		else{
			out.println("not updated");
		}
		
		
	}
	
	


	
	}
