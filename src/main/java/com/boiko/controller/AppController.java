package com.boiko.controller;

import com.boiko.model.Review;
import com.boiko.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class AppController {

    @Autowired
    ReviewService reviewService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Review add(@RequestBody Review review) {
        return reviewService.addReview(review);
    }

    @RequestMapping("/")
    public String findAll() {
        String result = "<html>";
        for (Review review : reviewService.findAll()) {
            result += review.toString() + "<br/>";
        }
        return result + "</html>";
    }

    @RequestMapping(value = "/pagingAndSorting", method = RequestMethod.GET)
    public String viewPages(@RequestParam(name = "p", defaultValue = "1") int pageNumber,
                            @RequestParam(name = "s", defaultValue = "name") String pageSorting,
                            @RequestParam(name = "n", defaultValue = "5") int pageSize) {
        String result = "<html>";
        List<Review> reviews = reviewService.getPage(pageSize, pageNumber, pageSorting);
        for (Review review : reviews) {
            result += review.toString() + "<br/>";
        }
        return result + "</html>";
    }
}