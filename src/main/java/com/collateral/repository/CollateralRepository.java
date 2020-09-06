package com.collateral.repository;

import javax.persistence.EntityManager;

import com.collateral.entity.Collateral;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Repository
@Transactional
public class CollateralRepository {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	public Collateral findById(Long id) {
		return em.find(Collateral.class, id);
	}

	public Collateral save(Collateral collateral) {
		collateral.setLastUpdatedDate(LocalDateTime.now());
		Collateral temp = findById(collateral.getId());
		if (temp == null) {
			em.persist(collateral);
		} else {
			em.merge(collateral);
		}

		return collateral;
	}
}
