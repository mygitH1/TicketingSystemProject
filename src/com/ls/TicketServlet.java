package com.ls;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ls.TicketBean;
import com.ls.TicketDao;
import com.ls.RandomInteger;
public class TicketServlet extends HttpServlet {
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
  
	    TicketBean ticket=new TicketBean();
	    ticket.setIp(req.getRemoteAddr());
	    ticket.setTicketNo(req.getParameter("tno"));
	    ticket.setSubject(req.getParameter("sub"));
	    ticket.setDescription(req.getParameter("desc"));
	    ticket.setPriority(req.getParameter("proir"));
	    ticket=TicketDao.insert(ticket);
	    if(ticket.isFlag()){
	    	RequestDispatcher rd=req.getRequestDispatcher("/form.jsp");
			rd.forward(req, resp);
	    }else{
	    	RequestDispatcher rd=req.getRequestDispatcher("/error2.jsp");
			rd.forward(req, resp);
	    }
 
 }
}
