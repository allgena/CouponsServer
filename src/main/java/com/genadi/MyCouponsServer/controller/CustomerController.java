package com.genadi.MyCouponsServer.controller;

import com.genadi.MyCouponsServer.bean.Customer;
import com.genadi.MyCouponsServer.dal.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;


@RestController
@RequestMapping("/customers")
public class CustomerController {
    private ICustomerRepository customerRepository;

    @Autowired
    public CustomerController(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping()
    public long createCustomer(@RequestBody Customer customer) throws ServerException {
        customer = customerRepository.save(customer);
        return customer.getId();
    }

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") long id) throws ServerException {
        return customerRepository.findById(id).get();
    }

    @GetMapping()
    public Iterable<Customer> getCustomer() throws ServerException {
        return customerRepository.findAll();
    }

    @PutMapping
    public void updateCustomer(@RequestBody Customer customer) throws ServerException {
        customerRepository.save(customer);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") long id) throws ServerException {
        customerRepository.deleteById(id);
    }
}
