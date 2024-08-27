package com.kcc.springtest.domain.menu.repository.vo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MenuVO implements Serializable {
    private Long id;
    private Long restaurant_id;
}
