package com.devsuperior.dsvendas.dto;

import java.io.Serializable;

import com.devsuperior.dsvendas.entities.Seller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SellerDto implements Serializable {

    private Long id;
    private String name;

    public static SellerDto make(Seller seller) {
        return builder()
                .id(seller.getId())
                .name(seller.getName())
                .build();
    }
}
