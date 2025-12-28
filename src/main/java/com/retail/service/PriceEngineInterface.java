package com.retail.service;

import com.retail.dto.PriceResponse;
import com.retail.entity.Products;

public interface PriceEngineInterface {
    PriceResponse compute(Products products, int qty);
}
