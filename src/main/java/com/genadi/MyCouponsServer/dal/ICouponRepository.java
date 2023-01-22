package com.genadi.MyCouponsServer.dal;

import com.genadi.MyCouponsServer.bean.Coupon;
import com.genadi.MyCouponsServer.dto.CouponsDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICouponRepository extends CrudRepository<Coupon,Long> {

        @Query(value = "select c.id as couponId, c.coupon_name as couponName, cmp.company_name as companyName from MyCouponsServer.coupons c " +
                "join MyCouponsServer.companies cmp on c.company_id = cmp.id ", nativeQuery = true)
                List<CouponsDto> findByCompanyId(long companyId);

//    List<Coupon> findByCustomerId(long id);
}
