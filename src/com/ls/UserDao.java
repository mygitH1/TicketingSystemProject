package com.ls;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.ls.LogBean;

public class UserDao {
	static Connection currentCon = null;
	static ResultSet rs = null;
	public static LogBean login(LogBean bean){
		
		
		Statement stmt=null;
		
		String username=bean.getUsername();
		String password=bean.getPassword();
		String type=bean.getType();
		String searchQuery =
	        "select * from users_details where type='"+type+"' AND username='"
	            + username
	            + "' AND password='"
	            + password
	            + "'";
		System.out.println(searchQuery);
		try{
			currentCon=ConnectionManager.getConnection();
			stmt=currentCon.createStatement();
			rs=stmt.executeQuery(searchQuery);
			boolean flag=rs.next();
			if(!flag){
				bean.setValid(false);
			}else if(flag){
				bean.setValid(true);
			}
			
		}catch (Exception e) {
			
		}
		finally 
	    {
	        if (rs != null)	{
	            try {
	                rs.close();
	            } catch (Exception e) {}
	            rs = null;
	        }
	
	        if (stmt != null) {
	            try {
	                stmt.close();
	            } catch (Exception e) {}
	            stmt = null;
	        }
	
	        if (currentCon != null) {
	
	            try {
	                currentCon.close();
	            } catch (Exception e) {
	            }
	            currentCon = null;
	
	        }
	    }
		return bean;
	}

}
