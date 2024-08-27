package com.kcc.springtest.domain.menu.service;

import com.kcc.springtest.domain.menu.model.Menu;
import com.kcc.springtest.domain.menu.repository.MenuRepository;
import com.kcc.springtest.domain.menu.repository.vo.MenuVO;
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
public class MenuService {
    private final MenuRepository menuRepository;

    @Transactional
    public void saveMenu(Long restaurant_id, Menu menu) {
        menu.setRestaurant_id(restaurant_id);
        int isPass = menuRepository.saveMenu(menu);
        if (isPass == 0) {
            throw new BadRequestException("입력 정보를 다시 확인해주세요.", HttpStatus.BAD_REQUEST);
        }
    }

    @Transactional
    public void deleteMenu(Long id) {
        int isPass = menuRepository.deleteMenu(id);
        if (isPass == 0) {
            throw new NotFoundException("존재하지 않는 메뉴입니다.", HttpStatus.NOT_FOUND);
        }
    }

    @Transactional
    public void deleteMenusByRestaurantId(Long restaurant_id) {
        int isPass = menuRepository.deleteMenusByRestaurantId(restaurant_id);
        if (isPass == 0) {
            throw new NotFoundException("존재하지 않는 레스토랑입니다.", HttpStatus.NOT_FOUND);
        }
    }

    @Transactional
    public void updateMenu(Menu menu) {
        int isPass = menuRepository.updateMenu(menu);
        if (isPass == 0) {
            throw new BadRequestException("입력 정보를 다시 확인해주세요.", HttpStatus.BAD_REQUEST);
        }
    }

    public Menu findById(Long id) {
        return menuRepository.findById(id);
    }

    public List<Menu> findAll(Long restaurant_id) {
        return menuRepository.findAll(restaurant_id);
    }
}
