package hust.soict.globalict.aims.media;

import java.util.Scanner;

public abstract class Media {

	protected String title;
	protected String category;
	protected float cost;
	protected int Id;
	public static int currentId = 0;
	
	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}

	public int getId() {
		return Id;
	}

	public static int getCurrentId() {
		return currentId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public void setId(int id) {
		Id = id;
	}

	public static void setCurrentId(int currentId) {
		Media.currentId = currentId;
	}

	public Media() {
		super();
	}
	
	public Media(String title) {
		super();
		this.title = title;
	}
	public Media(String title, String category) {
		super();
		this.title = title;
		this.category = category;
	}
	public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public abstract void showInfo();
	
}
