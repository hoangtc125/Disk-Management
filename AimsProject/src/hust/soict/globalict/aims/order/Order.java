package hust.soict.globalict.aims.order;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.utils.MyDate;

public class Order {
	public static final int MAX_NUMBERS_ORDERED = 10;
	public static final int MAX_LIMITTED_ORDERS = 5;
	private Collection<Media> itemsOrdered = new ArrayList<Media>();
	public static int nbOrders = 0;
	private MyDate dateOrder;
	private int lucky = -1;

	public static void deleteOrder(int index) {
		
	}
	
	public Collection<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public int getLucky() {
		return lucky;
	}

	public void setLucky(int lucky) {
		this.lucky = lucky;
	}

	public Order() {
		super();
		dateOrder = new MyDate();
		nbOrders++;
	}
	
	public static boolean checkFull() {
		if(nbOrders < MAX_LIMITTED_ORDERS) {
			return true;
		}
		return false;
	}

	public int indexOfItem(Media disc) {
		if(itemsOrdered.size() == 0) {
			return -1;
		}
		for(int i = 0; i < itemsOrdered.size(); i++) {
			if(disc == ((ArrayList<Media>) itemsOrdered).get(i)) {
				return i;
			}
		}
		return -1;
	}

	public void addMedia(Media disc) {
		if(itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
//			System.out.println(">>> ADD FAILED!!! THE ORDER IS ALREADY FULL");
			return;
		}
		itemsOrdered.add(disc);
//		System.out.println(">>> ADD SUCCESSFULLY!!! TITLE number " + itemsOrdered.size() + " : " + disc.getTitle());
		return;
	}
	
	public void addMedia(List<Media> dvdList) {
		if(itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
			System.out.println(">>> ADD FAILED!!! THE ORDER IS ALREADY FULL");
			return;
		}
		int i = 0;
		while(itemsOrdered.size() < MAX_NUMBERS_ORDERED && i < dvdList.size()) {
			itemsOrdered.add(dvdList.get(i));
			System.out.println(">>> ADD SUCCESSFULLY!!! TITLE number " + itemsOrdered.size() + " : " + dvdList.get(i).getTitle());
			i++;
		}
		if(i < dvdList.size()) {
			System.out.println("the list of items that cannot be added to the current order because of full ordered \r\n" + 
					"items");
			for(int j = i; j < itemsOrdered.size(); j++) {
				System.out.println("- " + dvdList.get(i).getTitle());
			}
		}
		return;
	}
	
	public void addMedia(Media dvd1, Media dvd2) {
		if(itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
			System.out.println("ADD FAILED!!! THE ORDER IS ALREADY FULL");
			return;
		}
		if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) { 
			itemsOrdered.add(dvd1);
			System.out.println("ADD SUCCESSFULLY!!! TITLE number " + itemsOrdered.size() + " : " + dvd1.getTitle());
		}
		if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) { 
			itemsOrdered.add(dvd2);
			System.out.println("ADD SUCCESSFULLY!!! TITLE number " + itemsOrdered.size() + " : " + dvd2.getTitle());
		} else {
			System.out.println("DVD " + dvd2.getTitle() + " could not be added");
		}
		return;
	}
	
	public void removeMedia(Media disc) {
		int index = indexOfItem(disc);
		if(itemsOrdered.size() == 0 || index == -1) {
			System.out.println("REMOVE FAILED!!! THE ORDER IS ALREADY FULL");
			return;
		}
		itemsOrdered.remove(index);
		for (int i = index ; i < itemsOrdered.size(); i++) {
			((ArrayList<Media>) itemsOrdered).get(i).setId(((ArrayList<Media>) itemsOrdered).get(i).getId() - 1);
		}
		Media.currentId -= 1;
		System.out.println("REMOVE SUCCESSFULLY!!!");
		return;
	}
	
	public void removeMedia(int index) {
		if(itemsOrdered.size() == 0 || index >= itemsOrdered.size()) {
			System.out.println("REMOVE FAILED!!! THE ORDER IS EMPTY");
			return;
		}
		itemsOrdered.remove(((ArrayList<Media>) itemsOrdered).get(index));
		for (int i = index ; i < itemsOrdered.size(); i++) {
			((ArrayList<Media>) itemsOrdered).get(i).setId(((ArrayList<Media>) itemsOrdered).get(i).getId() - 1);
		}
		Media.currentId -= 1;
//		System.out.println("REMOVE SUCCESSFULLY!!!");
		return;
	}
	
	public float totalCost() {
		float sum = 0;
		for(int i = 0; i < itemsOrdered.size(); i++) {
			sum += ((ArrayList<Media>) itemsOrdered).get(i).getCost();
		}
		if(lucky != -1) {
			sum -= ((ArrayList<Media>) itemsOrdered).get(lucky).getCost(); 
		}
		return sum;
	}
	
	public void showOrderedList() {
		System.out.println("***********************Order***********************\r\n" + 
				"Date: [" + dateOrder.toString() + "]\r\n" + 
				"Ordered Items:");
		for(int i = 0; i < itemsOrdered.size(); i++) {
			System.out.print(i);
			((ArrayList<Media>) itemsOrdered).get(i).showInfo();
			if(i == lucky) {
				System.out.print(" ::: lucky and free item");
			}
			System.out.println();
		}
		System.out.println("Total cost: [" + (totalCost()) +"]");
		System.out.println("***************************************************");
	}

	public String getDetail(int i) {
		return (i + 1) + ((ArrayList<Media>) itemsOrdered).get(i).showInfo() + (lucky == -1 ? "" : lucky == i ? " (Lucky Item)" : "");
	}
	
	public boolean search(String title) {
		String [] tit = title.split(" ");
		for(int i = 0; i < itemsOrdered.size(); i++) {
			int count = tit.length;
			for (String string : tit) {
				if(((ArrayList<Media>) itemsOrdered).get(i).getTitle().contains(string)) {
					count--;
				}
			}
			if(count == 0) {
				return true;
			}
		}
		return false;
	}
	
	public static void swap(Object o1, Object o2) {
		Object tmp = o1;
		o1 = o2; 
		o2 = tmp;
	}
	
	public void sort() {
		java.util.Collections.sort((java.util.List)itemsOrdered);
		return;
	}
	
	public void getALuckyItem() {
		int random = -1;
		if(itemsOrdered.size() == 0) return;
		if(itemsOrdered.size() == 1) {
			lucky = 0;
			return;
		}
		do {
			random = (int)(Math.random() * MAX_NUMBERS_ORDERED);
		}while(random < 0 || random >= itemsOrdered.size());
		lucky = random;
		return;
	}
	
	public void showOrderedList(Media disc) {
		System.out.println("***********************Order***********************\r\n" + 
				"Date: [" + dateOrder.toString() + "]\r\n" + 
				"Ordered Items:");
		for(int i = 0; i < itemsOrdered.size(); i++) {
			System.out.print(i);
			((ArrayList<Media>) itemsOrdered).get(i).showInfo();
			if(i == lucky) {
				System.out.print(" ::: lucky and free item");
			}
			System.out.println();
		}
		System.out.println("Total cost: [" + (totalCost() - disc.getCost()) +"]");
		System.out.println("***************************************************");
	}
}
