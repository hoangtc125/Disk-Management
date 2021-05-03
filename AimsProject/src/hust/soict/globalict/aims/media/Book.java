package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Book extends Media{

	private Collection<String> authors = new ArrayList<String>();
	private String content;
	private List<String> contentTokens = new ArrayList<String>();
	private TreeMap<String,Integer> wordFrequency = new TreeMap<String, Integer>();
	
	// ham khoi tao
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
	
	// getter and setter
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
		processContent();
	}
	
	void addAuthor(String authorName) {
		for(int i = 0; i < authors.size(); i++) {
			if(((ArrayList<String>) authors).get(i).compareTo(authorName) == 1) {
				System.out.println("the author is already in the List before adding");
				return;
			}
		}
		authors.add(authorName);
	}
	
	void removeAuthor(String authorName) {
		for(int i = 0; i < authors.size(); i++) {
			if(((ArrayList<String>) authors).get(i).compareTo(authorName) == 1) {
				authors.remove(i);
				System.out.println("already removed the author");
				return;
			}
		}
		System.out.println("the author is not already in the List before adding");
	}
	
	public String showInfo() {
		return ".Book-[" + getTitle() + "]-[" + getCategory() 
		+ "]" + "]" + ":[" + getCost() + "]$";
	}
	public void processContent() {
		String [] tmp = getContent().split(" ");
		
		for (String string : tmp) {
			contentTokens.add(string);
		}
		Collections.sort(contentTokens);
		for (int i = 0; i < contentTokens.size(); i++) {
			if(wordFrequency.containsKey(contentTokens.get(i))) {
				wordFrequency.put(contentTokens.get(i), wordFrequency.get(contentTokens.get(i)) + 1);
			} else {
				wordFrequency.put(contentTokens.get(i), 1);
			}
		}
		System.out.println(wordFrequency);
	}
	public int compareTo(Book media) {
		return this.getCost() < media.getCost() ? -1 : 1;
	}
	public String toString() {
		String resString = "the number of authors: " + authors.size() + "\n" + 
				"content: " + this.getContent() + "\n" + "wordFrequency: ";
		Set<String> keySet = wordFrequency.keySet();
        for (String key : keySet) {
            resString += "('" + key + "' - " + wordFrequency.get(key) + ")";
        }
		return resString;
	}
}
