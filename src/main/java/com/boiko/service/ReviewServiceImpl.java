package com.boiko.service;

import com.boiko.model.Review;
import com.boiko.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ReviewServiceImpl implements ReviewService {


    @Autowired
    ReviewRepository reviewRepository;


    @Override
    public Review addRewiew(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Iterable<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public List<Review> getPage(int pageSize, int pageNumber, String pageSorting) {
        PageRequest request = new PageRequest(pageNumber - 1, pageSize, Sort.Direction.ASC, pageSorting);
        return reviewRepository.findAll(request).getContent();
    }
}
