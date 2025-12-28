package com.retail.controller;

import com.retail.entity.Pricingrules;
import com.retail.service.PricingRulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class PricingRules {
    @Autowired
    private final PricingRulesService service;

    public PricingRules(PricingRulesService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pricingrules> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Pricingrules getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Pricingrules create(@RequestBody Pricingrules rule) {
        return service.create(rule);
    }

    @PutMapping("/{id}")
    public Pricingrules update(@PathVariable Long id,
                              @RequestBody Pricingrules rule) {
        return service.update(id, rule);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
