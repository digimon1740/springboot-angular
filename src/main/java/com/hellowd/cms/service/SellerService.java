package com.hellowd.cms.service;

import com.hellowd.cms.domain.Seller;
import com.hellowd.cms.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SellerService {
    @Autowired
    SellerRepository sellerRepository;


    public List<Seller> findAll(Sort sort) {
        return sellerRepository.findAll(sort);
    }

}
