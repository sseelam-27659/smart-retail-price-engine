package com.retail.service;

import com.retail.entity.Pricingrules;

import java.util.List;

public interface PricingRulesInterface {
    List<Pricingrules> findAll();
    Pricingrules findById(Long id);
    Pricingrules create(Pricingrules rule);
    Pricingrules update(Long id, Pricingrules updated);
    void delete(Long id);

}
