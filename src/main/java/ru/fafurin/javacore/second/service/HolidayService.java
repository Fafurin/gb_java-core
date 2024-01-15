package ru.fafurin.javacore.second.service;

import ru.fafurin.javacore.second.entity.Customer;
import ru.fafurin.javacore.second.enums.Gender;
import ru.fafurin.javacore.second.enums.Holiday;
import ru.fafurin.javacore.second.repository.CustomerRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class HolidayService {
    private final CustomerRepository customerRepository;

    public HolidayService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public void congratulateCustomers() {
        if (Objects.equals(Holiday.MARCH8.getValue(), getFormattedDate())) {
            sendMessage(getCustomersByGender(Gender.FEMALE), Holiday.MARCH8.getText());
        } else if (Objects.equals(Holiday.FEBRUARY23.getValue(), getFormattedDate())) {
            sendMessage(getCustomersByGender(Gender.MALE), Holiday.FEBRUARY23.getText());
        } else if (Objects.equals(Holiday.NEW_YEAR.getValue(), getFormattedDate())) {
            sendMessage(customerRepository.getCustomers(), Holiday.NEW_YEAR.getText());
        }
    }

    private List<Customer> getCustomersByGender(Gender gender) {
        return customerRepository.getCustomers().stream()
                .filter(c -> c.getGender().getValue().equals(gender.getValue()))
                .collect(Collectors.toList());
    }

    private String getFormattedDate() {
        return new SimpleDateFormat("dd.MM").format(new Date());
    }

    private void sendMessage(List<Customer> customers, String message) {
        customers.forEach(customer -> System.out.println("Dear, " + customer.getName() + ", " + message));
    }

}
