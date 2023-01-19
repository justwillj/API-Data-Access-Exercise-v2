package edu.midlands.training.services;

import edu.midlands.training.entities.Review;
import edu.midlands.training.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getReviewById(Long id) {
        for (Review r: reviewRepository.findAll()) {
            if (r.getId() == id){
                return r;
            }
        }
        return null;
    }



    @Override
    public void deleteReviewById(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public Review updateReviewById(Long id, Review newReview) {
        return reviewRepository.save(newReview);
    }

    @Override
    public Review addReview(Review newReview) {
        return reviewRepository.save(newReview);
    }
}
