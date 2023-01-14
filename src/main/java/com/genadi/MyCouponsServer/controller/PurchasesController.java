package com.genadi.MyCouponsServer.controller;

import com.genadi.MyCouponsServer.bean.Coupon;
import com.genadi.MyCouponsServer.bean.Purchase;
import com.genadi.MyCouponsServer.dal.IPurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchases")
public class PurchasesController {
    private IPurchaseRepository purchaseRepository;

    @Autowired
    public PurchasesController(IPurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @PostMapping("purchase")
    public long createPurchase(Purchase purchase) {
        purchaseRepository.save(purchase);
        return purchase.getId();
    }

    @PutMapping("/{purchaseId")
    public void updatePurchase(@PathVariable("purchaseId") @RequestBody Purchase purchase) {
        purchaseRepository.save(purchase);
    }

    @GetMapping("/{purchaseId")
    public Purchase getPurchase(@PathVariable("purchaseId") long id) {
        return purchaseRepository.findById(id).get();
    }

    @GetMapping
    public Iterable<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    @DeleteMapping("/{purchaseId}")
    public void deletePurchase(@PathVariable("purchaseId") long id) {
        purchaseRepository.deleteById(id);
    }

}
