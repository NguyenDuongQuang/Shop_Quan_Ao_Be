package com.example.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCustomerDto {
    private String name;

    private int gender;

    // @JsonFormat(pattern="dd/MM/yyyy")
    // @Temporal(TemporalType.DATE)
    // private Date birthDay;

    private String phone;

    // private float height;

    // private float weight;

    private int status;
}