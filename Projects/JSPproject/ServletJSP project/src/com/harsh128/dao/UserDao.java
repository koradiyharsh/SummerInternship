package com.harsh128.dao;
import java.sql.*;
import java.util.Set;
import java.sql.Timestamp;
import com.harsh128.entities.User;




public class UserDao {
	
	private Connection connection;

	public UserDao(Connection connection) {
		super();
		this.connection = connection;
	}
	
	// method insert User into Database
	
	public boolean saveUser(User user)
	{
		boolean f = false;
		try {
			
			
			String query =  "insert into user(name , email , password , gender , about) values (?,?,?,?,?)";
			PreparedStatement pst=  this.connection.prepareStatement(query);
			pst.setString(1 ,  user.getName());
			pst.setString(2 , user.getEmail());
			pst.setString(3,  user.getPassword());
			pst.setString(4 ,  user.getGender());
			pst.setString(5,  user.getAbout());
			
			pst.executeUpdate();
			f = true;
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	// get user by username and password
	
	public User getUserByEmailandPassword(String email , String password)
	{
		User user =null;
		try {
		
			String query ="select * from user where email=? and password=?";
			PreparedStatement pamt = connection.prepareStatement(query);
			pamt.setString(1, email);
			pamt.setString(2, password);
			
			
			
			pamt.executeQuery();
			
			ResultSet rSet =  pamt.executeQuery();
			
			if(rSet.next())
			{
				user = new User();
				int col=1;
				String name = rSet.getString("name");
				user.setName(name);
				user.setId(rSet.getInt("id"));
				user.setEmail(rSet.getString("email"));
				user.setPassword(rSet.getString("password"));
				user.setGender(rSet.getString("gender"));
				user.setAbout(rSet.getString("about"));
				user.setDateTime(rSet.getTimestamp("rdate"));
				user.setProfile(rSet.getString("profile"));
				
				
				
				
				
			
			}
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		return user;
	}


	
	public boolean UpdateUser(User user)
	{
		
		boolean f = false;
		
		
		try {
		
			String query = "update user set name=? , email=? , password=? , gender=? ,about=? where id=?";
			PreparedStatement pStatement = connection.prepareStatement(query);
			pStatement.setString(1, user.getName());
			pStatement.setString(2 ,  user.getEmail());
			pStatement.setString(3, user.getPassword());
			pStatement.setString(4,  user.getGender());
			pStatement.setString(5,  user.getAbout());
			pStatement.setInt(6, user.getId());
			
			
			pStatement.executeUpdate();
			f = true;
			
			
			
		} catch (Exception e) {
		
		}
		
		
		return f;
		
		
		
		
		
		
	}

	
	public User getUserById(int userId)
	{
		User user = null;
			
		
		try {
			String query = "select * from user where id=?";
			PreparedStatement pStatement = this.connection.prepareStatement(query);
			pStatement.setInt(1, userId);
			ResultSet rSet = pStatement.executeQuery();
			
			if(rSet.next())
			{
				
				user = new User();
				
				String name = rSet.getString("name");
				user.setName(name);
				user.setId(rSet.getInt("id"));
				user.setEmail(rSet.getString("email"));
				user.setPassword(rSet.getString("password"));
				user.setGender(rSet.getString("gender"));
				user.setAbout(rSet.getString("about"));
				user.setDateTime(rSet.getTimestamp("rdate"));
				user.setProfile(rSet.getString("profile"));
				
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		return user;
	}
}
