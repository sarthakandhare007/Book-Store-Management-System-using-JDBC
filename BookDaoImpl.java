package com.demo.bookstorejdbc.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.bookstorejdbc.models.Book;


public class BookDaoImpl implements BookDao{
	
	Connection con;
	PreparedStatement ps;
	String query;
	int count;
	String url="jdbc:mysql://localhost:3306/t221_jdbc";
	String username="root";
	String password="root";
	boolean response=false;

	@Override
	public boolean addBook(Book book) {
		try {
			response=false;
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			query="insert into book(title,author,description,price) values(?,?,?,?);";
			ps=con.prepareStatement(query);
			ps.setString(1,book.getTitle());
			ps.setString(2,book.getAuthor());
			ps.setString(3,book.getDescrption());
			ps.setInt(4,book.getPrice());
			
			count=ps.executeUpdate(); //for DML queries(INSTERT,UPDATE,DELETE)
			if(count==1) response=true;
			
		}
		catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
			
		}
		finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return response;
	}

	@Override
	public boolean updateBook(Book book) {
		
		try {
			response=false;
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			query="update book set title=?,author=?,description=?,price=? where id=?";
			ps=con.prepareStatement(query);
			ps.setString(1,book.getTitle());
			ps.setString(2,book.getAuthor());
			ps.setString(3,book.getDescrption());
			ps.setInt(4,book.getPrice());
			ps.setInt(5,book.getId());
			
			count=ps.executeUpdate();
			if(count==1) response=true;
			
		}
		catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
			
		}
		finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return response;
	}

	@Override
	public boolean deleteBook(int id) {
		
		try {
			response=false;
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			query="delete from book where id=?";
			ps=con.prepareStatement(query);
			ps.setInt(1, id);
			
			count=ps.executeUpdate(); //for DML queries
			if(count==1) response=true;
			
		}
		catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
			
		}
		finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return response;
	}

	@Override
	public Book findBookById(int id) {
		Book book=null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			query="select * from book where id=?";
			ps=con.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery(); // use for select operation
			while(rs.next()) {
//				int bookId=rs.getInt("id");
				int bookId=rs.getInt(1);
				String bookTitle=rs.getString(2);
				String author=rs.getString(3);
				String description=rs.getString(4);
				int price =rs.getInt(5);
				book = new Book(bookId,bookTitle,author,description,price);
			}
			
		}
		catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
			
		}
		finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return book;
		
		
	}

	@Override
	public List<Book> findAllBooks() {
		List<Book>allBooks=new ArrayList<>();
		
try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			query="select * from book";
			ps=con.prepareStatement(query);
//			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery(); // use for select operation
			while(rs.next()) {
//				int bookId=rs.getInt("id");
				int bookId=rs.getInt(1);
				String bookTitle=rs.getString(2);
				String author=rs.getString(3);
				String description=rs.getString(4);
				int price =rs.getInt(5);
				Book book = new Book(bookId,bookTitle,author,description,price);
				allBooks.add(book);
				
			}
			
		}
		catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
			
		}
		finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return allBooks;
		
		
	}

}
