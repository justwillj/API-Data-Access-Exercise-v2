package edu.midlands.training.services;

import edu.midlands.training.entities.Review;
import edu.midlands.training.repositories.ReviewRepository;
import java.util.ArrayList;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**This ReviewServiceImpl implements the ReviewService*/
@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

   /** Get the reviews given the make and model of the vehicle
    * @Param make of the vehicle
    * @Param model of the vehicle
    * @returns the reviews List that has the make and model*/
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

    /** Get the review Based on id
     * @Param id id of the Review
     * @returns the Review that has the matching id
     * If there is no review with matching  id it gives an exception*/
    @Override
    public Review getReviewById(Long id) {
        for (Review r: reviewRepository.findAll()) {
            if (r.getId() == id){
                return r;
            }
        }
        return null;
    }

    /** Deletes the review Based on id
     * @Param id id of the Review
     * If there is no review with matching id it gives an exception*/

    @Override
    public void deleteReviewById(Long id) {
        reviewRepository.deleteById(id);
    }

    /** Updates the review based on the matching id
     * @Param id of the review
     * @Param new Review to be updated
     * @returns the updated newReview*/

    @Override
    public Review updateReviewById(Long id, Review newReview) {
        return reviewRepository.save(newReview);
    }

    /** Adds the review
     * @Param new Review to be updated
     * @returns the newReview*/

    @Override
    public Review addReview(Review newReview) {
        return reviewRepository.save(newReview);
    }

    /** get the count of the reviews for specific make and model
     * @Param make of the vehicle
     * @Param model of the vehicle
     * @Returns the number of reviews for that make and model */
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
