package com.kcc.springtest.domain.Restaurant.service;

import com.kcc.springtest.domain.Restaurant.model.Restaurant;
import com.kcc.springtest.domain.Restaurant.model.RestaurantResponse;
import com.kcc.springtest.domain.Restaurant.repository.RestaurantRepository;
import com.kcc.springtest.domain.menu.service.MenuService;
import com.kcc.springtest.global.exception.BadRequestException;
import com.kcc.springtest.global.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    private final MenuService menuService;

    @Transactional
    public void saveRestaurant(Restaurant restaurant) {
        int isPass = restaurantRepository.saveRestaurant(restaurant);
        if (isPass == 0) {
            throw new BadRequestException("입력 정보를 다시 확인해주세요.", HttpStatus.BAD_REQUEST);
        }

        restaurant.getMenus().forEach(menu -> {
            menuService.saveMenu(restaurant.getId(), menu);
        });
//        menuRepository.saveMenus(restaurant.getMenus());
    }

    @Transactional
    public void deleteRestaurant(Long id) {
        int isPass = restaurantRepository.deleteRestaurant(id);
        if (isPass == 0) {
            throw new NotFoundException("존재하지 않는 레스토랑입니다.", HttpStatus.NOT_FOUND);
        }
    }

    @Transactional
    public void updateRestaurant(Long id, Restaurant restaurant) {
        restaurant.setId(id);
        int isPass = restaurantRepository.updateRestaurant(restaurant);
        if (isPass == 0) {
            throw new BadRequestException("입력 정보를 다시 확인해주세요.", HttpStatus.BAD_REQUEST);
        }

        RestaurantResponse restaurantResponse = restaurantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("존재하지 않는 레스토랑입니다.", HttpStatus.NOT_FOUND));
        menuService.deleteMenusByRestaurantId(restaurantResponse.getId());

        restaurant.getMenus().forEach(menu -> {
            menuService.saveMenu(restaurant.getId(), menu);
        });
    }

    public RestaurantResponse findById(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("존재하지 않는 레스토랑입니다.", HttpStatus.NOT_FOUND));
    }

    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }
}
