package edu.midlands.training.services;

import edu.midlands.training.entities.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    List<Review> getReviews(String make, String model);

    Review getReviewById(Long id);

    void deleteReviewById(Long id);

    Review updateReviewById(Long id, Review newReview);

    Review addReview(Review newReview);
}
