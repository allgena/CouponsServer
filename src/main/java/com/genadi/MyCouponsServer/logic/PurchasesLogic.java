package com.genadi.MyCouponsServer.logic;

import com.genadi.MyCouponsServer.bean.Purchase;
import com.genadi.MyCouponsServer.dal.IPurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PurchasesLogic {
    private IPurchaseRepository purchaseRepository;

    @Autowired
    public PurchasesLogic(IPurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }


    public Integer findPurchaseCountByCouponId(long couponId) {
        return purchaseRepository.countCouponPurchases(couponId);
    }

    public Purchase save(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    public Iterable<Purchase> findAll() {
        return purchaseRepository.findAll();
    }

    public void deleteById(long id) {
        purchaseRepository.deleteById(id);
    }

    public Purchase findById(long id) {
        Optional<Purchase> optionalPurchase = purchaseRepository.findById(id);
        Purchase result = null;
        if (optionalPurchase.isPresent())
            result = optionalPurchase.get();
        return result;
    }
}