package com.kcc.springtest.domain.review.service;

import com.kcc.springtest.domain.review.model.Review;
import com.kcc.springtest.domain.review.model.ReviewPageResponse;
import com.kcc.springtest.domain.review.repository.ReviewRepository;
import com.kcc.springtest.global.exception.BadRequestException;
import com.kcc.springtest.global.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Transactional
    public void saveReview(Review review) {
        int isPass = reviewRepository.saveReview(review);
        if (isPass == 0) {
            throw new BadRequestException("입력 정보를 다시 확인해주세요.", HttpStatus.BAD_REQUEST);
        }
    }

    @Transactional
    public void deleteReview(Long id) {
        int isPass = reviewRepository.deleteReview(id);
        if (isPass == 0) {
            throw new NotFoundException("존재하지 않는 리뷰입니다.", HttpStatus.NOT_FOUND);
        }
    }

    public ReviewPageResponse findReviews(Long restaurantId, int pageNumber) {
        int limit = 5;

        Map<String, Long> map = new HashMap<>();
        map.put("restaurant_id", restaurantId);
        map.put("offset", (long) (pageNumber - 1) * limit);
        map.put("limit", (long) limit);

//        List<ReviewResponse> reviewResponses = reviewRepository.findAll(map);
//        ReviewPageResponse reviewResponses = reviewRepository.findAll(map);
        Float avgScore = reviewRepository.findAvgScore(restaurantId);

//        return new ReviewPageResponse(avgScore, reviewResponses,
//                new PageResponse(Math.toIntExact(map.get("offset")), Math.toIntExact(map.get("limit"))));
        return reviewRepository.findAll(map);
    }
}
