package com.demo.bookstorejdbc.dao; //data access objects

import java.util.List;

import com.demo.bookstorejdbc.models.Book;

//public class BookDao {
	
	public interface BookDao{
		boolean addBook(Book book);
		boolean updateBook(Book book);
		boolean deleteBook(int id);
		Book findBookById(int id);
		
		List<Book> findAllBooks();
		
	}
	

//}
