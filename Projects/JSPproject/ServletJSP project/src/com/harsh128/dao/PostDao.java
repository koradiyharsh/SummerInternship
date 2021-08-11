package com.harsh128.dao;
import java.io.Console;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Set;

import javax.xml.ws.Response;

import java.util.List;
import com.harsh128.entities.Category;
import com.harsh128.entities.Post;
import com.harsh128.entities.User;



public class PostDao 

{

	Connection connection;
	
	public PostDao(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public ArrayList<Category> getAllCategories()
	{
		
		ArrayList<Category> list= new ArrayList<>();
		
		
		
		try {
			
			String qString = "select * from categories";
			Statement statement = connection.createStatement();
			ResultSet rSet = statement.executeQuery(qString);
			
			
			while(rSet.next())
			{
				
				
			int cid =  rSet.getInt("cid");
			String name = rSet.getString("name");
			String description  =  rSet.getString("description");
			
			Category category = new Category(cid, name, description);
			
			
			list.add(category);
				
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		return list;
		
	}
	
	
	public  boolean savePost( Post p)
	{
	boolean flag = false;
	try {
		
		String query  = "insert into posts(pTitle , pContent , pCode, catId ,  userId) values(?,?,?,?,?)";
		System.out.print("Insert");
		PreparedStatement pst = connection.prepareStatement(query);
		pst.setString(1, p.getpTitle());
		pst.setString(2, p.getpContent());
		pst.setString(3 , p.getpCode());
		pst.setInt(4 ,p.getCatId());
		pst.setInt(5 ,  p.getUserId());
		System.out.println("HH");
		pst.executeUpdate();
		
		flag = true;
		
		
		
		
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return flag;
	}

	
	
	public List<Post> getAllPost()
	{
		
		List<Post> list = new ArrayList<Post>();
				
			// fetch all post
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from posts order by pid desc");
			
			ResultSet set = preparedStatement.executeQuery();
			
			
			while(set.next())
			{
				
				int pid  = set.getInt("pid");
				String pTitle = set.getString("pTitle");
				String pContent = set.getString("pContent");
				String pCode =  set.getString("pCode");
				Timestamp pDate = set.getTimestamp("pDate");
				int catId  =  set.getInt("catId");
				int userId = set.getInt("userId");
				Post post = new Post(pid, pTitle, pContent, pCode, pDate, catId, userId);
				list.add(post);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	public List<Post> getPostByCatId(int catId)
	{
		
		
		List<Post> list = new ArrayList<Post>();
		
		// fetch all post by id
		
		
try {
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from posts where catId=?");
			preparedStatement.setInt(1, catId);
			ResultSet set = preparedStatement.executeQuery();
			
			
			while(set.next())
			{
				
				int pid  = set.getInt("pid");
				String pTitle = set.getString("pTitle");
				String pContent = set.getString("pContent");
				String pCode =  set.getString("pCode");
				Timestamp pDate = set.getTimestamp("pDate");
				
				int userId = set.getInt("userId");
				Post post = new Post(pid, pTitle, pContent, pCode, pDate, catId, userId);
				list.add(post);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}

	
	public Post getPostById(int postId)
	{
		Post post = null;
		String q = "select * from posts where pid=?";
		try {
			PreparedStatement p =  this.connection.prepareStatement(q);
			p.setInt(1, postId);
			
			ResultSet set = p.executeQuery();
			if(set.next())
			{
				
				
				int pid  = set.getInt("pid");
				String pTitle = set.getString("pTitle");
				String pContent = set.getString("pContent");
				String pCode =  set.getString("pCode");
				Timestamp pDate = set.getTimestamp("pDate");
				int catId = set.getInt("catId");
				int userId = set.getInt("userId");
				post = new Post(pid, pTitle, pContent, pCode, pDate, catId, userId);
				
				System.out.print("1");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return post;
		
		
		
		
		
		
		
		
		
	}
}
