package rest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class AlbumService {
	static List<Album> albums=new ArrayList<Album>();;
	private static long currentId=0;
	static boolean loaded=false;
	
	public Album add(Album album) {
		album.setId(currentId++);

		Artist newArtist=ArtistService.addArtist(album.getArtist());
		album.setArtistId(newArtist.getId());
		newArtist.addAlbum(album);
		albums.add(album);
		return album;
	}
	public List<Album> getAlbums() {
		return albums;
	}
	

	public List<Album> delete(long id) {
		for(int i=0;i<albums.size();i++) {
			if(albums.get(i).getId()==id) {
				albums.remove(i);
				return albums;
			}
		}
		throw new error.EntryNotFoundException("No entry found with the specified ID-number");
	}
	public Album updateRating(long id, int rating) {
		for(int i=0;i<albums.size();i++) {
			if(albums.get(i).getId()==id) {
				albums.get(i).setRating(rating);
				return albums.get(i);
			}
		}
		throw new error.EntryNotFoundException("No entry found with the specified ID-number");
	}
	public Album getAlbum(long id) {
		// TODO Auto-generated method stub
		for(int i=0;i<albums.size();i++) {
			if(albums.get(i).getId()==id) {
				return albums.get(i);
			}
		}
		throw new error.EntryNotFoundException("No entry found with the specified ID-number");
	}
}
