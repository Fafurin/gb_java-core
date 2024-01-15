package ru.fafurin.javacore.second.service;

import ru.fafurin.javacore.second.entity.Customer;
import ru.fafurin.javacore.second.entity.Order;
import ru.fafurin.javacore.second.entity.Product;
import ru.fafurin.javacore.second.service.exception.CustomerExistsException;
import ru.fafurin.javacore.second.service.exception.ProductExistsException;
import ru.fafurin.javacore.second.service.exception.QuantityIncorrectException;
import ru.fafurin.javacore.second.repository.CustomerRepository;
import ru.fafurin.javacore.second.repository.ProductRepository;

public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public CustomerService(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    public Order createOrder(Customer customer, Product product, int quantity) throws CustomerExistsException, ProductExistsException, QuantityIncorrectException {
        if (!this.customerRepository.getCustomers().contains(customer)) {
            throw new CustomerExistsException(customer);
        } else if (!this.productRepository.getProducts().contains(product)) {
            throw new ProductExistsException(product);
        } else if (quantity <= 0 || quantity > 50) {
            throw new QuantityIncorrectException();
        } else return new Order(customer, product, quantity);
    }
}

