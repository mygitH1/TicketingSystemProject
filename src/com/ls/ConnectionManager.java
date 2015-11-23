package com.ls;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManager {
	static Connection con;
	static String url;
        
    
    public static Connection getConnection()
    {
        
        try
        {
        	
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            try
            {            	
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system"); 
                										 
            }
            
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e);
        }
        return con;
    }

}
