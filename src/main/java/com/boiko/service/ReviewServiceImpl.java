package com.boiko.service;

import com.boiko.model.Review;
import com.boiko.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    @Transactional
    public Review saveReview(Review review) {
        return reviewRepository.saveAndFlush(review);
    }

    @Override
    @Transactional
    public Page<Review> findAll(int page, int size, String order) {
        return reviewRepository.findAll(new PageRequest(page - 1, size - 0, Sort.Direction.ASC, order));
    }

    @Override
    @Transactional
    public Review findById(Long id) {
        return reviewRepository.findOne(id);
    }

    @Override
    @Transactional
    public void upRating(long reviewId) {
        reviewRepository.upRating(reviewId);
    }

    @Override
    @Transactional
    public void downRating(long reviewId) {
        reviewRepository.downRating(reviewId);
    }
}
