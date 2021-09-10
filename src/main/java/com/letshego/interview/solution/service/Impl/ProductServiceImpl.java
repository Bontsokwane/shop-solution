package com.letshego.interview.solution.service.Impl;

import com.letshego.interview.solution.model.Product;
import com.letshego.interview.solution.repository.ProductRepository;
import com.letshego.interview.solution.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private  final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getProductById(String product_code) {
        return productRepository.findById(product_code);
    }
}
