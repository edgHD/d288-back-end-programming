package com.example.demo.config;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class BootstrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootstrapData(CustomerRepository customerRepository,
                         DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) {
        System.out.println("Bootstrapping customer data...");

        Customer customer1 = new Customer();
        customer1.setFirstName("Edgar");
        customer1.setLastName("Dolz");
        customer1.setAddress("123 Main Street");
        customer1.setPostal_code("12345");
        customer1.setPhone("1-234-567-8901");
        customer1.setCreate_date(new Date());

        Division division29 = divisionRepository.findById(29L)
                .orElseThrow(() -> new RuntimeException("Division not found"));
        customer1.setDivision(division29);

        Customer customer2 = new Customer();
        customer2.setFirstName("Son");
        customer2.setLastName("Goku");
        customer2.setAddress("439 East District");
        customer2.setPostal_code("98765");
        customer2.setPhone("1-987-654-3210");
        customer2.setCreate_date(new Date());

        Division division4 = divisionRepository.findById(4L)
                .orElseThrow(() -> new RuntimeException("Division not found"));
        customer2.setDivision(division4);

        Customer customer3 = new Customer();
        customer3.setFirstName("Emma");
        customer3.setLastName("Watson");
        customer3.setAddress("742 Evergreen Terrace");
        customer3.setPostal_code("54321");
        customer3.setPhone("1-555-123-4567");
        customer3.setCreate_date(new Date());

        Division division10 = divisionRepository.findById(10L)
                .orElseThrow(() -> new RuntimeException("Division not found"));
        customer3.setDivision(division10);

        Customer customer4 = new Customer();
        customer4.setFirstName("James");
        customer4.setLastName("Rodriguez");
        customer4.setAddress("123 Soccer Street");
        customer4.setPostal_code("33445");
        customer4.setPhone("1-305-789-0123");
        customer4.setCreate_date(new Date());

        Division division15 = divisionRepository.findById(15L)
                .orElseThrow(() -> new RuntimeException("Division not found"));
        customer4.setDivision(division15);

        Customer customer5 = new Customer();
        customer5.setFirstName("Akiko");
        customer5.setLastName("Tanaka");
        customer5.setAddress("567 Cherry Blossom Ave");
        customer5.setPostal_code("10001");
        customer5.setPhone("1-212-555-9999");
        customer5.setCreate_date(new Date());

        Division division20 = divisionRepository.findById(20L)
                .orElseThrow(() -> new RuntimeException("Division not found"));
        customer5.setDivision(division20);


        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);
        customerRepository.save(customer5);

        System.out.println("Number of customers loaded: " + customerRepository.count());
    }
}