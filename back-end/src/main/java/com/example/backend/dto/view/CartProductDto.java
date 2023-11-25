package com.example.backend.dto.view;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class CartProductDto implements Serializable {
    @NotBlank
    private String productName;
    @NotNull
    private Integer quantity;
    @NotNull
    private Long productDetailId;
    @NotNull
    private ProductDetailDto productDetail;


}
