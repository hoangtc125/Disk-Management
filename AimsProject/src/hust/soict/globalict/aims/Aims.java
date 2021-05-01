package hust.soict.globalict.aims;

import java.util.Scanner;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.order.Order;

public class Aims {

	public static void main(String[] args) {
	
		MemoryDaemon deamon = new MemoryDaemon();
		deamon.run();
		Scanner scanner = new Scanner(System.in);
		int i = 1;
		while(i != 0) {
			System.out.println("Order Management Application: ");
			System.out.println("--------------------------------");
			System.out.println("1. Create new order");
			System.out.println("2. Add item to the order");
			System.out.println("3. Delete item by id");
			System.out.println("4. Display the items list of order");
			System.out.println("5. Get lucky item");
			System.out.println("6. Sorted by cost");
			System.out.println("0. Exit");
			System.out.println("--------------------------------");
			System.out.print("Please choose a number: 0-1-2-3-4-5-6: <<< ");
			String key = null;
			try {
	            key = scanner.nextLine();
	            i = Integer.parseInt(key);
				switch (i) {
				case 1:
					Order anOrder = new Order();
					System.out.println(">>> an order has already created");
					System.out.println(">>> please continue typing");
					System.out.print("<<< ");
					while(i != 0) {
	    				try {
	    					key = scanner.nextLine();
	    					i = Integer.parseInt(key);
			                switch (i) {
	    					case 1:
	    						System.out.println(">>> you've already created an order before");
	    						System.out.println("please continue typing");
	    						System.out.print("<<< ");
	    						break;
	    					case 2:
	    						System.out.println("add digita video disc enter 1\nadd book enter 2\nadd compact disc enter 3");
	    						System.out.print("<<< ");
	    						int j = 0;
	    						String title, category, directory, artist;
	    						float cost;
	    						int lenght;
	    						do {
	    							j = scanner.nextInt();
	    							switch (j) {
	    							case 1:
	    								scanner.nextLine();
	    								System.out.print("enter title: ");
	    								title = scanner.nextLine();
	    								System.out.print("enter category: ");
	    								category = scanner.nextLine();
	    								System.out.print("enter directory: ");
	    								directory = scanner.nextLine();
	    								System.out.print("enter lenght: ");
	    								lenght = scanner.nextInt();
	    								System.out.print("enter cost: ");
	    								cost = scanner.nextFloat();
	    								scanner.nextLine();
	    								DigitalVideoDisc tmpMedia = new DigitalVideoDisc(title, category, directory, lenght, cost);
	    								anOrder.addMedia(tmpMedia);
	    								break;
	    							case 2:
	    								scanner.nextLine();
	    								System.out.print("enter title: ");
	    								title = scanner.nextLine();
	    								System.out.print("enter category: ");
	    								category = scanner.nextLine();
	    								System.out.print("enter cost: ");
	    								cost = scanner.nextFloat();
	    								scanner.nextLine();
	    								Book tmpBook = new Book(title, category, cost);
	    								anOrder.addMedia(tmpBook);
	    								break;
	    							case 3:
	    								int numOfTracks;
	    								scanner.nextLine();
	    								System.out.print("enter artist: ");
	    								artist = scanner.nextLine();
	    								System.out.print("enter title: ");
	    								title = scanner.nextLine();
	    								System.out.print("enter category: ");
	    								category = scanner.nextLine();
	    								System.out.print("enter directory: ");
	    								directory = scanner.nextLine();
	    								System.out.print("enter cost: ");
	    								cost = scanner.nextFloat();
	    								System.out.print("add the number of tracks: ");
	    								numOfTracks = scanner.nextInt();
	    								scanner.nextLine();
	    								CompactDisc tmpCompactDisc = new CompactDisc(title, category, directory, cost, artist, null);
	    								anOrder.addMedia(tmpCompactDisc);
	    								break;
	    							default:
	    								System.out.println(">>> khong hop le");
	    								System.out.println("add disc enter 1\nadd book enter 2");
	    								break;
	    							}
	    						}while(j != 1 && j != 2 && j != 3);
	    						System.out.println("please continue typing");
	    						System.out.print("<<< ");
	    						break;
	    					case 3:
	    						System.out.println("enter id: ");
	    						anOrder.removeMedia(scanner.nextInt());
	    						System.out.println("please continue typing");
	    						System.out.print("<<< ");
								scanner.nextLine();
	    						break;
	    					case 4:
	    						anOrder.showOrderedList();
	    						System.out.println("please continue typing");
	    						System.out.print("<<< ");
	    						break;
	    					case 5:
//	    						anOrder.showOrderedList(anOrder.getALuckyItem());
	    						System.out.println("please continue typing");
	    						System.out.print("<<< ");
	    						break;
	    					case 6:
	    						java.util.Collections.sort((java.util.List)anOrder.getItemsOrdered());
	    						anOrder.showOrderedList();
	    						System.out.println("please continue typing");
	    						System.out.print("<<< ");
	    						break;
	    					case 0:
	    						System.out.println("good bye");
	    						i = 0;
	    						break;
	    					default:
	    						i = 0;
	    						break;
			                }
						} catch (Exception ex) {
			                System.out.print(key + ": khong phai so nguyen!");
			                System.out.print(" Nhap lại: ");
							System.out.print("<<< ");
							
						}
					}
				default:
					i = 0;
					System.out.println("end");
					break;
				}
	        } catch (Exception ex) {
	            System.out.print(key + ": khong phai so nguyen!");
	            System.out.print(" Nhap lại: ");
				System.out.print("<<< ");
	        }
		}
	deamon.run();
	}
}
