package metiers;

import entities.Blog;

import java.util.ArrayList;
import java.util.List;



public class BlogMetiers {
    public static List<Blog>  blogs ;

    public BlogMetiers() {
        blogs = new ArrayList<Blog>();
        blogs.add(new Blog(1, "Mon premier article", "Ceci est la description de mon premier article", "Technologie", "2023-10-23"));
        blogs.add(new Blog(2, "Les meilleures destinations de voyage", "Découvrez les endroits incroyables à visiter cette année", "Voyage", "2023-10-24"));
        blogs.add(new Blog(3, "Les meilleures pratiques en design web", "Conseils pour créer des sites web modernes et conviviaux", "Design Web", "2023-10-27"));
    }

    public boolean addBlog(Blog blog){
      //  System.out.println("test 2 2");
        return blogs.add(blog);
    }
    public Blog getBlogById(int id){

        for (Blog b:blogs) {
            if(b.getId()==id)
                return b;
        }
        return null;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public List<Blog> getBlogbyCategory(String category){
        List<Blog> liste=new ArrayList<Blog>();
        for (Blog b:blogs){
            if(b.getCategory().equals(category))
                liste.add(b);
        }
        return liste;
    }
}
