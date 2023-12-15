package ressources;

import entities.Commentaire;
import metiers.BlogMetiers;
import metiers.CommentaireMetiers;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/comments")
public class CommentsWS {
    public static CommentaireMetiers cmMetier = new CommentaireMetiers();
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addComment(Commentaire c) {
        if (cmMetier.addComment(c))
            return Response.status(Response.Status.CREATED).build();
        return Response.status(Response.Status.NOT_FOUND).build();}
    @DELETE
    @Path("/{id}")
    public Response deleteComment(@PathParam("id") int id) {
        if (cmMetier.deleteComment(id))
            return Response.status(Response.Status.OK).build();
        return Response.status(Response.Status.NOT_FOUND).build();

    }
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateComment(Commentaire updatedComment,@PathParam("id") int id) {


        if (cmMetier.updateComment(updatedComment,id)) {
            return Response.status(Response.Status.OK).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
