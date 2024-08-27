package com.kcc.springtest.domain.menu.repository;

import com.kcc.springtest.domain.menu.model.Menu;

import java.util.List;

public interface MenuRepository {
    int saveMenu(Menu menu);
    int saveMenus(List<Menu> menus);
    int deleteMenu(Long id);
    int deleteMenusByRestaurantId(Long restaurant_id);
    int updateMenu(Menu menu);
    Menu findById(Long id);
    List<Menu> findAll(Long id);
}
