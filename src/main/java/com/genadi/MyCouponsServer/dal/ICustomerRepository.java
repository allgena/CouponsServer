package com.genadi.MyCouponsServer.dal;

import com.genadi.MyCouponsServer.bean.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends CrudRepository<Customer,Long> {

}

