package com.kcc.springtest.domain.review.repository;

import com.kcc.springtest.domain.review.model.Review;
import com.kcc.springtest.domain.review.model.ReviewPageResponse;
import com.kcc.springtest.domain.review.model.ReviewResponse;

import java.util.List;
import java.util.Map;

public interface ReviewRepository {
    int saveReview(Review review);
    int deleteReview(Long id);
    ReviewPageResponse findAll(Map<String, Long> map);
    Float findAvgScore(Long restaurantId);
}
