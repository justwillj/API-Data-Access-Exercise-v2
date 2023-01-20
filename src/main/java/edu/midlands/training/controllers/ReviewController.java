package edu.midlands.training.controllers;

import edu.midlands.training.entities.Review;
import edu.midlands.training.services.ReviewService;
import edu.midlands.training.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private VehicleService vehicleService;

    /**A Get Method that returns all the reviews for a given make and model of the vehicle*/
    @GetMapping(value = "/reviews")
    public List<Review> getReviews(@RequestParam(required = false)String make,@RequestParam(required = false)String model) {
        return reviewService.getReviews(make,model);
    }

    /**A Get method that returns the amount of reviews for a specific make and model*/
    @GetMapping("/reviews/count")
        public Long getReviewCount(@RequestParam String make, @RequestParam String model) {
        return reviewService.getReviewCount(make,model);
    }

    /**CRUD functions to add a new review */
    @PostMapping("/reviews")
    public Review addReview(@RequestBody Review newReview){
        return reviewService.addReview(newReview);
    }


/**CRUD function for reviews to get the review based on the given Id*/
    @GetMapping("/reviews/{id}")
    public Review getReviewById(@PathVariable Long id){
            return reviewService.getReviewById(id);
        }


        /** CRUD function for reviews to delete the review based on the given Id*/
        @DeleteMapping("/reviews/{id}")
        public void deleteReviewById(@PathVariable Long id){
        reviewService.deleteReviewById(id);
        }


    /** CRUD function for reviews to update  the review based on the given Id*/
        @PutMapping("/reviews/{id}")
        public Review updateReviewById(@PathVariable Long id, @RequestBody Review newReview) {
            return reviewService.updateReviewById(id,newReview);
        }






}
