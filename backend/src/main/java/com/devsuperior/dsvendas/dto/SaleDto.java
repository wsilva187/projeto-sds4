package com.devsuperior.dsvendas.dto;

import java.time.LocalDate;

import com.devsuperior.dsvendas.entities.Sale;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaleDto {
    
    private Long id;
    private Integer visited;
    private Integer deals;
    private Double amount;
    private LocalDate date;

    private SellerDto seller;

    public static SaleDto make(Sale sale){
        return builder()
                .id(sale.getId())
                .visited(sale.getVisited())
                .deals(sale.getDeals())
                .amount(sale.getAmount())
                .date(sale.getDate())
                .seller(SellerDto.make(sale.getSeller()))
                .build();
    }
}
