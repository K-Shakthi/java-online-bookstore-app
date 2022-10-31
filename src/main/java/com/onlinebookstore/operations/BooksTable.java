package com.onlinebookstore.operations;

public class BooksTable {
	
	private int bookId;
	private String bookName;
	private String authorName;
	private String publication;
	private String genre;
	private long price;
	
	//generating getter and setter methods
	
	public int getBookId()
	{
		return bookId;
	}
	
	public void setBookId(int bookId)
	{
		this.bookId = bookId;
	}
	
	public String getBookName()
	{
		return bookName;
	}
	
	public void setBookName(String bookName) 
	{
		this.bookName = bookName;
	}
	
	public String getAuthorName() 
	{
		return authorName;
	}
	
	public void setAuthorName(String authorName) 
	{
		this.authorName = authorName;
	}
	
	public String getPublication()
	{
		return publication;
	}
	
	public void setPublication(String publication)
	{
		this.publication = publication;
	}
	
	public String getGenre() 
	{
		return genre;
	}
	
	public void setGenre(String genre)
	{
		this.genre = genre;
	}
	
	public long getPrice()
	{
		return price;
	}
	
	public void setPrice(long price)
	{
		this.price = price;
	}
	
	//creating a default constructor of the BooksTable class
	
	public BooksTable()
	{
		super();
	}
	
	//creating a parameterized constructor of the BooksTable class
	
	public BooksTable(int bookId,String bookName,String authorName,String publication,String genre,long price)
	{
		super();
		this.bookId=bookId;
		this.bookName=bookName;
		this.authorName=authorName;
		this.publication=publication;
		this.genre=genre;
		this.price=price;	
	}
}
