package com.harsh128.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harsh128.dao.PostDao;
import com.harsh128.entities.Post;
import com.harsh128.entities.User;
import com.harsh128.helper.ConnectionProvider;


@WebServlet("/AddPostServlet")
@MultipartConfig
public class AddPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddPostServlet() {
        super();
        
    }

    
    
    
    
	

	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out  =  response.getWriter();
		String id  = request.getParameter("cid");
		int cid = 0;
		if(id!=null)
		{
			try {
				cid = Integer.parseInt(id);
			} catch (Exception e) {
				
			}
		}
		
		String pTitle = request.getParameter("pTitle");
		System.out.println(pTitle);
		String pContent  = request.getParameter("pContent");
		String pCode  = request.getParameter("pCode");
		
		// getting cuurunt id
		HttpSession session =  request.getSession();
		User user = (User)session.getAttribute("currentUser");
		
		
		Post post = new Post(pTitle, pContent, pCode, null, cid, user.getId());
		
		PostDao dao = new PostDao(ConnectionProvider.getConnection());
		if(dao.savePost(post))
		{
			out.println("done");
		}
		else{
			out.println("error");
		}
		

	}

	

}
