package com.letshego.interview.solution.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name="customer_id")
    private String customerId;

    @Column(name="customer_first_name")
    private String customerFirstName;

    @Column(name="customer_last_name")
    private String customerLastName;

    @Column(name="registration_date")
    private LocalDate effectiveDate;

    @Enumerated(EnumType.STRING)
    @Column(name="customer_type")
    private CustomerType customerType;

}
