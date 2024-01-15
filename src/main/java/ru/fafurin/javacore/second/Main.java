package ru.fafurin.javacore.second;

import ru.fafurin.javacore.second.entity.Customer;
import ru.fafurin.javacore.second.entity.Product;
import ru.fafurin.javacore.second.enums.Gender;
import ru.fafurin.javacore.second.service.HolidayService;
import ru.fafurin.javacore.second.service.exception.CustomerExistsException;
import ru.fafurin.javacore.second.service.exception.ProductExistsException;
import ru.fafurin.javacore.second.service.exception.QuantityIncorrectException;
import ru.fafurin.javacore.second.repository.CustomerRepository;
import ru.fafurin.javacore.second.repository.OrderRepository;
import ru.fafurin.javacore.second.repository.ProductRepository;
import ru.fafurin.javacore.second.service.CustomerService;

public class Main {
    public static void main(String[] args) {

        Customer customer1 = new Customer("Oleg", 38, "89992984563", Gender.MALE);
        Customer customer2 = new Customer("Lena", 24, "89232914520", Gender.FEMALE);

        CustomerRepository customerRepository = new CustomerRepository();
        customerRepository.setCustomers(new Customer[] {customer1, customer2});

        Product product1 = new Product("TV", 75900);
        Product product2 = new Product("Fridge", 89900);
        Product product3 = new Product("Washer", 69900);
        Product product4 = new Product("Microwave", 27900);
        Product product5 = new Product("Oven", 52900);

        ProductRepository productRepository = new ProductRepository();
        productRepository.setProducts(new Product[] {product1, product2, product3, product4, product5});

        CustomerService customerService = new CustomerService(customerRepository, productRepository);

        OrderRepository orderRepository = new OrderRepository();

//        getResult(orderRepository, customerService, new Customer("Vasia", 48, "89992984563", Gender.MALE), new Product("Washer", 69900), 3);
//
//        getResult(orderRepository, customerService, customer1, new Product("Laptop", 99900), 1);
//
//        getResult(orderRepository, customerService, customer2, product1, -1);
//        getResult(orderRepository, customerService, customer2, product4, 67);
//
//        getResult(orderRepository, customerService, customer1, product2, 1);
//        getResult(orderRepository, customerService, customer2, product3, 2);
//
//        System.out.println(orderRepository.getOrders());

        HolidayService holidayService =  new HolidayService(customerRepository);

        holidayService.congratulateCustomers();

    }

    private static void getResult(OrderRepository orderRepository, CustomerService customerService, Customer customer, Product product, int quantity) {
        try {
            orderRepository.setOrder(customerService.createOrder(customer, product, quantity));
        } catch (CustomerExistsException | ProductExistsException | QuantityIncorrectException e) {
            System.out.println(e.getMessage());
        }
    }

}