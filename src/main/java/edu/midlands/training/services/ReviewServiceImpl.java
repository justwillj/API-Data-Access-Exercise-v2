package edu.midlands.training.services;

import edu.midlands.training.entities.Review;
import edu.midlands.training.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }
}
