package com.kcc.springtest.domain.review.model;

import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewPageResponse {
    Float avgScore;
    List<ReviewResponse> reviews;
    PageResponse page;
}
