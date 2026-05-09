package com.demo.bookstorejdbc.test;

import java.util.List;
import java.util.Scanner;

import com.demo.bookstorejdbc.dao.BookDaoImpl;
import com.demo.bookstorejdbc.models.Book;
import com.demo.bookstorejdbc.dao.BookDao;

public class BookApplication {
	
	public static void main(String[] args) {
		int choice;
		Scanner sc=new Scanner(System.in);
		int id,price;
		String title,author,description;
		Book book=null;
		boolean response;
		BookDao dao =new BookDaoImpl();
		
		
		while (true) {
			
			System.out.println("================ BOOK STORE APP ==============");
			System.out.println("1. Add new Book");
			System.out.println("2. Update Book");
			System.out.println("3. Delete Book");
			System.out.println("4. Get Book details");
			System.out.println("5. Dispaly all books ");
			System.out.println("6. Exit");
			
			System.out.println("================Enter youur choice:===============");
			choice=sc.nextInt();
			
			
			switch (choice) {
			
			case 1: //add
				System.out.println("Please enter title,Author,description and price");
				sc.nextLine();
				title=sc.nextLine();
				author=sc.nextLine();
				description=sc.nextLine();
				price =sc.nextInt();
				book=new Book(0,title,author,description,price);
				response=dao.addBook(book);
				
				if(response == true) System.out.println("Book added  successfully");
				else System.out.println("Sorry cant add book");
				break;
				
			case 2: //update
				System.out.println("Please enter ID,title,Author,description and price");
				id=sc.nextInt();
				sc.nextLine();
				title=sc.nextLine();
				author=sc.nextLine();
				description=sc.nextLine();
				price =sc.nextInt();
				book=new Book(id,title,author,description,price);
				response=dao.updateBook(book);
				
				if(response == true) System.out.println("Book updated  successfully");
				else System.out.println("Sorry cant Update book");
				break;
				
			case 3://Delete 
				System.out.println("Please enter ID of book to delete");
				id=sc.nextInt();
				response=dao.deleteBook(id);
				if(response == true) System.out.println("Book Deleted  Successfully..!");
				else System.out.println("Sorry cant delete  book  enter valid id");
				break;
				
			case 4://Get Book details
				System.out.println("Please enter ID to search");
				id=sc.nextInt();
				book=dao.findBookById(id);
				if(book !=null)
					System.out.println(book);
				else
					System.err.println("Please enter valid book ID");
				break;
				
				
			case 5: //Display all books
				List<Book> allBooks=dao.findAllBooks();
				if(allBooks.size()>0)
					allBooks.forEach(bookObj->System.out.println(bookObj));
				else
					System.err.print("Sorry there are no books avalibale in bookstore..! please add book");
				
				break;
				
				
				
			case 6:
				System.out.println("==============*==*=THANK YOU FOR USING BOOKSTORE APP==*==*==============");
				System.exit(0);
				break;
			default:
				System.out.println("Enter valid choice..!");
			
			
			}
			
			
			
		}
		
		
		
		
	}

}
