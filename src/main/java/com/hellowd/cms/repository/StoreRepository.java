package com.hellowd.cms.repository;

import com.hellowd.cms.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {
    Store findBySeq(long seq);
    List<Store> findByOwnerSeq(long seq);
}
