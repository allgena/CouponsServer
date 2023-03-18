package com.genadi.MyCouponsServer.logic;


import com.genadi.MyCouponsServer.bean.Coupon;
import com.genadi.MyCouponsServer.dal.ICouponRepository;
import com.genadi.MyCouponsServer.dto.CouponsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CouponsLogic {
    private ICouponRepository couponRepository;
    @Autowired
    public CouponsLogic(ICouponRepository couponRepository){
        this.couponRepository=couponRepository;
    }

    public List<CouponsDto> getCouponsByCompanyId(long companyId){
        return couponRepository.findCouponsDtoByCompanyId(companyId);
    }

    public Iterable<Coupon> findAll() {
        return couponRepository.findAll();
    }

    public Coupon getById(long id){
        Coupon result = null;
        Optional<Coupon> optionalCoupon = couponRepository.findById(id);
        if (optionalCoupon.isPresent())
            result =  optionalCoupon.get();

        return result;
    }

    public Coupon save(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    public void deleteById(long id) {
        couponRepository.deleteById(id);
    }

    public List<CouponsDto> findCouponsDtoByCompanyId(long companyId) {
        return couponRepository.findCouponsDtoByCompanyId(companyId);
    }
}
