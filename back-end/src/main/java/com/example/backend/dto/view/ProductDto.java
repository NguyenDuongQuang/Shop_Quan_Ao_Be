package com.example.backend.dto.view;

import com.example.backend.entity.Color;
import com.example.backend.entity.ProductImage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements Serializable {
    @NotNull
    private double originPrice;
    @NotNull
    private double promotionPercentage;
    @NotNull
    private double promotionPrice;
    private int status;
    private Color color;
    private List<SizeDto> listSize;
    private List<ProductImage> listProductImage;

}
