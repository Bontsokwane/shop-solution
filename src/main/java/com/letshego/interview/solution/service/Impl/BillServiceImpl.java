package com.letshego.interview.solution.service.Impl;

import com.letshego.interview.solution.model.*;
import com.letshego.interview.solution.service.BillService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class BillServiceImpl implements BillService {

    private static final int DISCOUNT_PER_HUNDRED = 5;

    @Override
    public double netPayableAmount(Cart cart) {


        double totalPrice = 0;

        double discountPercentage = getDiscountPercentage(cart.getCustomer());
        for(Product product: cart.getProducts()) {
            if(product.isDiscountable()){
                totalPrice = totalPrice - ((discountPercentage/100) * product.getProductPrice());
            }
            totalPrice = totalPrice + product.getProductPrice();
        }
        return Math.round(totalPrice - getTotalAmountDiscount(totalPrice));
    }


    private double getTotalAmountDiscount(double totalDiscountedPrice) {
        return Math.floor(totalDiscountedPrice / 100) * DISCOUNT_PER_HUNDRED;
    }

    private double getDiscountPercentage(Customer customer) {
        CustomerType customerType = customer.getCustomerType();
        LocalDate date = LocalDate.now();
        Period period = Period.between(LocalDate.of(customer.getEffectiveDate().getYear(),customer.getEffectiveDate().getMonth(),customer.getEffectiveDate().getDayOfMonth()), date);

        if(customerType == CustomerType.AFFILIATE || customerType == CustomerType.EMPLOYEE || customerType == CustomerType.LOYAL_CUSTOMER) {
            if(customerType == CustomerType.LOYAL_CUSTOMER && period.getYears()<= 2){
               return 0;
            }
            return customerType.getDiscountPercentage();
        }
        return 0;
    }


}
