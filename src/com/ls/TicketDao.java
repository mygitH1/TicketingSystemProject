package com.ls;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ls.TicketBean;;

public class TicketDao {
	static Connection currentCon = null;
	static ResultSet rs = null;
	public static TicketBean insert(TicketBean ticket){
		Statement stmt=null;
		String ip=ticket.getIp();
		String ticketNo=ticket.getTicketNo();
		String subject=ticket.getSubject();
		String desc=ticket.getDescription();
		String priority=ticket.getPriority();
		String query="insert into ticket_raise values('"+ip+"','"+ticketNo+"','"+subject+"','"+desc+"','"+priority+"'";
		System.out.println(query);
		try{
			currentCon=ConnectionManager.getConnection();
			stmt=currentCon.createStatement();
			int i=stmt.executeUpdate(query);
			if(i==1){
				ticket.setFlag(true);
			}else if(i==0){
				ticket.setFlag(false);
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
		return ticket;
	}
}
