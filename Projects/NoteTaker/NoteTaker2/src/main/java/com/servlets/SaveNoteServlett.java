
package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;


public class SaveNoteServlett extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SaveNoteServlett() {
        super();
       
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
		
			String title  = request.getParameter("title");
			String content =  request.getParameter("content");
			Note note  = new Note(title, content, new Date());
			
			
			// hibarnate save()
			
			Session session =  FactoryProvider.getFactory().openSession();
			
			
			Transaction  tx =  session.beginTransaction();
			
			session.save(note);
			
			
			tx.commit();
			session.close();
			
			response.setContentType("text/html");
			PrintWriter pw  =  response.getWriter();
			pw.println("<h1 style='text-align:center;'>Hello I am comback</h1>");
			pw.println("<h1 style='text-align:center;'><a href='all_notes.jsp'>View All Notes</a></h1>");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
