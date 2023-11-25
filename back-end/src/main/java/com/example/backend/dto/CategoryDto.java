package com.example.backend.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryDto implements Serializable {
    private final String name;
    private final int status;
    private final int productSetId;
}
