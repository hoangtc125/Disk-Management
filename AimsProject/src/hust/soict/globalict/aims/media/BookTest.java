package hust.soict.globalict.aims.media;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b1 = new Book("scah");
		Book b2 = new Book("sada");
		b1.setContent("a a a a  s s s s s s 1 1 1 1  s s s s s s ");
		b2.setContent("d s d d d d s s s c c c v e e e e ");
		System.out.println(b1.toString());
		System.out.println(b2.toString());
	}

}
