package hust.soict.globalict.aims.media;
import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private class Tracks {
		private String title;
		private int length;
		public String getTitle() {
			return title;
		}
		public int getLength() {
			return length;
		}
		public Tracks() {
			super();
		}
		public Tracks(String title, int length) {
			super();
			this.title = title;
			this.length = length;
		}
		
	}
	private List<Tracks> tracks = new ArrayList<Tracks>();
	
	
	public String getArtist() {
		return artist;
	}
	public CompactDisc() {
		super();
	}
	public CompactDisc(String title, String category, String directory, float cost, String artist, List<Tracks> tracks) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.directory = directory;
		this.artist = artist;
		this.tracks = tracks;
	}
	
	public void addTrack(Tracks track) {
		for(int index = 0; index < tracks.size(); index++) {
			if(track.getLength() == tracks.get(index).getLength() && track.getTitle().compareTo(tracks.get(index).getTitle()) == 1) { 
				System.out.println("this track had been already existed");
				return;
			}
		}
		tracks.add(track);
		System.out.println("add successfully");
	}
	
	public void removeTrack(Tracks track) {
		for(int index = 0; index < tracks.size(); index++) {
			if(track.getLength() == tracks.get(index).getLength() && track.getTitle().compareTo(tracks.get(index).getTitle()) == 1) { 
				tracks.remove(index);
				System.out.println("remove successfully");
				return;
			}
		}
		System.out.println("the author is not already in the List before adding");
	}
	
	public int getLenght() {
		int lenght = 0;
		for (Tracks track : tracks) {
			lenght += track.getLength();
		}
		return lenght;
	}
	public void showInfo() {
		System.out.print(". CD - [" + getTitle() + "] " + "- [ " + getArtist() + "] - [" +  getCategory() 
				+ "]" + " - [" + getDirectory() + "] - [" + getLength() 
				+ "]" + ": [" + getCost() + "] $");
	}
	@Override
	public void play() {
		// TODO Auto-generated method stub
		for (Tracks track : tracks) {
			System.out.println("Playing track: " + track.getTitle());
			System.out.println("DVD length: " + track.getLength());
		}
	}
}
