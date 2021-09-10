package com.letshego.interview.solution.repository;

import com.letshego.interview.solution.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
