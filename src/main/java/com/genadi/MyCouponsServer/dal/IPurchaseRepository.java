package com.genadi.MyCouponsServer.dal;

import com.genadi.MyCouponsServer.bean.Purchase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPurchaseRepository extends JpaRepository<Purchase,Long> {
    void deleteByCouponId(long couponId);

    List<Purchase> findByCouponId(long couponId);
    @Query(value = "select sum(amount_of_purchased) from purchases p join coupons c on c.id = p.coupon_id where c.company_id=:companyId", nativeQuery = true)
    Integer countCompanyPurchases(long companyId);

    @Query(value = "select sum(amount_of_purchased) from purchases p join coupons c on c.id = p.coupon_id where c.id=:couponId", nativeQuery = true)
    Integer countCouponPurchases(long couponId);

    @Query(value = "select sum(amount_of_purchased) from purchases p join customers c on c.id = p.customer_id where c.customer_id=:customerId", nativeQuery = true)
    Integer countCustomerPurchases(long customerId);

    @Query(value = "select * from purchases p join coupons c on c.id = p.coupon_id where c.company_id=:companyId", nativeQuery = true)
    Page<Purchase> findByCompanyId(long companyId, Pageable pageable);
}
