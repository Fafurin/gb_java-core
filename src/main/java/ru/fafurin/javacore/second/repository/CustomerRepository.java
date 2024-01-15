package ru.fafurin.javacore.second.repository;

import ru.fafurin.javacore.second.entity.Customer;

import java.util.ArrayList;
import java.util.Collections;

public class CustomerRepository {
    private ArrayList<Customer> customers = new ArrayList<>();

    public void setCustomers(Customer[] customers) {
        Collections.addAll(this.customers, customers);
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}
