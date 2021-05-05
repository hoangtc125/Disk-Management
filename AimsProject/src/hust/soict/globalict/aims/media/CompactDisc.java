package hust.soict.globalict.aims.media;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import hust.soict.globalict.aims.PlayerException;


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
	private Collection<Tracks> tracks = new ArrayList<Tracks>();
	
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
	
	public Collection<Tracks> getTracks() {
		return tracks;
	}
	public boolean equals(Tracks track) {
		if(track.getLength() == this.getLength() && track.getTitle().compareTo(this.getTitle()) == 1) return true;
		return false;
	}
	
	public CompactDisc(String artist) {
		super();
		this.artist = artist;
	}
	public void addTrack(String title, int lenght) {
		Tracks track = new Tracks(title, lenght);
		for(int index = 0; index < tracks.size(); index++) {
			if(((ArrayList<Tracks>) tracks).get(index).equals(track)) { 
				System.out.println("the track is already in the List before adding");
				return;
			}
		}
		tracks.add(track);
		System.out.println("add successfully");
	}
	
	public void removeTrack(String title, int lenght) {
		Tracks track = new Tracks(title, lenght);
		for(int index = 0; index < tracks.size(); index++) {
			if(((ArrayList<Tracks>) tracks).get(index).equals(track)) { 
				tracks.remove(index);
				System.out.println("remove successfully");
				return;
			}
		}
		System.out.println("the track is not already in the List before adding");
	}
	
	public int getLenght() {
		int lenght = 0;
		for (Tracks track : tracks) {
			lenght += track.getLength();
		}
		return lenght;
	}
	public String showInfo() {
		return ". CD-[" + getTitle() + "]" + "-["+ getArtist() + "]-[" +  getCategory() 
				+ "]" + "-[" + getDirectory() + "]-[" + getLength() 
				+ "]" + ":[" + getCost() + "]$";
	}
	public int compareTo(CompactDisc media) {
		return this.getCost() < media.getCost() ? -1 : 1;
	}
	@Override
	public void play() throws PlayerException {
		if (this.getLength() > 0) {
		// TODO Play CD as you have implemented
		} else {
			throw new PlayerException("ERROR: CD length is non-positive!");
		}
	}
}
