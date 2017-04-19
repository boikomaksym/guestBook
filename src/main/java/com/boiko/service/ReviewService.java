package com.boiko.service;

import com.boiko.model.Review;
import org.springframework.data.domain.Page;

public interface ReviewService {

    Review saveReview(Review review);

    Page<Review> findAll(int page, int size, String order);

    Review findById(Long id);

    void upRating(long reviewId);

    void downRating(long reviewId);
}
