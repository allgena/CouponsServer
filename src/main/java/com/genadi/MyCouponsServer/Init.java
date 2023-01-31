package com.genadi.MyCouponsServer;

import com.genadi.MyCouponsServer.bean.Company;
import com.genadi.MyCouponsServer.bean.Coupon;
import com.genadi.MyCouponsServer.dal.ICompanyRepository;
import com.genadi.MyCouponsServer.dal.ICouponRepository;
import com.genadi.MyCouponsServer.enams.CouponCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
public class Init implements CommandLineRunner {
    @Value(("${spring.jpa.hibernate.ddl-auto:update}"))
    private String initDb;

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
        Company comp1=companyRepository.save(new Company("comp1", "Comp1 address", "010101"));
        Company comp2 = companyRepository.save(new Company("comp2", "Comp2 address", "020202"));

        Coupon coupon1 = couponRepository.save(new Coupon("coupon1", CouponCategory.FOOD, 10.0F, "Coupon 1 of company 1", Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now().plusDays(2)), comp1));
        Coupon coupon2 = couponRepository.save(new Coupon("coupon2", CouponCategory.FOOD, 10.0F, "Coupon 2 of company 1", Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now().plusDays(2)), comp1));
    }

}
