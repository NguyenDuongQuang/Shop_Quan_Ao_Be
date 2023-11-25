package com.example.backend.dto.view;

import com.example.backend.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductSaleDto implements Serializable {
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    private int gender;
    @NotBlank
    private String description;
    private Category category;
    private Brand brand;
    private MadeIn madeIn;
    private List<ProductDto> listProductDetail;

}
