package com.boiko.controller;

import com.boiko.model.Review;
import com.boiko.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Controller
public class AppController {

    @Autowired
    ReviewService reviewService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Review add(@RequestBody Review review) {
        return reviewService.addRewiew(review);
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
    public String viewCustomers(@RequestParam(name = "p", defaultValue = "1") int pageNumber,
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

/* @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String submit(@ModelAttribute("review") Review review
            , ModelMap model) {
        review.setDate(new Date());
        model.addAttribute("title", review.getTitle());
        model.addAttribute("body", review.getBody());
        model.addAttribute("name", review.getName());
        model.addAttribute("rating", review.getRating());
        model.addAttribute("date", review.getDate());
        reviewService.addRewiew(review);
        return "guestBook";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getReviews(Model model) {
        List<Review> listReviews = reviewService.getPage(5,3,"rating");


        model.addAttribute("review", new Review());
        model.addAttribute("listReviews", listReviews);
        return "guestBook";
    }*/