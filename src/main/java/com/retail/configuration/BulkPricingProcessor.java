package com.retail.configuration;

import com.retail.entity.Pricingrules;
import com.retail.entity.Products;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
public class BulkPricingProcessor implements RuleProcessor{
    public boolean isApplicable(Products products, int qty, Pricingrules Pricingrules) {
        return qty >= 10;
    }

    public BigDecimal apply(BigDecimal price, Pricingrules Pricingrules, int qty) {
        return price.subtract(Pricingrules.getValue());
    }

    public String getName() { return "BULK"; }
}
