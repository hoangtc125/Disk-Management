package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{

	private List<String> authors = new ArrayList<String>();

	public Book() {
		super();
	}
	public Book(String title){
		super(title);
		}
	public Book(String title, String category){
		super(title, category);
	}	
	public Book(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public Book(String title, String category, List<String> authors){
		super(title, category);
		for (String author : authors) {
			authors.add(author);
		}
	}
	void addAuthor(String authorName) {
		for(int i = 0; i < authors.size(); i++) {
			if(authors.get(i).compareTo(authorName) == 1) {
				System.out.println("the author is already in the List before adding");
				return;
			}
		}
		authors.add(authorName);
	}
	
	void removeAuthor(String authorName) {
		for(int i = 0; i < authors.size(); i++) {
			if(authors.get(i).compareTo(authorName) == 1) {
				authors.remove(i);
				System.out.println("already removed the author");
				return;
			}
		}
		System.out.println("the author is not already in the List before adding");
	}
	
	public void showInfo() {
		System.out.print(". Book - [" + getTitle() + "] - [" + getCategory() 
		+ "]" + "]" + ": [" + getCost() + "] $");
		System.out.print(" authors: ");
		for (String string : authors) {
			System.out.print(" " + string);
		}
	}
}
