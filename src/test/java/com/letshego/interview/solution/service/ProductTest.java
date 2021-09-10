package com.letshego.interview.solution.service;

import com.letshego.interview.solution.SolutionApplication;
import com.letshego.interview.solution.model.Customer;
import com.letshego.interview.solution.model.CustomerType;
import com.letshego.interview.solution.model.Product;
import com.letshego.interview.solution.repository.CustomerRepository;
import com.letshego.interview.solution.repository.ProductRepository;
import com.letshego.interview.solution.service.Impl.CustomerServiceImpl;
import com.letshego.interview.solution.service.Impl.ProductServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SolutionApplication.class, loader = SpringBootContextLoader.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    public ProductRepository productRepository;

    @Test
    public void createNewProductTest(){

        final Product inputProduct = new Product("SN6674875748","Oil",299.20,true);
        final Product expectedProduct = Mockito.mock(Product.class);

        when(productRepository.save(inputProduct)).thenReturn(expectedProduct);
        final Product actualPro = productService.createProduct(inputProduct);

        verify(productRepository, times(1)).save(inputProduct);
        assertEquals(expectedProduct, actualPro);
    }

    @Test
    public void getProductByIdTest() {
        final Product inputProduct = new Product("SN6674875748","Oil",299.20,true);
        when (productRepository.findById(inputProduct.getProductCode())).thenReturn(java.util.Optional.of(inputProduct));
        final Product actualProduct = productService.getProductById(inputProduct.getProductCode()).get();

        verify(productRepository, times(1)).findById(inputProduct.getProductCode());
        assertEquals(inputProduct, actualProduct);
    }
}
