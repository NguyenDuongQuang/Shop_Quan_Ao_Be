package com.example.backend.dto.sale;

import com.example.backend.entity.Color;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindProductDto implements Serializable {
    private Long id;
    private String name;
    private double originPrice;
    private double promotionPrice;
    private Color color;
    private String image;
}
