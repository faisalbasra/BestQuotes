package com.redrabbit.bestquotes.db;

public class QuoteORM {

	private int id_quote;
	private String quote;
	private String author;
	private String category;
	private int favourite;
	
	public QuoteORM() {}
	
	public QuoteORM(String quote, String author) {
		this(quote, author, "", 0);
	}

	public QuoteORM(String quote, String author, String category, int favourite) {
		this.quote = quote;
		this.author = author;
		this.category = category;
		this.favourite = favourite;
	}
	
	public int getId_quote() {
		return id_quote;
	}
	
	public void setId_quote(int id_quote) {
		this.id_quote = id_quote;
	}
	
	public String getQuote() {
		return quote;
	}
	
	public void setQuote(String quote) {
		this.quote = quote;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	public int getFavourite() {
		return favourite;
	}

	public void setFavourite(int favourite) {
		this.favourite = favourite;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Id: " + this.id_quote);
		sb.append("\n");
		sb.append("Quote: " + this.quote);
		sb.append("\n");
		sb.append("Author: " + this.author);
		sb.append("\n");
		sb.append("Category: " + this.category);
		sb.append("\n");
		sb.append("Favourite: " + this.favourite);
		
		return sb.toString();
	}
	
}
