package com.letshego.interview.solution.controller;

import com.letshego.interview.solution.model.Cart;
import com.letshego.interview.solution.service.Impl.BillServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/shop/bill/")
@Api(value = "SHOP APIs")
public class BillController {

    private  final BillServiceImpl billService;

    public BillController(BillServiceImpl billService) {
        this.billService = billService;
    }

    @ApiOperation(value = "Calculate Customer total Bill")
    @PostMapping(path = "/calculate")
    public double calculateCustomerBill(@RequestBody Cart cart) {

        return billService.netPayableAmount(cart);
    }
}
