package com.genadi.MyCouponsServer.controller;

import com.genadi.MyCouponsServer.bean.Coupon;
import com.genadi.MyCouponsServer.dal.ICompanyRepository;
import com.genadi.MyCouponsServer.dal.ICouponRepository;
import com.genadi.MyCouponsServer.dal.IPurchaseRepository;
import com.genadi.MyCouponsServer.dto.CouponsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coupons")
public class CouponsController {
    private ICouponRepository couponRepository;
    private ICompanyRepository companyRepository;

    private IPurchaseRepository purchaseRepository;
    @Autowired
    public CouponsController(ICouponRepository couponRepository, ICompanyRepository companyRepository,IPurchaseRepository purchaseRepository) {
        this.couponRepository = couponRepository;
        this.companyRepository = companyRepository;
        this.purchaseRepository = purchaseRepository;
    }

    @GetMapping
    public Iterable<Coupon> getCoupons() {
        return couponRepository.findAll();
    }

    @GetMapping("/{couponId}")
    public Coupon getCoupon(@PathVariable("couponId") long id) {
        Optional<Coupon> optionalCoupon = couponRepository.findById(id);
        if (optionalCoupon.isEmpty()) return null;
        return couponRepository.findById(id).get();
    }

    @PostMapping
    public Coupon createCoupon(@RequestBody Coupon coupon) {
        if (coupon.getCompany() == null) {
            throw new RuntimeException("please provide company");
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

    @GetMapping("/company/{companyId}")
    public List<CouponsDto> getCouponsByCompanyId(@PathVariable long companyId) {
        List<CouponsDto> coupons = couponRepository.findCouponsDtoByCompanyId(companyId);
        for (CouponsDto coupon: coupons){
            Integer numberOfPurchases= purchaseRepository.findPurchaseCountByCouponId(coupon.getCouponId());
            coupon.setAmountOfPurchases(numberOfPurchases);
        }
        return coupons;
    }
}