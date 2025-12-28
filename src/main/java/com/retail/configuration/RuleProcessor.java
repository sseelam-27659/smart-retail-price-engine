package com.retail.configuration;

import com.retail.entity.Pricingrules;
import com.retail.entity.Products;

import java.math.BigDecimal;

public interface RuleProcessor {
    boolean isApplicable(Products product, int quantity, Pricingrules rule);
    BigDecimal apply(BigDecimal currentPrice, Pricingrules rule, int quantity);
    String getName();
}
