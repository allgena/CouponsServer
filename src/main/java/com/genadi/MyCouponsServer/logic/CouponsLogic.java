package com.genadi.MyCouponsServer.logic;

import com.genadi.MyCouponsServer.dal.ICouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponsLogic {
    private ICouponRepository couponRepository;
    @Autowired
    public CouponsLogic(ICouponRepository couponRepository){
        this.couponRepository=couponRepository;
    }
}
