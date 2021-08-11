package com.harsh128.dao;
import java.sql.*;


public class LikeDao {
	
	Connection connection;
	
	public LikeDao(Connection connection) 
	{
		this.connection = connection;
	}

	public boolean InsertLike(int pid  , int uid)
	{
		boolean f = false;
		try {
			String query="insert into liked(pid,uid) values(?,?) ";
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setInt(1 , pid);
			statement.setInt(2 , uid);
			statement.executeUpdate();
			f= true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
		
	}

    public int countOnpost(int pid)
    {
    	int count =0;
    		
    	String query  = "select count(*) from liked where pid=?";
    	try {
    		
        	PreparedStatement pStatement = this.connection.prepareStatement(query);
        	pStatement.setInt(1, pid);
        	ResultSet resultSet= pStatement.executeQuery();
        	if(resultSet.next())
        	{
        		count = resultSet.getInt("count(*)");
        	}
		} catch (Exception e) {	
			e.printStackTrace();
		}
    	
    	
    	return 0;
    	
    }

    public boolean isLikedByUser(int pid , int uid)
    {
    	boolean f= false;
    	
    	try {
			String q="select * from liked where pid=? and uid=?";
			PreparedStatement pst =  this.connection.prepareStatement(q);
			pst.setInt(1, pid);
			pst.setInt(2, uid);
			
			ResultSet set=   pst.executeQuery();
			if(set.next())
			{
				f =  true;
			}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
    	
    	return f;
    }
    
    
    public  boolean deleteLike(int pid , int uid)
    {
    	
    	boolean f = false;
    	try {
    		String query = "delete from liked where pid=? and uid=?";
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setInt(1, pid);
			statement.setInt(2, uid);
			 
			statement.executeUpdate();
			
			f = true;
    		
		} catch (Exception e) {
		e.printStackTrace();
		}
    	
    	
    	return f;
    	
    }

}
