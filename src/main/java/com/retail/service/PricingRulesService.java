package com.retail.service;

import com.retail.entity.Pricingrules;
import com.retail.repository.PricingRuleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PricingRulesService implements PricingRulesInterface{
    @Autowired
    private final PricingRuleRepository repository;

    public PricingRulesService(PricingRuleRepository repository) {
        this.repository = repository;
    }

    public List<Pricingrules> findAll() {
        return repository.findAll();
    }

    public Pricingrules findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rule not found"));
    }

    public Pricingrules create(Pricingrules rule) {
        return repository.save(rule);
    }

    public Pricingrules update(Long id, Pricingrules updated) {
        Pricingrules existing = findById(id);

        existing.setName(updated.getName());
        existing.setRuleType(updated.getRuleType());
        existing.setValue(updated.getValue());
        existing.setPriority(updated.getPriority());
        existing.setConditionJson(updated.getConditionJson());
        existing.setActive(updated.getActive());

        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
