package com.kcc.springtest.domain.review.controller;

import com.kcc.springtest.domain.review.model.Review;
import com.kcc.springtest.domain.review.model.ReviewPageResponse;
import com.kcc.springtest.domain.review.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Tag(name = "리뷰 API")
public class ReviewController {
    private final ReviewService reviewService;

    @Operation(summary = "리뷰 생성")
    @PostMapping("/review")
    public ResponseEntity<Void> createReview(@RequestBody @Validated Review review) {
        reviewService.saveReview(review);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "리뷰 삭제")
    @DeleteMapping("/review/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable(value = "id") Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "레스토랑의 전체 리뷰 조회")
    @GetMapping("/restaurant/{restaurantId}/reviews")
    public ResponseEntity<ReviewPageResponse> getReviews(@PathVariable(value = "restaurantId") Long id,
                                                         @RequestParam(value = "page", defaultValue = "1") int pageNumber) {
        return ResponseEntity.ok().body(reviewService.findReviews(id, pageNumber));
    }

}
