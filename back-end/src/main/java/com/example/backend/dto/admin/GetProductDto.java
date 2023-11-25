package com.example.backend.dto.admin;
import com.example.backend.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductDto implements Serializable {
    @NotBlank
    private String name;
    @NotNull
    private Integer gender;
    @NotNull
    private Integer status;
    @NotBlank
    private String description;
    @NotNull
    private Integer totalAmount;
    @NotNull
    private Integer available;
    private Date createdAt;
    private Date updatedAt;
    private String updatedBy;
    private Category category;
    private Brand brand;
    private MadeIn madeIn;
    private List<ProductDetailDto> listProductDetail;

}
