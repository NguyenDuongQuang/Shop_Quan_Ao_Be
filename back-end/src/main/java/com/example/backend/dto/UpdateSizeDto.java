package com.example.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSizeDto {
    private String name;
    private String description;
    private Date updatedAt;
    private String updatedBy;
}
