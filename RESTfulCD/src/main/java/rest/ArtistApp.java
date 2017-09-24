package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/artists")
public class ArtistApp {
	ArtistService as=new ArtistService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<Artist> getArtists() {
		return ArtistService.artists;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{artistId}")
	public Artist getAlbum(@PathParam("artistId") long id){
		return ArtistService.getArtist(id);
	}
}
