package ru.fafurin.javacore.second.service.exception;

import ru.fafurin.javacore.second.entity.Customer;

public class CustomerExistsException extends RuntimeException {

    private Customer customer;
    public CustomerExistsException(Customer customer) {
        super();
        this.customer = customer;
    }

    @Override
    public String getMessage() {
        return "There is no customer with the name " + this.customer.getName();
    }
}
