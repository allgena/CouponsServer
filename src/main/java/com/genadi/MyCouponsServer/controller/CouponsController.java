package com.genadi.MyCouponsServer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.genadi.MyCouponsServer.bean.Company;
import com.genadi.MyCouponsServer.bean.Coupon;
import com.genadi.MyCouponsServer.dto.CouponDto;
import com.genadi.MyCouponsServer.dto.SuccessfulLoginData;
import com.genadi.MyCouponsServer.enams.UserType;
import com.genadi.MyCouponsServer.logic.CompaniesLogic;
import com.genadi.MyCouponsServer.logic.CouponsLogic;
import com.genadi.MyCouponsServer.logic.PurchasesLogic;
import com.genadi.MyCouponsServer.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.sql.Date;

@RestController
@RequestMapping("/coupons")
public class CouponsController {
    private CouponsLogic couponsLogic;
    private CompaniesLogic companiesLogic;

    private PurchasesLogic purchasesLogic;
    private JwtUtils jwtUtils;
    @Autowired
    public CouponsController(CouponsLogic couponsLogic, CompaniesLogic companiesLogic, PurchasesLogic purchasesLogic,JwtUtils jwtUtils) {
        this.couponsLogic = couponsLogic;
        this.companiesLogic = companiesLogic;
        this.purchasesLogic = purchasesLogic;
        this.jwtUtils = jwtUtils;
    }

    @GetMapping
    public Iterable<Coupon> getCoupons() {
        return couponsLogic.findAll();
    }

    @GetMapping("byPage")
    public Iterable<CouponDto> getCouponsByPage(@RequestParam int pageNumber, @RequestParam(defaultValue = "10") int amountOfItemsPerPage, @RequestParam(required = false) String category) throws JsonProcessingException {
        String jwtToken= ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization");
        UserType userType = UserType.CUSTOMER;
        SuccessfulLoginData userData = null;
        if (jwtToken != null && !jwtToken.isEmpty() && !jwtToken.equals("null"))
        {
            userData = jwtUtils.decodeUserDetails();
            userType = userData.getUserType();
        }

        if (category== null || category.equalsIgnoreCase("All"))
            if (userType.equals(UserType.COMPANY))
            {
                return couponsLogic.getCouponsByCompanyId(pageNumber, amountOfItemsPerPage, userData.getCompanyId());
            }
            else return couponsLogic.findAllByPage(pageNumber, amountOfItemsPerPage);
        else
            return  couponsLogic.findCouponsDtoByCategory(category, pageNumber,amountOfItemsPerPage);
    }

    @GetMapping("/{couponId}")
    public Coupon getCoupon(@PathVariable("couponId") long id) {
       return  couponsLogic.getById(id);
    }

    @PostMapping
    public void createCoupon(@RequestBody CouponDto couponDto) {
        Company company = companiesLogic.findCompanyByName(couponDto.getCompanyName());
        if (company == null) {
            throw new RuntimeException("please provide company");
        }
        Coupon coupon = new Coupon();
        coupon.setId(couponDto.getCouponId());
        coupon.setCouponName(couponDto.getCouponName());
        coupon.setCategory(couponDto.getCategory());
        coupon.setDescription(couponDto.getDescription());
        coupon.setPrice(couponDto.getPrice());
        coupon.setCompany(company);
        coupon.setStartDate(new Date(couponDto.getStartDate().getTime()));
        coupon.setEndDate(new Date(couponDto.getEndDate().getTime()));
        coupon.setImageURL(couponDto.getImageURL());
        couponsLogic.save(coupon);
    }

    @PutMapping
    public void updateCoupon(@RequestBody CouponDto coupon) {
        createCoupon(coupon);
    }

    @DeleteMapping("/{couponId}")
    public void deleteCoupon(@PathVariable("couponId") long id) {
        couponsLogic.deleteById(id);
    }

}