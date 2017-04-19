package com.boiko.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 6, nullable = false)
    private long id;
    @NotEmpty
    @Size(min = 3, max = 30)
    @Column(name = "title")
    private String title;
    @NotEmpty
    @Size(min = 3, max = 250)
    @Column(name = "body")
    private String body;
    @NotEmpty
    @Size(min = 2, max = 20)
    @Column(name = "name")
    private String name;
    @Column(name = "rating")
    private Integer rating;
    @Column(name = "date")
    private Date date;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "reviews")
    private Set<User> users = new HashSet<>();

    public Review() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review)) return false;

        Review review = (Review) o;

        if (id != review.id) return false;
        if (title != null ? !title.equals(review.title) : review.title != null) return false;
        if (body != null ? !body.equals(review.body) : review.body != null) return false;
        if (name != null ? !name.equals(review.name) : review.name != null) return false;
        if (rating != null ? !rating.equals(review.rating) : review.rating != null) return false;
        return date != null ? date.equals(review.date) : review.date == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
