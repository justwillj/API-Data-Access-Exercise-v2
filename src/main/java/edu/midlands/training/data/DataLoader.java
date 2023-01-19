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
                (new Vehicle(1L, "string", "string2", "string3", 200));
        vehicle2 = vehicleRepository.save
                (new Vehicle(2L, "string", "string2", "string3", 250));
        vehicle3 = vehicleRepository.save
                (new Vehicle(3L, "string", "string2", "string3", 280));



    }

    private void loadReviews(){
        review1 = reviewRepository.save
                (new Review(1L, "brrr", "alsobrrr", "numbers", LocalDate.of(2020,01,02) , "badusername", vehicle1));
        review2 = reviewRepository.save
                (new Review(2L, "brrr", "alsobrrr", "numbers", LocalDate.of(2021,02,03), "badusername", vehicle1));
        review3 = reviewRepository.save
                (new Review(3L, "brrr", "alsobrrr", "numbers", LocalDate.of(2022,11,12), "badusername", vehicle2));
        review4 = reviewRepository.save
                (new Review(4L, "brrr", "alsobrrr", "numbers", LocalDate.of(2021,11,25) , "badusername", vehicle3));

    }



}
