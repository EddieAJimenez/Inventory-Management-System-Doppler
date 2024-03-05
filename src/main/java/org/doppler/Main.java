package org.doppler;

import org.doppler.dao.CustomerDao;
import org.doppler.models.Customer;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");

        CustomerDao customerDao = new CustomerDao();
        //Customer customer = new Customer(1234, "Nelson D", "Calle falsa 123", "nelson@gmail.com", "3167656543");
        //customerDao.save(customer);
        Customer customer = customerDao.getById(1);
        System.out.println(customer.toString());

        customer.setName("Juan Pablo D");
        customerDao.update(customer);

        customerDao.delete(2);

        List<Customer> customers = customerDao.getAll();
        customers.forEach(customer1 -> System.out.println(customer1.toString()));
    }
}