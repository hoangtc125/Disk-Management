package hust.soict.globalict.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {

	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
	}
	public DigitalVideoDisc(String title, String category) {
		super();
		this.title = title;
		this.category = category;
	}
	public DigitalVideoDisc(String title, String category, String directory) {
		super();
		this.title = title;
		this.category = category;
		this.directory = directory;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, String directory, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.directory = directory;
		this.length = length;
		this.cost = cost;
	}
	public String showInfo() {
		 return ".DVD-[" + getTitle() + "]-[" + getCategory() 
				+ "]" + "-[" + getDirectory() + "]-[" + getLength() 
				+ "]" + ":[" + getCost() + "]$";
	}
	
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	public int compareTo(Media dvd) {
		return this.getCost() > dvd.getCost() ? 1 : -1;
//		return this.getTitle().compareTo(dvd.getTitle());
	}
}
