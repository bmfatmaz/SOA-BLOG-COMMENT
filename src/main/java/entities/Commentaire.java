package entities;


public class Commentaire {
    private int id;
    private String content ;
    private String date;
    private Blog blog;

    public Commentaire(int id, String content, String date, Blog blog) {
        this.id = id;
        this.content = content;
        this.date = date;
        this.blog = blog;
    }

    public Commentaire() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
