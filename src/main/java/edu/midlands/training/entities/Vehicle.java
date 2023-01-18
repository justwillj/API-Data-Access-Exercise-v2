package edu.midlands.training.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;
import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Vehicle {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String type;

  private String make;

  private String model;

  private String Year;

  @OneToMany(mappedBy = "vehicle", fetch = FetchType.EAGER)
  @JsonIgnore
  private Set<Review> reviews;

}
