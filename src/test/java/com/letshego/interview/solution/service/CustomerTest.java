package com.letshego.interview.solution.service;



import com.letshego.interview.solution.SolutionApplication;
import com.letshego.interview.solution.model.Customer;
import com.letshego.interview.solution.model.CustomerType;
import com.letshego.interview.solution.repository.CustomerRepository;
import com.letshego.interview.solution.service.Impl.CustomerServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SolutionApplication.class, loader = SpringBootContextLoader.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerTest {

    @InjectMocks
	private CustomerServiceImpl customerService;

    @Mock
    public CustomerRepository customerRepository;

    @Test
    public void registerNewCustomerTest(){

        final Customer inputCustomer = new Customer("UUT53527", "Tefo","Bontsokwane", LocalDate.parse("2019-12-31"), CustomerType.LOYAL_CUSTOMER);
        final Customer expectedPerson = Mockito.mock(Customer.class);

        when(customerRepository.save(inputCustomer)).thenReturn(expectedPerson);
        final Customer actualPerson = customerService.createCustomer(inputCustomer);

        verify(customerRepository, times(1)).save(inputCustomer);
        assertEquals(expectedPerson, actualPerson);
    }

    @Test
    public void getCustomerByIdTest() {
        final Customer inputCustomer = new Customer("DDDD27", "Kago","Fane", LocalDate.parse("2020-12-01"), CustomerType.AFFILIATE);
        when (customerRepository.findById(inputCustomer.getCustomerId())).thenReturn(java.util.Optional.of(inputCustomer));
        final Customer actualCustomer = customerService.getCustomerById(inputCustomer.getCustomerId()).get();

        verify(customerRepository, times(1)).findById(inputCustomer.getCustomerId());
        assertEquals(inputCustomer, actualCustomer);
    }
}
