package edu.midlands.training.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;
import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Vehicle {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "type is a mandatory field")
  private String type;

  @NotBlank(message = "make is a mandatory field")
  private String make;
  @NotBlank(message = "model is a mandatory field")
  private String model;
  @NotNull(message = "year is a mandatory field")
  private Integer year;

  @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
  @JsonIgnore
  private Set<Review> reviews;


  public Vehicle() {
  }

  public Vehicle(Long id, String type, String make, String model, Integer year) {
    this.id = id;
    this.type = type;
    this.make = make;
    this.model = model;
    this.year = year;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  @Override
  public String toString() {
    return "Vehicle{" +
        "id=" + id +
        ", type='" + type + '\'' +
        ", make='" + make + '\'' +
        ", model='" + model + '\'' +
        ", year=" + year +
        ", reviews=" + reviews +
        '}';
  }
}
