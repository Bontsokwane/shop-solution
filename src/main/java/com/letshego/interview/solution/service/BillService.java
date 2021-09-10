package com.letshego.interview.solution.service;

import com.letshego.interview.solution.model.Cart;

public interface BillService {

    double netPayableAmount(Cart cart);
}
