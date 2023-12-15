package metiers;

import entities.Blog;
import entities.Commentaire;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CommentaireMetiers {


    public static List<Commentaire> comments;
    BlogMetiers blogMetiers = new BlogMetiers();
    public CommentaireMetiers() {
        comments= new ArrayList<Commentaire>();
        comments.add(new Commentaire(1, "C'est un article intéressant sur la technologie.", "2023-10-28",blogMetiers.getBlogById(1)));
        comments.add(new Commentaire(2, "J'aimerais visiter ces destinations de voyage un jour.", "2023-10-29", blogMetiers.getBlogById(2)));
        comments.add(new Commentaire(3, "Les conseils en design web sont très utiles.", "2023-10-30", blogMetiers.getBlogById(3)));
    }

    public boolean addComment(Commentaire commentaire){
        int id_blog=commentaire.getBlog().getId();
        Blog blog = blogMetiers.getBlogById(id_blog);
        if(blog!=null){
            commentaire.setBlog(blog);
            return comments.add(commentaire);}
        return false;
    }

    public boolean updateComment(Commentaire commentaire, int id) {
        for (int i = 0; i < comments.size(); i++) {
            Commentaire existingComment = comments.get(i);
            if (existingComment.getId() == id) {

                Blog blog = blogMetiers.getBlogById(commentaire.getBlog().getId());
                if (blog != null) {
                    commentaire.setBlog(blog);
                    comments.set(i, commentaire);
                    return true;
                }
            }
        }
        return false;
    }
    public boolean deleteComment(int id){
        Iterator<Commentaire> iterator=comments.iterator();
        while(iterator.hasNext()){
            Commentaire r=iterator.next();
            if(r.getId()==id){
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
