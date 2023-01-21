package com.genadi.MyCouponsServer.logic;


import com.genadi.MyCouponsServer.dal.ICouponRepository;
import com.genadi.MyCouponsServer.dto.CouponsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CouponsLogic {
    private ICouponRepository couponRepository;
    @Autowired
    public CouponsLogic(ICouponRepository couponRepository){
        this.couponRepository=couponRepository;
    }

    public List<CouponsDto> getCouponsByCompanyId(long companyId){
        return couponRepository.findByCompanyId(companyId);
    }

}
