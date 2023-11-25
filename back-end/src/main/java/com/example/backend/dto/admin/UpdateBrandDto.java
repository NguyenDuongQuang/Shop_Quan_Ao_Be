package com.example.backend.dto.admin;

import lombok.Data;

@Data
public class UpdateBrandDto {
    private final String name;
    private final int status;
}
