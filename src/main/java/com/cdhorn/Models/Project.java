package com.cdhorn.Models;


public class Project {

    private long id;
    private String image;
    private String title;
    private String technologies;
    private String description;
    private String completed;
    private String url;

    public Project(long id, String title, String image, String technologies, String description, String completed, String url) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.technologies = technologies;
        this.description = description;
        this.completed = completed;
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTechnologies() {
        return technologies;
    }

    public void setTechnologies(String technologies) {
        this.technologies = technologies;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
