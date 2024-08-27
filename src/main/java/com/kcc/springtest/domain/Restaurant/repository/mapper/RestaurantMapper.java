package com.kcc.springtest.domain.Restaurant.repository.mapper;

import com.kcc.springtest.domain.Restaurant.model.Restaurant;
import com.kcc.springtest.domain.Restaurant.model.RestaurantResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface RestaurantMapper {
    int saveRestaurant(Restaurant restaurant);
    int deleteRestaurant(Long id);
    int updateRestaurant(Restaurant restaurant);
    Optional<RestaurantResponse> findById(Long id);
    List<Restaurant> findAll();
}
