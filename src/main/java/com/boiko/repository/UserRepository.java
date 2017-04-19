package com.boiko.repository;

import com.boiko.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u left join  u.reviews as reviews where reviews.id = :id")
    List<User> findUsersByReviewId(@Param("id") long reviewId);

    User findByIp(String ip);
}
