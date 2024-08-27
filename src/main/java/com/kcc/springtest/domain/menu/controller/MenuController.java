package com.kcc.springtest.domain.menu.controller;

import com.kcc.springtest.domain.menu.model.Menu;
import com.kcc.springtest.domain.menu.service.MenuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menus")
@Tag(name = "메뉴 API")
@Slf4j
public class MenuController {
    private final MenuService menuService;

    @Operation(summary = "메뉴 생성")
    @PostMapping("/{restaurantId}")
    public ResponseEntity<Menu> createMenu(@PathVariable(value = "restaurantId") Long id,
                                           @RequestBody @Validated Menu menu) {
        System.out.println("index is called by POST /menus/{restaurantId}");
        log.info("index is called by POST /menus/{restaurantId}");
        return ResponseEntity.created(URI.create("/" + menu.getId())).build();
    }

    @Operation(summary = "메뉴 삭제")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable(value = "id") Long id) {
        menuService.deleteMenu(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "메뉴 조회")
    @GetMapping("/{id}")
    public ResponseEntity<List<Menu>> getMenus(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(menuService.findAll(id));
    }
}
