<%@page import="com.harsh128.entities.Post"%>
<%@page import="java.util.List"%>
<%@page import="com.harsh128.helper.ConnectionProvider"%>
<%@page import="com.harsh128.dao.PostDao"%>
<div class="row">
	<%
		PostDao d = new PostDao(ConnectionProvider.getConnection());
		
	
		int cid  = Integer.parseInt(request.getParameter("cid"));
		
		
		List<Post> posts = null;
		
		if(cid==0)
		{
		posts= d.getAllPost();
		}
		else{
		posts = d.getPostByCatId(cid);	
		}
		
		if(posts.size()==0)
		{
			out.println("<h3 class='display-3 text-center'>No Post Present Here...Plz Upload Post If you Want..</h3>");
		}
		for(Post p : posts)
		{
			
			%>

	<div class="col-md-6 mt-2">
		<div class="card ">
			
			<img class="card-img-top" style="height:150px; width:auto;" alt="hello" src="./pics/uploadImage.png">
			<div class="card-body">
				
				<h3>
				<b><%= p.getpTitle() %></b>
				<p><%= p.getpContent() %></p>
				
				</h3>
			</div>
             <div class="card-footer primary-background text-center">
             <a href="#!" class="btn btn-outline-light btn-md"><i class="fa fa-commenting-o"><span>20</span></i></a>
             	<a href="show_blog_page.jsp?post_id=<%= p.getPid() %>" class="btn btn-outline-light btn-sm">Read More...</a>
             	<a href="#!" class="btn btn-outline-light btn-md"><i class="fa fa-thumbs-o-up"><span>10</span></i></a>
             	
             	
             </div>
		</div>

	</div>





	<%
			
		}
%>
</div>