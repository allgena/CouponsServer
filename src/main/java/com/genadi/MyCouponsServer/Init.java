package com.genadi.MyCouponsServer;

import com.genadi.MyCouponsServer.bean.Customer;
import com.genadi.MyCouponsServer.bean.User;
import com.genadi.MyCouponsServer.dal.ICompanyRepository;
import com.genadi.MyCouponsServer.dal.ICouponRepository;
import com.genadi.MyCouponsServer.dal.ICustomerRepository;
import com.genadi.MyCouponsServer.enams.UserType;
import com.genadi.MyCouponsServer.logic.CompaniesLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Init implements CommandLineRunner {
    @Value(("${spring.jpa.hibernate.ddl-auto:update}"))
    private String initDb;

    @Autowired
    CompaniesLogic companiesLogic;

    @Autowired
    ICustomerRepository customerRepository;

    @Autowired
    ICompanyRepository companyRepository;

    @Autowired
    ICouponRepository couponRepository;


    @Override
    public void run(String... strings) throws Exception {

        if (initDb.equals("create")) {
            loadStartupData();
        }
    }

    private void loadStartupData() {
        User user1 = new User("customer1", UserType.CUSTOMER, "pass", "phoneNumber");
        User user2 = new User("customer2", UserType.CUSTOMER, "pass", "phoneNumber");
        Customer customer1 = new Customer(user1.getUserName(), user1, "address", "phone");
        Customer customer2 = new Customer(user2.getUserName(), user2, "address", "phone");
        customerRepository.save(customer1);
        customerRepository.save(customer2);

       companiesLogic.createCompanyData("Test1");
       companiesLogic.createCompanyData("Test2");
       companiesLogic.createCompanyData("Test3");
    }

}
