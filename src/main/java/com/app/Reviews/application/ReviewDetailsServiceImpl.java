package com.app.reviews.application;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.reviews.domain.IReviewRepository;
import com.app.reviews.domain.Review;

@Service
public class ReviewDetailsServiceImpl implements UserDetailsService {

    private final IReviewRepository reviewRepository;

    public ReviewDetailsServiceImpl(IReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Review review = reviewRepository.findById(Long.parseLong(id))
                .orElseThrow(() -> new UsernameNotFoundException("Review not found with ID: " + id));

        // Para Review no es común usar UserDetails, pero para mantener la estructura:
        return new org.springframework.security.core.userdetails.User(
                "review_" + review.getId(),
                "",
                new ArrayList<>());
    }
}
