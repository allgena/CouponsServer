package com.genadi.MyCouponsServer.dal;

import com.genadi.MyCouponsServer.bean.Coupon;
import com.genadi.MyCouponsServer.dto.CouponsDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICouponRepository extends CrudRepository<Coupon,Long> {

//        @Query(value = "select c.id as couponId, c.coupon_name as couponName, cmp.company_name as companyName from mycouponsserver.coupons c "
//                + "join mycouponsserver.companies cmp on c.company_id = cmp.id ", nativeQuery = true)
//                List<CouponsDto> findByCompanyId(long companyId);
        @Query(value = "select new com.genadi.MyCouponsServer.dto.CouponsDto(c.id, c.couponName, cmp.companyName, c.price,  c.startDate, c.endDate, 0) from Coupon c " +
                "LEFT JOIN  Company cmp ON cmp.id = c.companyId "+
                "where c.companyId = :companyId")
        List<CouponsDto> findCouponsDtoByCompanyId(long companyId);


        List<Coupon> findByCompanyId(long id);

        void deleteByCompanyId(long companyId);

}
