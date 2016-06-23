package com.hellowd.cms.service;

import com.hellowd.cms.domain.StoreOwner;
import com.hellowd.cms.repository.StoreOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StoreOwnerService {
    @Autowired
    StoreOwnerRepository storeOwnerRepository;

    public List<StoreOwner> findAllSortName() {
        return storeOwnerRepository.findAll(new Sort(Sort.Direction.ASC, "name"));
    }
    public StoreOwner findBySeq(long seq){
        return storeOwnerRepository.findBySeq(seq);
    }

    public List<StoreOwner> findByNameLike(String name) {
        return storeOwnerRepository.findByNameLike(name);
    }
}
