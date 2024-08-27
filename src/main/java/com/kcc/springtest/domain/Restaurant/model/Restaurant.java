package com.kcc.springtest.domain.Restaurant.model;

import com.kcc.springtest.domain.menu.model.Menu;
import com.kcc.springtest.domain.review.model.Review;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Restaurant {

    private Long id;

    @NotBlank(message = "맛집 이름은 필수입니다.")
    @Size(min = 1, max = 100, message = "맛집 이름은 1자 이상, 100자 이하여야 합니다.")
    private String name;

    @NotBlank(message = "주소는 필수입니다.")
    @Size(min = 1, max = 200, message = "주소는 1자 이상, 200자 이하여야 합니다.")
    private String address;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    private List<Menu> menus;
    private String abc;

}
