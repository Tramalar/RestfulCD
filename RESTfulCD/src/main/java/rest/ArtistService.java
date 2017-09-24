package rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ArtistService {

	public static List<Artist> artists=new ArrayList<Artist>();
	private static long currentId=0;
	
	public static Artist addArtist(String name) {
		for(Artist a : artists) {
			if (Objects.equals(a.getName(),name))return a;
		}		
		Artist newArtist= new Artist(name);
		newArtist.setId(currentId++);
		artists.add(newArtist);
		return newArtist;
	}
	
	public static Artist getArtist(long id) {
		for(int i=0;i<artists.size();i++) {
			if(artists.get(i).getId()==id) {
				return artists.get(i);
			}
		}
		throw new error.EntryNotFoundException("No entry found with the specified ID-number");
	}

}
