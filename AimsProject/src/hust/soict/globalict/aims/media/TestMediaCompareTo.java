package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.Collection;

public class TestMediaCompareTo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection<Media> itemsOrdered = new ArrayList<Media>();
		java.util.Collection collection = new java.util.ArrayList();
		Media dvd1 = new DigitalVideoDisc("the lion king", "cate 1", 87);
		Media dvd3 = new DigitalVideoDisc("aladin", "cate 1", 90);
		Media dvd2 = new DigitalVideoDisc("star wars", "cate 2", 124);
		// add the dvd objects to the arrayList
		collection.add(dvd1);
		collection.add(dvd2);
		collection.add(dvd3);
		itemsOrdered.add(dvd2);
		itemsOrdered.add(dvd1);
		itemsOrdered.add(dvd3);
//		DigitalVideoDisc cd1 = new DigitalVideoDisc("hoang", 12);
//		
//		DigitalVideoDisc cd2 = new DigitalVideoDisc("nguyen", 131);
//		
//		DigitalVideoDisc cd3 = new DigitalVideoDisc("tmp", 15);
		
//		collection.add(cd1);
//		collection.add(cd2);
//		collection.add(cd3);
		
		// iterator through the arrayList and output their titles
		// (unsorted order)
		java.util.Iterator iterator = itemsOrdered.iterator();
		
		System.out.println("--------------------------------------");
		System.out.println("the dvds currently in the order ");
		while(iterator.hasNext()) {
			System.out.println(((Media)iterator.next()).getTitle());
		}
		// sort the collection of dvds - based on the compareTo()
		// method
		java.util.Collections.sort((java.util.List)itemsOrdered);
		
		// iterator through the arrayList and output their titles
		// (in sorted order)
		iterator = itemsOrdered.iterator();
		
		System.out.println("--------------------------------------");
		System.out.println("the dvds is sorted order are ");
		while(iterator.hasNext()) {
			Media tmp = (Media)iterator.next();
			System.out.println(tmp.getTitle() + " : " + tmp.getCost());
		}
	}

}
