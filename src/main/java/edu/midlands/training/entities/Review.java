package edu.midlands.training.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "title is a mandatory field")
    private String title;
    @NotBlank(message = "description is a mandatory field")
    private String description;
    @NotBlank(message = "rating is a mandatory field")
    private String rating;
    @NotNull(message = "date is a mandatory field")
    private LocalDate date;
    @NotBlank(message = "username is a mandatory field")
    private String username;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Vehicle vehicle;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Review() {
    }

    public Review(Long id, String title, String description, String rating, LocalDate date, String username, Vehicle vehicle) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.date = date;
        this.username = username;
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", rating='" + rating + '\'' +
                ", date='" + date + '\'' +
                ", username='" + username + '\'' +
                ", vehicle=" + vehicle +
                '}';
    }
}
