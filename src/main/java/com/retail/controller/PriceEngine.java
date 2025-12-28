package com.retail.controller;

import com.retail.dto.PriceResponse;
import com.retail.entity.Products;
import com.retail.repository.PricingRuleRepository;
import com.retail.repository.ProductRepository;
import com.retail.service.PriceEngineInterface;
import com.retail.service.PriceEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/price")
public class PriceEngine {

    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private PriceEngineInterface engine;

    @PostMapping("/compute")
    public PriceResponse compute(@RequestParam Long productId,
                                 @RequestParam int quantity) {
        Products products = productRepo.findById(productId).orElseThrow();
        return engine.compute(products, quantity);
    }
}
