package entities;

import java.util.Objects;


public class Blog {
    private int id;
    private String title ;
    private String description ;
    private String category ;
    private String date ;

    public Blog(int id, String title, String description, String category, String date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.date = date;
    }

    public Blog() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Blog)) return false;
        Blog blog = (Blog) o;
        return getId() == blog.getId() && Objects.equals(getTitle(), blog.getTitle()) && Objects.equals(getDescription(), blog.getDescription()) && Objects.equals(getCategory(), blog.getCategory()) && Objects.equals(getDate(), blog.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getDescription(), getCategory(), getDate());
    }

}
