package com.app.reviews.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.app.reviews.domain.IReviewRepository;
import com.app.reviews.domain.Review;

@Component
public class ReviewDatasource {

    private final IReviewRepository reviewRepository;

    public ReviewDatasource(IReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    public Optional<Review> findById(Long id) {
        return reviewRepository.findById(id);
    }

    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    public Optional<Review> update(Review review, Long id) {
        return reviewRepository.findById(id).map(existingReview -> {
            existingReview.setRating(review.getRating());
            existingReview.setComment(review.getComment());
            existingReview.setUser(review.getUser());
            existingReview.setService(review.getService());
            return reviewRepository.save(existingReview);
        });
    }

    public boolean deleteById(Long id) {
        if (reviewRepository.existsById(id)) {
            reviewRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
