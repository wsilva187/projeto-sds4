package com.devsuperior.dsvendas.dto;

import java.io.Serializable;

import com.devsuperior.dsvendas.entities.Seller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaleSumDto implements Serializable {
    
    private String sellerName;
    private Double sum;
    public SaleSumDto(Seller seller, Double sum) {
        this.sellerName = seller.getName();
        this.sum = sum;
    } 
    
}
