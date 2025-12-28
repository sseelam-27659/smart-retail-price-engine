package com.retail.service;

import com.retail.configuration.RuleProcessor;
import com.retail.configuration.RuleProcessorFactory;
import com.retail.dto.PriceResponse;
import com.retail.entity.Pricingrules;
import com.retail.entity.Products;
import com.retail.repository.PricingRuleRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PriceEngineService implements PriceEngineInterface {

    private final PricingRuleRepository pricingRuleRepository;
    private final RuleProcessorFactory ruleProcessorFactory;

    public PriceEngineService(PricingRuleRepository pricingRuleRepository, RuleProcessorFactory ruleProcessorFactory) {
        this.pricingRuleRepository = pricingRuleRepository;
        this.ruleProcessorFactory = ruleProcessorFactory;
    }

    public PriceResponse compute(Products products, int qty) {

        BigDecimal price = products.getBasePrice();
        List<String> applied = new ArrayList<>();

        for (Pricingrules rule : pricingRuleRepository.findByIsActiveTrueOrderByPriorityAsc()) {
            RuleProcessor processor = ruleProcessorFactory.getProcessor(rule.getRuleType());
            if (processor != null && processor.isApplicable(products, qty, rule)) {
                price = processor.apply(price, rule, qty);
                applied.add(rule.getName());
            }
        }

        return new PriceResponse(products.getBasePrice(), price, applied);
    }

}
