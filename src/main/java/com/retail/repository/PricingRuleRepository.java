package com.retail.repository;

import com.retail.entity.Pricingrules;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PricingRuleRepository extends JpaRepository<Pricingrules, Long> {
    List<Pricingrules> findByIsActiveTrueOrderByPriorityAsc();
}
