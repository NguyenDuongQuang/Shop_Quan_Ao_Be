package com.example.backend.dto.sale;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderStatusDto {

    private Long waitConfirm;

    private Long confirmed;

    private Long waitPrepare;

    private Long shipping;

    private Long shipped;

    private Long cancelled;

    private Long unpaid;

    private Long paid;

}
