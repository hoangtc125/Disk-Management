package hust.soict.globalict.aims.media;

public class TestMediaCompareTo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Collection collection = new java.util.ArrayList();
//		DigitalVideoDisc dvd1 = new DigitalVideoDisc("the lion king", "cate 1", 87);
//		DigitalVideoDisc dvd3 = new DigitalVideoDisc("aladin", "cate 1", 90);
//		DigitalVideoDisc dvd2 = new DigitalVideoDisc("star wars", "cate 2", 124);
//		// add the dvd objects to the arrayList
//		collection.add(dvd1);
//		collection.add(dvd2);
//		collection.add(dvd3);
		CompactDisc cd1 = new CompactDisc("hoang");
		cd1.addTrack("cc", 19);
		cd1.addTrack("ddb", 22);
		cd1.addTrack("lol", 12);
		
		CompactDisc cd2 = new CompactDisc("nguyen");
		cd2.addTrack("rr", 20);
//		cd2.addTrack("loz", 13);
		
		CompactDisc cd3 = new CompactDisc("tmp");
//		cd3.addTrack("rr", 41);
		cd3.addTrack("loz", 13);
		
		collection.add(cd1);
		collection.add(cd2);
		collection.add(cd3);
		
		// iterator through the arrayList and output their titles
		// (unsorted order)
		java.util.Iterator iterator = collection.iterator();
		
		System.out.println("--------------------------------------");
		System.out.println("the dvds currently in the order ");
		while(iterator.hasNext()) {
			System.out.println(((CompactDisc)iterator.next()).getArtist());
		}
		// sort the collection of dvds - based on the compareTo()
		// method
		java.util.Collections.sort((java.util.List)collection);
		
		// iterator through the arrayList and output their titles
		// (in sorted order)
		iterator = collection.iterator();
		
		System.out.println("--------------------------------------");
		System.out.println("the dvds is sorted order are ");
		while(iterator.hasNext()) {
			CompactDisc tmp = (CompactDisc)iterator.next();
			System.out.println(tmp.getArtist() + " : " + tmp.getLenght());
		}
	}

}
