package com.cs.auth;

import java.sql.SQLException;

import com.cs.dao.LoginDAO;

public class Authentication {

	public static boolean isLogin(String username,String password) throws ClassNotFoundException, SQLException
	{
		return LoginDAO.success(username,password);
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		if(isLogin("kav@gmail.com", "1234")){
			System.out.println("Success");
		}else {
			System.out.println("failure");
		}
	}
}
