package com.harsh128.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harsh128.entities.message;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import sun.rmi.log.LogOutputStream;


@WebServlet("/logoutServlet")
public class logoutServlet extends HttpServlet {
	
       
    
	
    public logoutServlet() {
        super();
       
    }
    
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	
    	HttpSession session = request.getSession();
    	session.removeAttribute("currentUser");
    	
    	message msg = new message("Logout Sucessfully", "success", "alert-success");
    	
    	session.setAttribute("msg", msg);
    	response.sendRedirect("login_page.jsp");
    	
    }
	
	
}
