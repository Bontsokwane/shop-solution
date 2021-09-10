package com.letshego.interview.solution.service;

import com.letshego.interview.solution.model.Product;

import java.util.Optional;

public interface ProductService {

    public Product createProduct(Product product);

    public Optional<Product> getProductById(String product_code);
}
