package com.example.backend.dto.sale;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StatusCountStatsDto {

    HumanStatsDto employeeStats;

    HumanStatsDto customerStats;

    ProductStatusDto productStatusDto;

    OrderStatusDto orderStatusDto;

}
