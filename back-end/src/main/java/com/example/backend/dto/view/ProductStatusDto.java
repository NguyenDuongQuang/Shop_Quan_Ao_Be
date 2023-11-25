package com.example.backend.dto.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductStatusDto {

    private Long active;

    private Long inactive;

    private Long outOfStock;

    private CategoryStatusDto categoryStats;

    private BrandStatusDto brandStats;

    private Long allMadeIns;



}
