package com.cs.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cs.auth.Authentication;

public class LoginServlet extends HttpServlet {
 
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("Email");
		String password=request.getParameter("Password");
//		System.out.println(userName+" "+password);
		//		Authentication authentication=new Authentication();
		boolean success;
		try {
			success = Authentication.isLogin(userName,password);
			if(success)
			{
				RequestDispatcher rs=request.getRequestDispatcher("success.html");
				rs.forward(request, response);
			}else
			{
				RequestDispatcher rs=request.getRequestDispatcher("Failure.html");
				rs.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
