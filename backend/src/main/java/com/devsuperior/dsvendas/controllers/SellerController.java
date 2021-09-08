package com.devsuperior.dsvendas.controllers;

import java.util.List;

import com.devsuperior.dsvendas.dto.SellerDto;
import com.devsuperior.dsvendas.service.SellerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sellers")
public class SellerController {
    
    @Autowired
    private SellerService service;

    @GetMapping
    private ResponseEntity<List<SellerDto>> findAll(){
        List<SellerDto> findAll = service.findAll();
        return ResponseEntity.ok(findAll);
    }
}
