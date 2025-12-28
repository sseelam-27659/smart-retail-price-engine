package com.retail.controller;

import com.retail.entity.Products;
import com.retail.service.ProductManagementInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductManagement {
    @Autowired
    private final ProductManagementInterface productManagement;

    public ProductManagement(ProductManagementInterface productManagement) {
        this.productManagement = productManagement;
    }

    @GetMapping
    public List<Products> getAll() {
        return productManagement.findAll();
    }

    @GetMapping("/{id}")
    public Products getById(@PathVariable Long id) {
        return productManagement.findById(id);
    }

    @PostMapping
    public Products create(@RequestBody Products product) {
        return productManagement.create(product);
    }

    @PutMapping("/{id}")
    public Products update(@PathVariable Long id,
                          @RequestBody Products product) {
        return productManagement.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productManagement.delete(id);
    }

}
