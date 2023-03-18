package com.genadi.MyCouponsServer.controller;

import com.genadi.MyCouponsServer.bean.Customer;
import com.genadi.MyCouponsServer.dal.ICustomerRepository;
import com.genadi.MyCouponsServer.logic.CustomersLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;


@RestController
@RequestMapping("/customers")
public class CustomerController {
    private CustomersLogic customersLogic;

    @Autowired
    public CustomerController(CustomersLogic customersLogic) {
        this.customersLogic = customersLogic;
    }

    @PostMapping()
    public long createCustomer(@RequestBody Customer customer) throws ServerException {
        customer = customersLogic.save(customer);
        return customer.getId();
    }

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") long id) throws ServerException {
        return customersLogic.findById(id);
    }

    @GetMapping()
    public Iterable<Customer> getCustomer() throws ServerException {
        return customersLogic.findAll();
    }

    @PutMapping
    public void updateCustomer(@RequestBody Customer customer) throws ServerException {
        customersLogic.save(customer);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") long id) throws ServerException {
        customersLogic.deleteById(id);
    }
}
