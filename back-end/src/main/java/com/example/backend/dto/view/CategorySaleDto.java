package com.example.backend.dto.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public  class CategorySaleDto implements Serializable {
    private Integer id;
    private String name;
}
