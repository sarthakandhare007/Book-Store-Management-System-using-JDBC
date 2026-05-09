package com.demo.bookstorejdbc.models;

public class Book {
	private String title,author,descrption;
	private int price;

	private int id ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescrption() {
		return descrption;
	}
	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", descrption=" + descrption + ", price="
				+ price + "]";
	}
	Book(){
		
	}
	public Book(int id,String title, String author, String descrption, int price ) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.descrption = descrption;
		this.price = price;
		
	}
	
}
