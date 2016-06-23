package com.hellowd.cms.service;

import com.hellowd.cms.domain.Store;
import com.hellowd.cms.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StoreService {
	@Autowired
	StoreRepository storeRepository;

	public Store findBySeq(long seq) {
		return storeRepository.findBySeq(seq);
	}

	public List<Store> findByOwnerSeq(long seq) {
		return storeRepository.findByOwnerSeq(seq);
	}

	public List<Store> findAll() {
		return storeRepository.findAll();
	}
}
