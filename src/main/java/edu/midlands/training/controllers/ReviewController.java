package edu.midlands.training.controllers;

import edu.midlands.training.entities.Review;
import edu.midlands.training.entities.Vehicle;
import edu.midlands.training.services.ReviewService;
import edu.midlands.training.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping(value = "/reviews")
    public List<Review> getReviews(){
        return reviewService.getReviews();



    }
}
