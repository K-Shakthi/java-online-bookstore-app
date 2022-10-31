package com.onlinebookstore.dbconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CustomerService {
	
	static Connection conn=DBConnection.connect();
	
	static Scanner scan=new Scanner(System.in);
	
	public static void available_books()
	{	
		try
		{   String sqlQuery="select * from Books";
			PreparedStatement ps=conn.prepareStatement(sqlQuery);
			ResultSet result=ps.executeQuery();
			
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
				
			System.out.printf("%20s %16s %24s %27s %19s %22s\n","BookId","BookName","AuthorName","Publication","Genre","Price");
	
			System.out.println();
			
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
			
			while(result.next())
			{
				System.out.format("%18s %20s %22s %29s %24s %15s\n",result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getLong(6));
			}
			
			System.out.println();
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
		
		}
		catch(Exception e)
		{
			
			System.out.println(e.getMessage());
			
		}
		
	}	
			
	public static ResultSet search_by_book_name(String bookName) throws SQLException
	{
		
		PreparedStatement ps=conn.prepareStatement("select * from Books where bookName=?");
		ps.setString(1, bookName);
		ResultSet result=ps.executeQuery();
		
		return result;
	}
	
	public static ResultSet search_by_author_name(String authorName) throws SQLException
	{   
		PreparedStatement ps=conn.prepareStatement("select * from Books where authorName=?");
		ps.setString(1,authorName);
		ResultSet result=ps.executeQuery();
		
		return result;
	}
	
	public static void about()
	{
		System.out.println("We are providing a wide range of books in our Book Store \nYou can access it easily");
	}
	
	public static void help_desk()
	{
		System.out.println("Contact Us:9763254018 \nWebsite:www.worldofbooks.com");
	}
	
}	
	