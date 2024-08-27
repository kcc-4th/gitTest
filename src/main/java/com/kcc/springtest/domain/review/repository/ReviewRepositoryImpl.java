package com.kcc.springtest.domain.review.repository;

import com.kcc.springtest.domain.review.model.Review;
import com.kcc.springtest.domain.review.model.ReviewPageResponse;
import com.kcc.springtest.domain.review.model.ReviewResponse;
import com.kcc.springtest.domain.review.repository.mapper.ReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepository {
    private final ReviewMapper reviewMapper;


    @Override
    public int saveReview(Review review) {
        return reviewMapper.saveReview(review);
    }

    @Override
    public int deleteReview(Long id) {
        return reviewMapper.deleteReview(id);
    }

    @Override
    public ReviewPageResponse findAll(Map<String, Long> map) {
        return reviewMapper.findAll(map);
    }

    @Override
    public Float findAvgScore(Long restaurantId) {
        return reviewMapper.findAvgScore(restaurantId);
    }
}
