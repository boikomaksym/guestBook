package com.boiko.service;

import com.boiko.model.Review;

import java.util.List;

public interface ReviewService {
    Review addReview(Review review);
    List<Review>getPage(int pageNumber, int pageSize, String pageSorting);
    Iterable<Review>findAll();
}
