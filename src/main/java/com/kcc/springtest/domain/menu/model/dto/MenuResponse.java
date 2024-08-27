package com.kcc.springtest.domain.menu.model.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MenuResponse {
    private Long id;
    private String name;
    private int price;
    private String created_at;
    private String updated_at;
}
