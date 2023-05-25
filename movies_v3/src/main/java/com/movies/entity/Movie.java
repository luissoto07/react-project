package com.movies.entity;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private double length;
    private String creator;

    public Movie() {
    }

    public Movie(Integer id, String title, double length, String creator) {
        this.id = id;
        this.title = title;
        this.length = length;
        this.creator = creator;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", length=" + length +
                ", creator='" + creator + '\'' +
                '}';
    }
}
