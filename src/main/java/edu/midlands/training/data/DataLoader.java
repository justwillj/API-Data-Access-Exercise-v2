package edu.midlands.training.data;

import edu.midlands.training.entities.Review;
import edu.midlands.training.entities.Vehicle;
import edu.midlands.training.repositories.ReviewRepository;
import edu.midlands.training.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;


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
    private Review review5;
    private Review review6;
    private Review review7;
    private Review review8;
    private Review review9;
    private Review review10;

    @Override
    public void run(String... strings) throws Exception {

        loadVehicles();
        loadReviews();



    }

/** Vehicle Data*/
    private void loadVehicles(){
        vehicle1 = vehicleRepository.save
                (new Vehicle(1L, "Car", "Toyota", "Camry", 2001));
        vehicle2 = vehicleRepository.save
                (new Vehicle(2L, "Truck", "Ford", "F-150", 2005));
        vehicle3 = vehicleRepository.save
                (new Vehicle(3L, "Truck", "Ram", "1500", 2008));
        vehicle4 = vehicleRepository.save
                (new Vehicle(4L, "Car", "Ford", "Focus", 2011));
        vehicle5 = vehicleRepository.save
                (new Vehicle(5L, "SUV", "VW", "Atlus", 2014));
        vehicle6 = vehicleRepository.save
                (new Vehicle(6L, "Car", "Honda", "Civic", 2014));



    }


    /** Reviews Data */
    private void loadReviews(){
        review1 = reviewRepository.save
                (new Review(1L, "ReviewOne", "Car is really cool", "1/10", LocalDate.of(2020,01,02) , "badusername", vehicle1));
        review2 = reviewRepository.save
                (new Review(2L, "ReviewTwo", "Truck is bad", "2/10", LocalDate.of(2021,02,03), "i have terrible naming sense", vehicle1));
        review3 = reviewRepository.save
                (new Review(3L, "ReviewThree", "This is terrible", "3/10", LocalDate.of(2022,11,12), "yes", vehicle1));
        review4 = reviewRepository.save
                (new Review(4L, "ReviewFour", "Its alright I guess", "4/10", LocalDate.of(2021,12,25) , "goodusername", vehicle3));
        review5 = reviewRepository.save
                (new Review(5L, "ReviewFive", "Decent", "5/10", LocalDate.of(2041,11,25) , "i want a cookie", vehicle3));
        review6 = reviewRepository.save
                (new Review(6L, "ReviewSix", "This car is fairly mediocre", "6/10", LocalDate.of(2021,01,25) , "i hate cookies", vehicle2));
        review7 = reviewRepository.save
                (new Review(7L, "ReviewSeven", "Solid vehicle", "7/10", LocalDate.of(2023,11,19) , "vegetablestastelikesad", vehicle2));
        review8 = reviewRepository.save
                (new Review(8L, "ReviewEight", "Pretty good", "8/10", LocalDate.of(2024,10,14) , "name", vehicle4));
        review9 = reviewRepository.save
                (new Review(9L, "ReviewNine", "Incredible car", "9/10", LocalDate.of(2011,07,25) , "password", vehicle5));
        review10 = reviewRepository.save
                (new Review(10L, "ReviewTen", "Whoever made this should be fired", "10/100", LocalDate.of(3021,03,13) , "iamsad", vehicle6));

    }



}
