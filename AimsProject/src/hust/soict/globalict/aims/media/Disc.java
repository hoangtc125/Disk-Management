package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.PlayerException;

public class Disc extends Media implements Playable { 
	protected int length;
	protected String directory;

	
	public Disc() {
		super();
	}
	
	public Disc(String title, String category, String directory, int lenght, float cost) {
		super();
		this.length = length;
		this.directory = directory;
	}

	public String getDirectory() {
		return directory; 
	}
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	@Override
	public void play() throws PlayerException {
	}
	
	public String showInfo() {
		return "";
	}
}
