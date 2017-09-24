package rest;

import java.util.ArrayList;
import java.util.List;

public class Artist {
	private String name;
	private List<Album> albums=new ArrayList<Album>();
	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	private long id;
	public Artist(String name) {
		this.name=name;
	}

	public void addAlbum(Album album){
		albums.add(album);
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
