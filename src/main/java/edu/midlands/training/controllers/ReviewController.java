package edu.midlands.training.controllers;

import edu.midlands.training.entities.Review;
import edu.midlands.training.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

        @DeleteMapping("/reviews/{id}")
        public void deleteReviewById(@PathVariable Long id){
        reviewService.deleteReviewById(id);
        }


        @PutMapping("/reviews/{id}")
        public Review updateReviewById(@PathVariable Long id, @RequestBody Review newReview) {
            return reviewService.updateReviewById(id,newReview);
        }






}
