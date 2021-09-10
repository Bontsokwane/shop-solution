package com.letshego.interview.solution.repository;


import com.letshego.interview.solution.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
