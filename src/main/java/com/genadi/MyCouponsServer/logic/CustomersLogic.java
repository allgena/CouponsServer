package com.genadi.MyCouponsServer.logic;

import com.genadi.MyCouponsServer.bean.Customer;
import com.genadi.MyCouponsServer.dal.ICustomerRepository;
import com.genadi.MyCouponsServer.dal.IPurchaseRepository;
import com.genadi.MyCouponsServer.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomersLogic {
    private ICustomerRepository customerRepository;
    private IPurchaseRepository purchaseRepository;
    @Autowired
    public CustomersLogic(ICustomerRepository customerRepository,IPurchaseRepository purchaseRepository){
        this.customerRepository=customerRepository;
        this.purchaseRepository = purchaseRepository;
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

    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    public void deleteById(long id) {
        customerRepository.deleteById(id);
    }

    public Iterable<CustomerDto> findAllByPage(int pageNumber, int amountOfItemsPerPage) {
        Pageable pageable = PageRequest.of(pageNumber-1, amountOfItemsPerPage);
        List<CustomerDto> result = new ArrayList<>();
        Page<Customer> customers = customerRepository.findAll(pageable);
        for (Customer customer: customers){
            CustomerDto customerDto = new CustomerDto(customer);
            Integer customerPurchases = purchaseRepository.countCompanyPurchases(customer.getId());
            customerDto.setAmountOfPurchases(customerPurchases);
            result.add(customerDto);
        }
        return result;
    }
}
