package com.retail.service;

import com.retail.entity.Products;
import com.retail.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductManagementService implements ProductManagementInterface {
    @Autowired
    private final ProductRepository repository;

    public ProductManagementService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Products> findAll() {
        return repository.findAll();
    }

    public Products findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Products create(Products product) {
        return repository.save(product);
    }

    public Products update(Long id, Products updated) {
        Products existing = findById(id);

        existing.setName(updated.getName());
        existing.setBasePrice(updated.getBasePrice());
        existing.setCategory(updated.getCategory());
        existing.setBrand(updated.getBrand());
        existing.setStockQuantity(updated.getStockQuantity());

        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
