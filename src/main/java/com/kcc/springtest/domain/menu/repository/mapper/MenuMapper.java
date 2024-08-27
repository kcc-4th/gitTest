package com.kcc.springtest.domain.menu.repository.mapper;

import com.kcc.springtest.domain.menu.model.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    int  saveMenu(Menu menu);
    int saveMenus(List<Menu> menus);
    int deleteMenu(Long id);
    int deleteMenusByRestaurantId(Long restaurant_id);
    int updateMenu(Menu menu);
    Menu findById(Long id);
    List<Menu> findAll(Long restaurant_id);
}
