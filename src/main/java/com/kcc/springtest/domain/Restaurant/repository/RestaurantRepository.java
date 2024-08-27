package com.kcc.springtest.domain.Restaurant.repository;

import com.kcc.springtest.domain.Restaurant.model.Restaurant;
import com.kcc.springtest.domain.Restaurant.model.RestaurantResponse;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository {
    int saveRestaurant(Restaurant restaurant);
    int deleteRestaurant(Long id);
    int updateRestaurant(Restaurant restaurant);
    Optional<RestaurantResponse> findById(Long id);
    List<Restaurant> findAll();
}
