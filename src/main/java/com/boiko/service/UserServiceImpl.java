package com.boiko.service;

import com.boiko.model.User;
import com.boiko.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public void saveUser(User user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    @Transactional
    public List<User> findUsersByReviewId(long reviewId) {
        return userRepository.findUsersByReviewId(reviewId);
    }

    @Override
    @Transactional
    public User findByIp(String ip) {
        return userRepository.findByIp(ip);
    }
}
