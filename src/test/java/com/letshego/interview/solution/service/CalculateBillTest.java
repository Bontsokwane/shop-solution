package com.letshego.interview.solution.service;

import com.letshego.interview.solution.SolutionApplication;
import com.letshego.interview.solution.model.Cart;
import com.letshego.interview.solution.model.Customer;
import com.letshego.interview.solution.model.CustomerType;
import com.letshego.interview.solution.model.Product;
import com.letshego.interview.solution.service.Impl.BillServiceImpl;
import com.letshego.interview.solution.service.Impl.CustomerServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import static junit.framework.TestCase.assertEquals;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SolutionApplication.class, loader = SpringBootContextLoader.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculateBillTest {

    @InjectMocks
    private BillServiceImpl billService;

    @Test
    public void calculateBillTest() {
        final Customer customer = new Customer("UUT53527", "Tefo", "Bontsokwane", LocalDate.parse("2019-12-31"), CustomerType.LOYAL_CUSTOMER);

        final Product product1 = new Product("SN6674875748", "Oil", 299.20, true);
        final Product product2 = new Product("SN0000000854", "Computer", 100.20, false);
        final List<Product> products = Arrays.asList(new Product[]{product1, product2});

        final Cart cart = new Cart(customer, products);

        assertEquals(384.0, billService.netPayableAmount(cart));
    }
}

