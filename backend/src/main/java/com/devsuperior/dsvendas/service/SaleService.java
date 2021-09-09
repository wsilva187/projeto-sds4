package com.devsuperior.dsvendas.service;

import java.util.List;

import com.devsuperior.dsvendas.dto.SaleDto;
import com.devsuperior.dsvendas.dto.SaleSuccesDto;
import com.devsuperior.dsvendas.dto.SaleSumDto;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SaleService {
    
    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Transactional(readOnly = true)
    public Page<SaleDto> findAll(Pageable pageable) {
        //TODO ver outra forma sem carregar todos os sellers 
        //hibernate repete o select para cada seller se não fizer esse select antes
        //obs tbm não funciona sem o @Transactional
        sellerRepository.findAll();
        Page<Sale> saleList = saleRepository.findAll(pageable);
        return saleList.map(sale -> SaleDto.make(sale));
    }

    @Transactional(readOnly = true)
    public List<SaleSumDto> amountGroupBySeller() {
        return saleRepository.amountGroupedBySeller();
    }

    @Transactional(readOnly = true)
    public List<SaleSuccesDto> succesGroupBySeller() {
        return saleRepository.successGroupedBySeller();
    }
}
