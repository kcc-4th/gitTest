package com.kcc.springtest.domain.Restaurant.model;

import com.kcc.springtest.domain.menu.model.dto.MenuResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RestaurantResponse {

    private Long id;
    private String name;
    private String address;

    private String created_at;
    private String updated_at;

    private List<MenuResponse> menus;

}
