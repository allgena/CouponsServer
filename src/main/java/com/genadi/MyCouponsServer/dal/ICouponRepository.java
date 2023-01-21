package com.genadi.MyCouponsServer.dal;

import com.genadi.MyCouponsServer.bean.Coupon;
import com.genadi.MyCouponsServer.dto.CouponsDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICouponRepository extends CrudRepository<Coupon,Long> {
        @Query(value = "select new com.genadi.MyCouponsServer.dto.CouponsDto(c.id, c.couponName, cmp.companyName, c.price, 0) from Coupon c " +
                "LEFT JOIN  Company cmp ON cmp.id = c.companyId "+
                "where c.companyId = :companyId")
                List<CouponsDto> findByCompanyId(long companyId);

//    List<Coupon> findByCustomerId(long id);
}
