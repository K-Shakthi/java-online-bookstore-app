package com.onlinebookstore.operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.onlinebookstore.dbconnect.CustomerService;
import com.onlinebookstore.dbconnect.DBConnection;
import com.onlinebookstore.dbconnect.UserLogin;
import com.onlinebookstore.exceptions.InvalidAuthorNameException;
import com.onlinebookstore.exceptions.InvalidBookNameException;
import com.onlinebookstore.utility.UserInputValidation;

public class BookStoreOperations {

	public static void main(String[] args) throws NumberFormatException, IOException, SQLException, InvalidBookNameException, InvalidAuthorNameException {
		
		Connection conn=DBConnection.connect();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("************************** WORLD OF BOOKS **************************");
		boolean status=false;
		
	 try
	 {
		 System.out.print("\t\t Enter Login Id:");
		 String loginId=br.readLine();
		 
		 System.out.println();
		 
		 System.out.print("\t\t Enter Password:");
		 String password=br.readLine();
		 
		 status=UserLogin.login(loginId, password);
	 }
	 catch(Exception e)
	 {
		 System.out.println("Enter correct Login Id/Password!!");
	 }
		 
	 if(status==true)
	 {
		do
		{  		
		System.out.println("*************************WELCOME USER****************************");
			
		System.out.println("Select your Module:");
				
		System.out.println("\t\t 1 -> Available Books"); 
		System.out.println("\t\t 2 -> Search by Book Name");
		System.out.println("\t\t 3 -> Search by Author Name");
		System.out.println("\t\t 4 -> About");
		System.out.println("\t\t 5 -> Help_desk");
		System.out.println("\t\t 6 -> Logout");
		System.out.println("******************************************************************");
		System.out.println("Enter your choice:");
		System.out.println("******************************************************************");
		int choice=Integer.parseInt(br.readLine());
				
		switch(choice)
		{
		case 1:
			CustomerService.available_books();
			break;
		case 2:
			System.out.println("Enter the Book Name:");
			String bookName=br.readLine();
			ResultSet record=CustomerService.search_by_book_name(bookName);
			
			if(record.next())
			{
				System.out.println("Book Details:");
				System.out.println("Book Id:"+record.getString(1));
				System.out.println("Book Name:"+record.getString(2));
				System.out.println("Author Name:"+record.getString(3));
				System.out.println("Publication:"+record.getString(4));
				System.out.println("Genre:"+record.getString(5));
				System.out.println("Price:"+record.getString(6));
			}
			else
			{ 
			    throw new InvalidBookNameException("Book Name not found");	
			
			}
			
			break;
			
		case 3:
			System.out.println("Enter the Author Name:");
			String authorName=br.readLine();
			record=CustomerService.search_by_author_name(authorName);
			

			if(record.next())
			{
				System.out.println("Book Details:");
				System.out.println("Book Id:"+record.getString(1));
				System.out.println("Book Name:"+record.getString(2));
				System.out.println("Author Name:"+record.getString(3));
				System.out.println("Publication:"+record.getString(4));
				System.out.println("Genre:"+record.getString(5));
				System.out.println("Price:"+record.getString(6));
			}
			else
			{
				throw new InvalidAuthorNameException("Author Name not found");
			}
			
			break;
			
		case 4:
			CustomerService.about();
		    break;
		    
		case 5:
			CustomerService.help_desk();
			break;
			
		case 6:	
			System.out.println("Are you sure?");
			System.out.println("Y -> Yes / N -> No");
			String response=br.readLine();
			
			if(UserInputValidation.checkString(response))
			{
				if(response.equals("Y") || response.equals("y"))
				{
					status=false;
				}
			}
			break;
			
		default:
			System.out.println("Wrong choice!!");
					
		}
		
	 }		
		
	 while(status);
		
		System.out.println("Logged out successfully!!");
		System.out.println("Good Bye!!");
	
    }	
  }
	
}
