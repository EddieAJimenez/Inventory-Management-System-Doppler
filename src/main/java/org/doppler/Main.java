package org.doppler;

import org.doppler.dao.CustomerDao;
import org.doppler.dao.ProductDao;
import org.doppler.dao.ProductTypeDao;
import org.doppler.models.Customer;
import org.doppler.models.Product;
import org.doppler.models.ProductType;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");

<<<<<<< HEAD
        CustomerDao customerDao = new CustomerDao();
        /*Customer customer = new Customer(1234, "Nelson D", "Calle falsa 123", "nelson@gmail.com", "3167656543");
        customerDao.save(customer);
        Customer customer2 = customerDao.getById(1);
        System.out.println(customer2.toString());
=======
        //CustomerDao customerDao = new CustomerDao();
        //Customer customer = new Customer(1234, "Nelson D", "Calle falsa 123", "nelson@gmail.com", "3167656543");
        //customerDao.save(customer);
        //Customer customer = customerDao.getById(1);
        //System.out.println(customer.toString());
>>>>>>> d4ca7c4cd47e8ff5a72bf467fbea54c4e703be53

        //customer.setName("Juan Pablo D");
        //customerDao.update(customer);

<<<<<<< HEAD
        customerDao.delete(2); */
=======
        //customerDao.delete(2);

        //List<Customer> customers = customerDao.getAll();
        //customers.forEach(customer1 -> System.out.println(customer1.toString()));*/


        ProductDao productDao = new ProductDao();
        //ProductTypeDao productTypeDao = new ProductTypeDao();

        //ProductType productType = new ProductType("Cortinas");
        //productTypeDao.save(productType);

        //Product product = new Product(productType, "Cortina 1", new BigDecimal("500.45"), 5);
        //productDao.save(product);

        //productType = productTypeDao.getById(1);
        //productTypeDao.delete(1);

        Product pr = productDao.getById(1);
        System.out.println(pr.getProductTypeId().getProductTypeName());
>>>>>>> d4ca7c4cd47e8ff5a72bf467fbea54c4e703be53

    }
}