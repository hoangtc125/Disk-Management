package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.PlayerException;

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
	public DigitalVideoDisc(String title, float cost) {
		super();
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
	public int compareTo(DigitalVideoDisc media) {
		return this.getCost() < media.getCost() ? -1 : 1;
	}
	@Override
	public void play() throws PlayerException {
		if (this.getLength() > 0) {
		// TODO Play DVD as you have implemented
		} else {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
	}
}
