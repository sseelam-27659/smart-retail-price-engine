package com.retail.dto;

import java.math.BigDecimal;
import java.util.List;


public class PriceResponse {
    private BigDecimal basePrice;
    private BigDecimal finalPrice;
    private List<String> appliedRules;

    public PriceResponse(BigDecimal basePrice, BigDecimal finalPrice, List<String> appliedRules) {
        this.basePrice = basePrice;
        this.finalPrice = finalPrice;
        this.appliedRules = appliedRules;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public List<String> getAppliedRules() {
        return appliedRules;
    }
}
