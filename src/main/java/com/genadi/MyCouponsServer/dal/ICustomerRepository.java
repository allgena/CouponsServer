package com.genadi.MyCouponsServer.dal;

import com.genadi.MyCouponsServer.bean.Customer;
import com.genadi.MyCouponsServer.dto.CustomersDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.rmi.ServerException;

@Repository
public interface ICustomerRepository extends CrudRepository<Customer,Long> {


    }





