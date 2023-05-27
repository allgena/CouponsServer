package com.genadi.MyCouponsServer.dal;

import com.genadi.MyCouponsServer.bean.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {


    Customer findByName(String customerName);
}





