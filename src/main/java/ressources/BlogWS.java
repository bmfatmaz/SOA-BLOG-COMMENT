package ressources;

import entities.Blog;
import metiers.BlogMetiers;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
@Path("/blogs")
public class BlogWS {

    public static BlogMetiers blogMetier = new BlogMetiers();

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response addBlog(Blog b) {
        if(blogMetier.addBlog(b))
            return  Response.status(Response.Status.CREATED).build();
        return  Response.status(Response.Status.NOT_FOUND).build();
    }




    @GET

    @Produces(MediaType.APPLICATION_JSON)
    public Response getBlogs() {
        List<Blog> liste=blogMetier.getBlogs();
        if(liste.size()==0)
            return  Response.status(Response.Status.NOT_FOUND).build();
        return  Response.status(Response.Status.OK).entity(liste).build();


    }
    @GET
    @Path("/getByCategory")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBlogs(@QueryParam("category") String category) {
        List<Blog> liste = blogMetier.getBlogs();
        List<Blog> filteredBlogsParCategory = new ArrayList<>();

        for (Blog blog : liste) {
            if (blog.getCategory().equalsIgnoreCase(category)) {
                filteredBlogsParCategory.add(blog);
            }
        }
        if (!filteredBlogsParCategory.isEmpty()) {
            return Response.status(Response.Status.OK).entity(filteredBlogsParCategory).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }



}
