package com.genadi.MyCouponsServer.logic;

import com.genadi.MyCouponsServer.dal.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomersLogic {
    private ICustomerRepository customerRepository;
    @Autowired
    public CustomersLogic(ICustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }


}
