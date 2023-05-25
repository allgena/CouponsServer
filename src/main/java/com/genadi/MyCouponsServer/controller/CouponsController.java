package com.genadi.MyCouponsServer.controller;

import com.genadi.MyCouponsServer.bean.Company;
import com.genadi.MyCouponsServer.bean.Coupon;
import com.genadi.MyCouponsServer.dto.CouponDto;
import com.genadi.MyCouponsServer.logic.CompaniesLogic;
import com.genadi.MyCouponsServer.logic.CouponsLogic;
import com.genadi.MyCouponsServer.logic.PurchasesLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/coupons")
public class CouponsController {
    private CouponsLogic couponsLogic;
    private CompaniesLogic companiesLogic;

    private PurchasesLogic purchasesLogic;
    @Autowired
    public CouponsController(CouponsLogic couponsLogic, CompaniesLogic companiesLogic, PurchasesLogic purchasesLogic) {
        this.couponsLogic = couponsLogic;
        this.companiesLogic = companiesLogic;
        this.purchasesLogic = purchasesLogic;
    }

    @GetMapping
    public Iterable<Coupon> getCoupons() {
        return couponsLogic.findAll();
    }

    @GetMapping("byPage")
    public Iterable<CouponDto> getCouponsByPage(@RequestParam int pageNumber, @RequestParam(defaultValue = "10") int amountOfItemsPerPage) {
        return couponsLogic.findAllByPage(pageNumber, amountOfItemsPerPage);
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

    @GetMapping("/company/{companyId}")
    public List<CouponDto> getCouponsByCompanyId(@PathVariable long companyId) {
        List<CouponDto> coupons = couponsLogic.findCouponsDtoByCompanyId(companyId);
        for (CouponDto coupon: coupons){
            Integer numberOfPurchases= purchasesLogic.findPurchaseCountByCouponId(coupon.getCouponId());
            coupon.setNumberOfPurchases(numberOfPurchases);
        }
        return coupons;
    }
}