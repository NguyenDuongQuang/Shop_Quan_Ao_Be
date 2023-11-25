package com.example.backend.dto.admin;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
public class UpdateProductDto implements Serializable {
    @NotBlank
    private final String name;

    @NotNull
    private final Integer gender;

    @NotNull
    private final Integer status;

    @NotNull
    private final Integer available;

    @NotBlank
    private final String description;

    @NotNull
    private final Integer brandId;

    @NotNull
    private final Integer categoryId;

    @NotNull
    private final Integer madeInId;

    @NotEmpty
    private final List<ProductDetailDto> listProductDetail;

}
