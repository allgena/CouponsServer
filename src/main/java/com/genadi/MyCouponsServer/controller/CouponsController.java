package com.genadi.MyCouponsServer.controller;

import com.genadi.MyCouponsServer.bean.Coupon;
import com.genadi.MyCouponsServer.dal.ICompanyRepository;
import com.genadi.MyCouponsServer.dal.ICouponRepository;
import com.genadi.MyCouponsServer.logic.CouponsLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/coupons")
public class CouponsController {
    private ICouponRepository couponRepository;
    private ICompanyRepository companyRepository;

    @Autowired
    public CouponsController(ICouponRepository couponRepository, ICompanyRepository companyRepository) {
        this.couponRepository = couponRepository;
        this.companyRepository = companyRepository;
    }

    @GetMapping
    public Iterable<Coupon> getCoupons() {
        return couponRepository.findAll();
    }

    @GetMapping("/{couponId}")
    public Coupon getCoupon(@PathVariable("couponId") long id) {
        Optional<Coupon> optionalCoupon =  couponRepository.findById(id);
        if (optionalCoupon.isEmpty()) return null;
        return couponRepository.findById(id).get();
    }

    @PostMapping
    public Coupon createCoupon(@RequestBody Coupon coupon) {
        if (companyRepository.findById(coupon.getCompanyId()).isEmpty()){
            throw new RuntimeException("Company with Id" + coupon.getCompanyId() + " does not exist");
        }
        return couponRepository.save(coupon);
    }

    @PutMapping
    public Coupon updateCoupon(@RequestBody Coupon coupon) {
        return couponRepository.save(coupon);
    }

    @DeleteMapping("/{couponId}")
    public void deleteCoupon(@PathVariable("couponId") long id) {
        couponRepository.deleteById(id);
    }
}
