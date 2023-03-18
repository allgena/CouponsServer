package com.genadi.MyCouponsServer.logic;

import com.genadi.MyCouponsServer.bean.Customer;
import com.genadi.MyCouponsServer.dal.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomersLogic {
    private ICustomerRepository customerRepository;
    @Autowired
    public CustomersLogic(ICustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }


    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findById(long id) {
        Customer result = null;
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent())
            result = optionalCustomer.get();
        return result;
    }
}
