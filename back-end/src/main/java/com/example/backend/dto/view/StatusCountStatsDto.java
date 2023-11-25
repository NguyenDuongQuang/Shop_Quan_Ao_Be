package com.example.backend.dto.view;

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
