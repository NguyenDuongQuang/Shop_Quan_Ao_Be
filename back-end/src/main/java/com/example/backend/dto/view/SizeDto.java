package com.example.backend.dto.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public  class SizeDto implements Serializable {
    private Integer id;
    @NotBlank
    private String name;
    private String description;
    private Integer availAmount;
    private Long productDetailId;
}
