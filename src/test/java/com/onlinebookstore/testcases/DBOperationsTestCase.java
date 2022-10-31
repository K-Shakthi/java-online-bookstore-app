package com.onlinebookstore.testcases;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.onlinebookstore.dbconnect.CustomerService;

public class DBOperationsTestCase {
	
	CustomerService obj=new CustomerService();
	
	@Test
	public void testSearchByBookName1() throws SQLException
	{
		ResultSet res=CustomerService.search_by_book_name("Harry Potter");
		res.next();
		String bookName=res.getString(2);
		assertEquals("Harry Potter",bookName);		
	}
	

	@Test
	public void testSearchByBookName2() throws SQLException
	{
		ResultSet res=CustomerService.search_by_book_name("Rob-Hood");
		res.next();
		String bookName=res.getString(2);
		assertEquals("Rob-Hood",bookName);		
	}
	
	@Test
	public void testSearchByAuthorName1() throws SQLException
	{
		ResultSet res=CustomerService.search_by_author_name("Kalki");
		res.next();
		String authorName=res.getString(3);
		assertEquals("Kalki",authorName);		
	}
	
	@Test
	public void testSearchByAuthorName2() throws SQLException
	{
		ResultSet res=CustomerService.search_by_author_name("Jules Verne");
		res.next();
		String authorName=res.getString(3);
		assertEquals("Jules Verne",authorName);		
	}
}
