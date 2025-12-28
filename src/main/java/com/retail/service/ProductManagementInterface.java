package com.retail.service;

import com.retail.entity.Products;

import java.util.List;

public interface ProductManagementInterface {
    List<Products> findAll();
    Products findById(Long id);
    Products create(Products products);
    Products update (Long id, Products updated);
    void delete(Long id);

}
