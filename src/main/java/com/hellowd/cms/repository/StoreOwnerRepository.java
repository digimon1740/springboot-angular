package com.hellowd.cms.repository;

import com.hellowd.cms.domain.StoreOwner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreOwnerRepository extends JpaRepository<StoreOwner, Long> {
    StoreOwner findBySeq(long seq);
    List<StoreOwner> findByNameLike(String name);
}
