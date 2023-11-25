package com.example.backend.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BrandDto implements Serializable {
    private final String name;
    private final int status;
}
