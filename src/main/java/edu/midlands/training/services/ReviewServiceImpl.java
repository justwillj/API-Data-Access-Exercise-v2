package edu.midlands.training.services;

import edu.midlands.training.entities.Review;
import edu.midlands.training.repositories.ReviewRepository;
import java.util.ArrayList;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> getReviews(String make,String model) {
        List<Review> queryReviews = new ArrayList<>();
        if (make == null && model == null){
            return reviewRepository.findAll();
        }
        for (Review r : reviewRepository.findAll()){
            if (Objects.equals(r.getVehicle().getMake(), make) && Objects.equals(
                r.getVehicle().getModel(), model)){
                queryReviews.add(r);
            }
        }
        return queryReviews;
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

    @Override
    public Long getReviewCount(String make, String model) {
        List<Review>queryReviewCount = new ArrayList<>();

        if (make == null && model == null){
            return reviewRepository.count();
        }
        for (Review r : reviewRepository.findAll()){
            if (Objects.equals(r.getVehicle().getMake(), make) && Objects.equals(
                    r.getVehicle().getModel(), model)){
                queryReviewCount.add(r);
            }
        }
        return (long) queryReviewCount.size();
    }


}
