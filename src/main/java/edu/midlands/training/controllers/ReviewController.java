package edu.midlands.training.controllers;

import edu.midlands.training.entities.Review;
import edu.midlands.training.services.ReviewService;
import edu.midlands.training.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private VehicleService vehicleService;

    @GetMapping(value = "/reviews")
    public List<Review> getReviews(@RequestParam(required = false)String make,@RequestParam(required = false)String model) {
        return reviewService.getReviews(make,model);
    }

    @PostMapping("/reviews")
    public Review addReview(@RequestBody Review newReview){
        return reviewService.addReview(newReview);
    }


    @GetMapping("/reviews/{id}")
    public Review getReviewById(@PathVariable Long id){
            return reviewService.getReviewById(id);
        }

        @DeleteMapping("/reviews/{id}")
        public void deleteReviewById(@PathVariable Long id){
        reviewService.deleteReviewById(id);
        }


        @PutMapping("/reviews/{id}")
        public Review updateReviewById(@PathVariable Long id, @RequestBody Review newReview) {
            return reviewService.updateReviewById(id,newReview);
        }






}
