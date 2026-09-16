package com.JDBC.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DatabaseTest {
	
	@Test
	public void testDatabsseConnection() throws SQLException ,ClassNotFoundException{
		//1.Define Connection parameters
		String databaseURL="jdbc:mysql://localhost:3306/SeleniumAutomation";
		String user="root";
		String password="Hannsika123";
		
		//2.Load JDBC Driver (optional 
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(databaseURL,user,password);
		Statement stmt=con.createStatement();
		
		//3.Execute a Query
		String query ="SELECT * FROM SeleniumAutomation.book_detl;";
		ResultSet rs= stmt.executeQuery(query);
		
		//4.process the results
		while(rs.next()) {
			String auth=rs.getString("author");
			String tit=rs.getString("title");
			System.out.println("author :"+auth+"title:"+tit);
		}
		
		//5.close the connection
		con.close();
	}

}
