package com.ls;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ls.LogBean;
import com.ls.UserDao;


public class TrackingServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		LogBean user = new LogBean();					
		
		user.setUsername(req.getParameter("name"));
		user.setPassword(req.getParameter("pwd"));
		user.setType(req.getParameter("type"));
		user = UserDao.login(user);
		System.out.println("Hi");
		if(user.isValid()){
			RequestDispatcher rd=req.getRequestDispatcher("/home.jsp");
			rd.forward(req, resp);
		}else{
			RequestDispatcher rd=req.getRequestDispatcher("/error.jsp");
			rd.forward(req, resp);
		}
	}

}
