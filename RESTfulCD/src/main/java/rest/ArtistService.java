package rest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArtistService {

	public static List<Artist> artists=new ArrayList<Artist>();
	private static long currentId=0;
	public static Artist addArtist(String name) {
		for(Artist a : artists) {
			if (a.getName()==name)return a;
		}		
		Artist newArtist= new Artist(name);
		newArtist.setId(currentId++);
		artists.add(newArtist);
		return newArtist;
	}

}
