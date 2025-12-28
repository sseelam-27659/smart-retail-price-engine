package com.retail.configuration;
import com.retail.entity.Pricingrules;
import com.retail.entity.Products;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
public class FlatDiscntProcessor implements RuleProcessor {

    public boolean isApplicable(Products products, int qty, Pricingrules pricingrules) {
        return true;
    }

    public BigDecimal apply(BigDecimal price, Pricingrules pricingrules, int qty) {
        return price.subtract(pricingrules.getValue());
    }

    public String getName() { return "FLAT"; }
}
