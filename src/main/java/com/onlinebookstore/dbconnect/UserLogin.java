package com.onlinebookstore.dbconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLogin {
	
	
	public static boolean login(String loginId,String password) throws SQLException
	{
		Connection conn=DBConnection.connect();
		
		PreparedStatement ps=conn.prepareStatement("select * from PersonDetails where loginId=?" );
		ps.setString(1,loginId);
		
		ResultSet result=ps.executeQuery();
		result.next();
		
		if(result.getString(5).equals(password))
		{
			return true;
		}
		else
		{
			return false;
		}	
	}
}
