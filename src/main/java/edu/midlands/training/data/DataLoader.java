package edu.midlands.training.data;

import edu.midlands.training.entities.Review;
import edu.midlands.training.entities.Vehicle;
import edu.midlands.training.repositories.ReviewRepository;
import edu.midlands.training.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
public class DataLoader implements CommandLineRunner {



    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private VehicleRepository vehicleRepository;


    private Vehicle vehicle1;
    private Vehicle vehicle2;
    private Vehicle vehicle3;
    private Vehicle vehicle4;
    private Vehicle vehicle5;

    private Vehicle vehicle6;

    private Review review1;
    private Review review2;
    private Review review3;
    private Review review4;

    @Override
    public void run(String... strings) throws Exception {

        loadVehicles();
        loadReviews();



    }


    private void loadVehicles(){
        vehicle1 = vehicleRepository.save
                (new Vehicle(1L, "Car", "Toyota", "Camry", 200));
        vehicle2 = vehicleRepository.save
                (new Vehicle(2L, "Truck", "Ford", "F-150", 250));
        vehicle3 = vehicleRepository.save
                (new Vehicle(3L, "Truck", "Ram", "1500", 280));
        vehicle4 = vehicleRepository.save
                (new Vehicle(4L, "Car", "Ford", "Focus", 380));
        vehicle5 = vehicleRepository.save
                (new Vehicle(5L, "SUV", "VW", "Atlus", 2850));
        vehicle6 = vehicleRepository.save
                (new Vehicle(6L, "Car", "Honda", "Civic", 28430));



    }

    private void loadReviews(){
        review1 = reviewRepository.save
                (new Review(1L, "ReviewOne", "Car is really cool", "numbers", LocalDate.of(2020,01,02) , "badusername", vehicle1));
        review2 = reviewRepository.save
                (new Review(2L, "ReviewTwo", "Testing this", "numbers", LocalDate.of(2021,02,03), "badusername", vehicle1));
        review3 = reviewRepository.save
                (new Review(3L, "ReviewThree", "Hope this works", "numbers", LocalDate.of(2022,11,12), "badusername", vehicle2));
        review4 = reviewRepository.save
                (new Review(4L, "ReviewFour", "alsobrrr", "numbers", LocalDate.of(2021,11,25) , "badusername", vehicle3));

    }



}
