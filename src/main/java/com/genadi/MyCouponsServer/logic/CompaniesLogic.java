package com.genadi.MyCouponsServer.logic;

import com.genadi.MyCouponsServer.bean.*;
import com.genadi.MyCouponsServer.dal.*;
import com.genadi.MyCouponsServer.dto.CompanyDto;
import com.genadi.MyCouponsServer.dto.CouponsDto;
import com.genadi.MyCouponsServer.enams.CouponCategory;
import com.genadi.MyCouponsServer.enams.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class CompaniesLogic {
    private ICompanyRepository companyRepository;
    private ICouponRepository couponRepository;
    private IPurchaseRepository purchaseRepository;

    private IUserRepository userRepository;
    private ICustomerRepository customerRepository;
    @Autowired
    public CompaniesLogic(ICustomerRepository customerRepository, ICompanyRepository companyRepository, ICouponRepository couponRepository, IPurchaseRepository purchaseRepository,IUserRepository userRepository){
        this.companyRepository=companyRepository;
        this.couponRepository = couponRepository;
        this.purchaseRepository = purchaseRepository;
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
    }



    private Company getById(long id){
        return companyRepository.findById(id).get();
    }

    public CompanyDto getCompanyCoupons(long id) {
        CompanyDto company = companyRepository.findCompanyById(id);
        return company;
    }

    @Transactional
    public void deleteCompanyById(long companyId){
        List<Coupon> coupons = couponRepository.findByCompanyId(companyId);
        System.out.printf("Number of coupons found " + coupons.size() );
        for (Coupon coupon: coupons){
            System.out.printf("Deleting purchases for coupon id: " + coupon.getId());
            purchaseRepository.deleteByCouponId(coupon.getId());
        }
        couponRepository.deleteByCompanyId(companyId);
        userRepository.deleteByCompanyId(companyId);
        companyRepository.deleteById(companyId);
    }

    @Transactional
    public Company createCompanyData(String companyName){
        Company company=companyRepository.save(new Company(companyName, "Comp1 address", "010101"));
        User companyUser = new User(companyName, UserType.COMPANY, "pass", "phoneNumber");
        companyUser.setCompany(company);
        userRepository.save(companyUser);
        Coupon coupon1 = couponRepository.save(new Coupon("coupon1", CouponCategory.FOOD, 10.0F, "Coupon 1 of "+companyName, Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now().plusDays(2)), company.getId()));
        Coupon coupon2 = couponRepository.save(new Coupon("coupon2", CouponCategory.FOOD, 20.0F, "Coupon 2 of "+companyName, Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now().plusDays(2)), company.getId()));
        coupon1 = couponRepository.save(coupon1);
        coupon2 = couponRepository.save(coupon2);

        purchaseRepository.save(new Purchase(14, coupon1.getId(),2));
        purchaseRepository.save(new Purchase(13, coupon2.getId(),5));
        return company;

    }
}
