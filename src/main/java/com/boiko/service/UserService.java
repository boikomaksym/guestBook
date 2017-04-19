package com.boiko.service;

import com.boiko.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    List<User> findUsersByReviewId(long reviewId);

    User findByIp(String ip);
}
