package com.letshego.interview.solution.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @Column(name="product_code")
    private String productCode;

    @Column(name="product_name")
    private String ProductName;

    @Column(name="product_price")
    private Double productPrice;

    @Column(name="discountable")
    private boolean isDiscountable;
}
