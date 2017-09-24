package rest;

import java.util.ArrayList;
import java.util.List;

public class Album 
{
	private String artist;
	private String title;
	private int releaseYear=0;
	private int rating=0;
	private long id;
	private long artistId;
	public long getArtistId() {
		return artistId;
	}
	private List<Link> links=new ArrayList<Link>();

	public List<Link> getLinks() {
		return links;
	}
	public void setLinks(List<Link> links) {
		this.links = links;
	}
	public Album () {}
	public Album(String artist, String album, String releaseYear, String rating) throws error.RatingFormatException {
		this.artist=artist;
		Artist newArtist=ArtistService.addArtist(artist);
		this.artistId=newArtist.getId();
		this.title=album;
		int ratingInt=0;
		try {
			this.releaseYear=Integer.parseInt(releaseYear);
		}catch(NumberFormatException e) {
			this.releaseYear=0;
		}
		try {
			ratingInt=Integer.parseInt(rating);
		}catch (NumberFormatException e) {
			throw new error.RatingFormatException("Rating must be an integer between 0 and 5");

		}
		if(ratingInt<0||ratingInt>5) {
			throw new error.RatingFormatException("Rating must be an integer between 0 and 5");
		}
		this.rating=ratingInt;
		newArtist.addAlbum(this);
	}

	public void addLink(String url, String rel){
		Link link = new Link(url,rel);
		links.add(link);
	}

	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) throws error.RatingFormatException {
		if(rating<0||rating>5) throw new error.RatingFormatException("Rating must be an integer between 0 and 5");
		this.rating = rating;
	}
	public void setId(long id) {
		this.id=id;		
	}
	public long getId() {
		return id;
	}

}
