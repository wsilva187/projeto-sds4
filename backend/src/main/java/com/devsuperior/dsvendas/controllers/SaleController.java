package com.devsuperior.dsvendas.controllers;

import java.util.List;

import com.devsuperior.dsvendas.dto.SaleDto;
import com.devsuperior.dsvendas.dto.SaleSuccesDto;
import com.devsuperior.dsvendas.dto.SaleSumDto;
import com.devsuperior.dsvendas.service.SaleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
    
    @Autowired
    private SaleService service;

    @GetMapping
    private ResponseEntity<Page<SaleDto>> findAll(Pageable pageable){
        Page<SaleDto> list = service.findAll(pageable);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/amount-by-seller")
    private ResponseEntity<List<SaleSumDto>> amountGroupBySeller(){
        List<SaleSumDto> list = service.amountGroupBySeller();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/success-by-seller")
    private ResponseEntity<List<SaleSuccesDto>> successGroupBySeller(){
        List<SaleSuccesDto> list = service.succesGroupBySeller();
        return ResponseEntity.ok(list);
    }
}
