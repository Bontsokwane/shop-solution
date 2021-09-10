package com.letshego.interview.solution.controller;

import com.letshego.interview.solution.model.Product;
import com.letshego.interview.solution.service.Impl.ProductServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/shop/product")
@Api(value = "SHOP APIs")
public class ProductController {

    private  final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @ApiOperation(value = "Create new Product ")
    @PostMapping(path = "/create")
    public Product createProduct(@RequestBody Product product) {

        return productService.createProduct(product);
    }

    @ApiOperation(value = "Retrieve Product details using id")
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable String id) {

        return productService.getProductById(id);
    }
}
