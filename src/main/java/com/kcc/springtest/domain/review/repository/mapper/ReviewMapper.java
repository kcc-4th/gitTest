package com.kcc.springtest.domain.review.repository.mapper;

import com.kcc.springtest.domain.review.model.Review;
import com.kcc.springtest.domain.review.model.ReviewPageResponse;
import com.kcc.springtest.domain.review.model.ReviewResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReviewMapper {
    int saveReview(Review review);
    int deleteReview(Long id);
    ReviewPageResponse findAll(Map<String, Long>map);
    Float findAvgScore(Long restaurantId);
}
