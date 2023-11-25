package com.example.backend.dto.view;

import com.example.backend.entity.Color;
import com.example.backend.entity.Size;
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
public class CartDto implements Serializable {
    @NotNull
    private Long id;
    @NotBlank
    private String userAuthToken;
    @NotNull
    private boolean registeredUser;
    private List<CartProductDto> cartProducts;


}
