package edu.midlands.training.controllers;

import edu.midlands.training.entities.Review;
import edu.midlands.training.entities.Vehicle;
import edu.midlands.training.services.ReviewService;
import edu.midlands.training.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping(value = "/reviews")
    public List<Review> getReviews() {
        return reviewService.getReviews();
    }


    @GetMapping("/reviews/{id}")
    public Optional<Review> getReviewById(@PathVariable Long id){
            return reviewService.getReviewById(id);
        }






}
