<%@page import="com.entities.Note"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_js_css.jsp" %>
</head>
<body>
 <div class="container">
    	<%@include file="navbar.jsp" %>
    	<h1>Edit Your note</h1>
    	
    	<%
    	
    		int noteId  = Integer.parseInt(request.getParameter("note_id").trim());
    		Session sesion  = FactoryProvider.getFactory().openSession();
    		
    		Note note  =(Note)sesion.get(Note.class, noteId);
    		
    		sesion.close();
    	
    	%>
    	
    	
    	<form action="UpdateServlet" method="post">
    	
    	
    		<input value="<%= note.getId() %>" name="noteId" type="hidden"/>
			<div class="form-group">
				<label for="title">Note Title</label> <input required 
					type="text"
					name="title" 
					class="form-control" 
					id="title"
					aria-describedby="emailHelp"
					value="<%= note.getTitle() %>" 
					placeholder="Enter Here">

			</div>
			<div class="form-group">
				<label for="content">Note Content</label>
				<textarea required id="content" class="form-control" name="content"
					
					style="height: 300px"><%= note.getContent() %>
					</textarea>
			</div>

			<div class="container text-center">
				<button type="submit" class="btn btn-success">Save your note</button>
			</div>

		</form>
    	
    	
    	
    	
    	
    	
    	
    	
    	
    </div>
</body>
</html>