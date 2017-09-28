package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;


@Path("/albums")
public class AlbumApp {

	AlbumService as=new AlbumService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Album> getMsg() {
		return as.getAlbums();

	}
	@POST
	@Consumes({"application/json"})
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAlbum(Album album, @Context UriInfo uriInfo){
		Album newAlbum=as.add(album);
		String uriSelf = uriInfo.getBaseUriBuilder().path(AlbumApp.class).path(Long.toString(newAlbum.getId())).build().toString();
		String uriAll = uriInfo.getBaseUriBuilder().path(AlbumApp.class).build().toString();
		String uriArtist=uriInfo.getBaseUriBuilder().path(ArtistApp.class).path(Long.toString(newAlbum.getArtistId())).build().toString();
		album.addLink(uriSelf,"self");
		album.addLink(uriAll,"All_Albums");
		album.addLink(uriArtist,"Artist-page");

		return Response.status(Status.CREATED).entity(newAlbum).build(); 
	}

	
	@DELETE
	@Consumes({"application/json"})
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{albumId}")
	public List<Album> deleteAlbum(@PathParam("albumId") long id){
		as.delete(id);
		return as.getAlbums();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{albumId}")
	public Album getAlbum(@PathParam("albumId") long id){
		return as.getAlbum(id);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/updateRating/{albumId}")
	public Album updateRating(@PathParam("albumId") long id, @QueryParam("newRating") int rating){
		return as.updateRating(id,rating);
	}

}