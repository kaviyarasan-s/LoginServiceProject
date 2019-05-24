package com.cs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cs.util.ConnectionUtil;

public class LoginDAO {

	public static boolean success(String username, String password)
			throws SQLException, ClassNotFoundException {
		Connection connection = ConnectionUtil.getConnection();
		Boolean isValue = false;
		String sql = "select login_id from login where user_name=? AND password=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			if (rs.getInt("login_id")>0) {
				isValue = true;
			}
		}
		return isValue;
	}
}
