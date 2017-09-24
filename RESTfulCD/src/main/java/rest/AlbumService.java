package rest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class AlbumService {
	static List<Album> albums=new ArrayList<Album>();;
	private static long currentId=0;
	static boolean loaded=false;
	public AlbumService() {
		if(!loaded) {
			add(new Album("Queens of the Stone Age", "Villains","2017","3"));
			add(new Album("Queens of the Stone Age", "Songs for the Deaf","2002","5"));
			add(new Album("Vektor", "Terminal Redux","2016","4"));
			add(new Album("Vektor", "Outer Isolation","2013","4"));
			add(new Album("The Mars Volta", "De-loused in the Comatorium","2003","5"));
			loaded=true;
		}
	}
	public Album add(Album album) {
		album.setId(currentId++);
		albums.add(album);
		return album;
	}
	public List<Album> getAlbums() {
		return albums;
	}
	
	public List<Album> getAlbumsByArtist(long artistId) {
		List<Album> filtered=new ArrayList<Album>();
		for(Album a : albums) {
			if(a.getArtistId()==artistId)filtered.add(a);
		}
		return filtered;
	}
	public List<Album> delete(long id) {
		for(int i=0;i<albums.size();i++) {
			if(albums.get(i).getId()==id) {
				albums.remove(i);
				return albums;
			}
		}
		throw new error.DataNotFoundException("No entry found with the specified ID-number");
	}
	public Album updateRating(long id, int rating) {
		for(int i=0;i<albums.size();i++) {
			if(albums.get(i).getId()==id) {
				albums.get(i).setRating(rating);
				return albums.get(i);
			}
		}
		throw new error.DataNotFoundException("No entry found with the specified ID-number");
	}
	public Album getAlbum(long id) {
		// TODO Auto-generated method stub
		for(int i=0;i<albums.size();i++) {
			if(albums.get(i).getId()==id) {
				return albums.get(i);
			}
		}
		throw new error.DataNotFoundException("No entry found with the specified ID-number");
	}
}
