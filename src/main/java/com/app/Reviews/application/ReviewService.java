package com.app.reviews.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.shared.adapters.exception.ResourceNotFoundException;
import com.app.reviews.domain.IReviewRepository;
import com.app.reviews.domain.IReviewService;
import com.app.reviews.domain.Review;

@Service
public class ReviewService implements IReviewService {

    private final IReviewRepository reviewRepository;

    public ReviewService(IReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review findById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with ID: " + id));
    }

    @Override
    @Transactional
    public Review save(Review review) {
        // Aquí podrías agregar validaciones específicas si es necesario
        return reviewRepository.save(review);
    }

    @Override
    @Transactional
    public Review update(Review review, Long id) {
        Review existingReview = findById(id);
        existingReview.setUserId(review.getUserId());
        existingReview.setServiceId(review.getServiceId());
        existingReview.setRating(review.getRating());
        existingReview.setComment(review.getComment());
        existingReview.setCreatedAt(review.getCreatedAt());
        return reviewRepository.save(existingReview);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Review review = findById(id);
        reviewRepository.delete(review);
    }
}
