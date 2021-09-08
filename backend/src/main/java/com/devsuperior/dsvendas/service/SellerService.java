package com.devsuperior.dsvendas.service;

import java.util.List;
import java.util.stream.Collectors;

import com.devsuperior.dsvendas.dto.SellerDto;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SellerService {
    
    @Autowired
    private SellerRepository repository;

    public List<SellerDto> findAll() {
        List<Seller> sellerList = repository.findAll();
        return sellerList.stream().map(seller -> SellerDto.builder()
                                                            .id(seller.getId())
                                                            .name(seller.getName())
                                                            .build())
                                                                .collect(Collectors.toList());
    }
}
