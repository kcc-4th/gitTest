package com.kcc.springtest.domain.Restaurant.model;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class RestaurantListResponse implements Serializable {
    private Long id;
    private String name;
    private String address;
    private String createdAt;
    private String updatedAt;
}
