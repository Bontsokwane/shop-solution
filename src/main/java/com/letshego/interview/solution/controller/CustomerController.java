package com.letshego.interview.solution.controller;

import com.letshego.interview.solution.model.Customer;
import com.letshego.interview.solution.service.Impl.CustomerServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/shop/customer")
@Api(value = "SHOP APIs")
public class CustomerController {

    private  final CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @ApiOperation(value = "Create new Customer ")
    @PostMapping(path = "/create")
    public Customer createCustomer(@RequestBody Customer customer) {

        return customerService.createCustomer(customer);
    }

    @ApiOperation(value = "Retrieve customer details using id")
    @GetMapping("/{id}")
    public Optional<Customer> getCustomerById(@PathVariable String id) {

        return customerService.getCustomerById(id);
    }
}
