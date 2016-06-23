package com.hellowd.cms.repository;

import com.hellowd.cms.domain.Seller;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SellerRepository extends JpaRepository<Seller, Long> {
    List<Seller> findByDepthOrderByName(int depth);
    List<Seller> findByDepthAndNameNotContaining(int depth, String name);
    List<Seller> findByNameNotContaining(String name, Sort sort);
    List<Seller> findByParentSeqOrderByName(Long parentSeq);

    Seller findBySeq(long seq);
    long countByEmail(String email);
}
