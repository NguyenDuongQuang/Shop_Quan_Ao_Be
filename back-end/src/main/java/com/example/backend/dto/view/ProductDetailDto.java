package com.example.backend.dto.view;

import com.example.backend.entity.Color;
import com.example.backend.entity.Size;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailDto implements Serializable {
    @NotNull
    private Double originPrice;
    @NotNull
    private Double promotionPercentage;
    @NotNull
    private Double promotionPrice;
    @NotNull
    private Long productId;
    @NotNull
    private Size size;
    @NotNull
    private Color color;
    private List<ProductImageDto> listProductImage;


}
