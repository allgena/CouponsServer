package com.genadi.MyCouponsServer.dal;

import com.genadi.MyCouponsServer.bean.Purchase;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.rmi.ServerException;
import java.util.List;

@Repository
public interface IPurchaseRepository extends CrudRepository<Purchase,Long> {
    void deleteByCouponId(long couponId);

    List<Purchase> findByCouponId(long couponId);
    @Query(value = "select sum(amount_of_purchased) from purchases where coupon_id=:couponId", nativeQuery = true)
    Integer findPurchaseCountByCouponId(long couponId);
}
