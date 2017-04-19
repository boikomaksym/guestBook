package com.boiko.repository;

import com.boiko.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Modifying
    @Query("update Review r set r.rating = r.rating+1 where r.id = :reviewId")
    void upRating(@Param("reviewId") long reviewId);

    @Modifying
    @Query("update Review r set r.rating = r.rating-1 where r.id = :reviewId")
    void downRating(@Param("reviewId") long reviewId);
}