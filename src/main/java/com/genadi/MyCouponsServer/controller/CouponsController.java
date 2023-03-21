package com.genadi.MyCouponsServer.controller;

import com.genadi.MyCouponsServer.bean.Coupon;
import com.genadi.MyCouponsServer.dto.CouponDto;
import com.genadi.MyCouponsServer.logic.CompaniesLogic;
import com.genadi.MyCouponsServer.logic.CouponsLogic;
import com.genadi.MyCouponsServer.logic.PurchasesLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{couponId}")
    public Coupon getCoupon(@PathVariable("couponId") long id) {
       return  couponsLogic.getById(id);
    }

    @PostMapping
    public Coupon createCoupon(@RequestBody Coupon coupon) {
        if (coupon.getCompany() == null) {
            throw new RuntimeException("please provide company");
        }
        return couponsLogic.save(coupon);
    }

    @PutMapping
    public Coupon updateCoupon(@RequestBody Coupon coupon) {
        return couponsLogic.save(coupon);
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