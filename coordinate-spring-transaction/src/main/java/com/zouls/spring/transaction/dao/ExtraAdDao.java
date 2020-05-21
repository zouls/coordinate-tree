package com.zouls.spring.transaction.dao;

import com.zouls.spring.transaction.entity.ExtraAd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExtraAdDao extends JpaRepository<ExtraAd, Long> {
}
