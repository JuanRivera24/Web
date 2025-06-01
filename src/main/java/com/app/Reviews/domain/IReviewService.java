package com.app.reviews.domain;

import java.util.List;

public interface IReviewService {
    
    List<Review> findAll();

    Review findById(Long id);

    Review save(Review review);

    Review update(Review review, Long id);

    void deleteById(Long id);

    // Métodos extras opcionales que podrían ser útiles:
    List<Review> findByUserId(Long userId);

    List<Review> findByServiceId(Long serviceId);
}
