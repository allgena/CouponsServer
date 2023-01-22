package com.genadi.MyCouponsServer.logic;

import com.genadi.MyCouponsServer.bean.Company;
import com.genadi.MyCouponsServer.bean.Coupon;
import com.genadi.MyCouponsServer.dal.ICompanyRepository;
import com.genadi.MyCouponsServer.dal.ICouponRepository;
import com.genadi.MyCouponsServer.dto.CompanyDto;
import com.genadi.MyCouponsServer.dto.CouponsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompaniesLogic {
    private ICompanyRepository companyRepository;
    private ICouponRepository couponRepository;
    @Autowired
    public CompaniesLogic(ICompanyRepository companyRepository, ICouponRepository couponRepository){
        this.companyRepository=companyRepository;
        this.couponRepository = couponRepository;
    }



    private Company getById(long id){
        return companyRepository.findById(id).get();
    }

    public CompanyDto getCompanyCoupons(long id) {
        CompanyDto company = companyRepository.findCompanyById(id);
        return company;
    }
}
