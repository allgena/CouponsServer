package com.genadi.MyCouponsServer.dal;

import com.genadi.MyCouponsServer.bean.Coupon;
import com.genadi.MyCouponsServer.dto.CouponsDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICouponRepository extends CrudRepository<Coupon,Long> {


        @Query(value = "select new com.genadi.MyCouponsServer.dto.CouponsDto(c.id, c.couponName, c.company.companyName, c.price,  c.startDate, c.endDate, 0) from Coupon c " +
                "where c.company.id = :companyId")
        List<CouponsDto> findCouponsDtoByCompanyId(long companyId);


        List<Coupon> findByCompanyId(long id);

        void deleteByCompanyId(long companyId);

}
