package com.kcc.springtest.domain.menu.repository;

import com.kcc.springtest.domain.menu.model.Menu;
import com.kcc.springtest.domain.menu.repository.mapper.MenuMapper;
import com.kcc.springtest.domain.menu.repository.vo.MenuVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MenuRepositoryImpl implements MenuRepository{
    private final MenuMapper menuMapper;

    @Override
    public int saveMenu(Menu menu) {
        return menuMapper.saveMenu(menu);
    }

    @Override
    public int saveMenus(List<Menu> menus) {
        return menuMapper.saveMenus(menus);
    }

    @Override
    public int deleteMenu(Long id) {
        return menuMapper.deleteMenu(id);
    }

    @Override
    public int deleteMenusByRestaurantId(Long restaurant_id) {
        return menuMapper.deleteMenusByRestaurantId(restaurant_id);
    }

    @Override
    public int updateMenu(Menu menu) {
        return menuMapper.updateMenu(menu);
    }

    @Override
    public Menu findById(Long id) {
        return menuMapper.findById(id);
    }

    @Override
    public List<Menu> findAll(Long restaurant_id) {
        return menuMapper.findAll(restaurant_id);
    }
}
