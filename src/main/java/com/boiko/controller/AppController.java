package com.boiko.controller;

import com.boiko.model.Review;
import com.boiko.model.User;
import com.boiko.service.ReviewService;
import com.boiko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    ReviewService reviewService;

    @Autowired
    UserService userService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/book/{pageNumber}/{size}/{order}", method = RequestMethod.GET)
    public ModelAndView getPage(@PathVariable int pageNumber, @PathVariable int size, @PathVariable String order, ModelAndView model) {
        Page<Review> page = reviewService.findAll(pageNumber, size, order);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addObject("pages", page);
        model.addObject("reviews", page.getContent());
        model.addObject("beginIndex", begin);
        model.addObject("endIndex", end);
        model.addObject("currentIndex", current);
        model.addObject("order", order);
        model.setViewName("review");
        return model;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView showAddReviewForm(ModelAndView model, Review review) {
        model.addObject("review", review);
        model.setViewName("add");
        return model;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView submit(@ModelAttribute("review") @Validated Review review, BindingResult result
            , ModelAndView model) {
        if (result.hasErrors()) {
            return new ModelAndView("add");
        }
        review.setDate(new Date());
        review.setRating(0);
        model.addObject("title", review.getTitle());
        model.addObject("body", review.getBody());
        model.addObject("name", review.getName());
        model.addObject("rating", review.getRating());
        model.addObject("date", review.getDate());
        model.addObject("review", review);
        reviewService.saveReview(review);
        model.setViewName("redirect:/book/1/5/date");
        return model;
    }

    @RequestMapping(value = "/rating")
    public ModelAndView upRating(HttpServletRequest request) {
        long reviewId = Long.parseLong(request.getParameter("id"));
        List<User> usersByReviewId = userService.findUsersByReviewId(reviewId);

        String ip = request.getRemoteAddr();
        if (usersByReviewId
                .stream()
                .anyMatch(user -> user.getIp().equals(ip))) {
            return new ModelAndView("redirect:/book/1/5/name");
        }
        String requestUrl = request.getQueryString();
        System.out.println(requestUrl);
        if (requestUrl.contains("down")) {
            reviewService.downRating(reviewId);
        } else {
            reviewService.upRating(reviewId);
        }
        User user = userService.findByIp(ip);
        if (user != null) {
            user.getReviews().add(reviewService.findById(reviewId));
        } else {
            user = new User();
            user.setIp(ip);
            user.setReviews(new HashSet<>());
            user.getReviews().add(reviewService.findById(reviewId));
        }
        userService.saveUser(user);
        ModelAndView model = new ModelAndView("redirect:/book/1/5/name");
        return model;
    }
}