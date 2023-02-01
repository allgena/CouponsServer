package com.genadi.MyCouponsServer.controller;

import com.genadi.MyCouponsServer.bean.Purchase;
import com.genadi.MyCouponsServer.dal.IPurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchases")
public class PurchasesController {
    private IPurchaseRepository purchaseRepository;


    @Autowired
    public PurchasesController(IPurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;

    }

    @PostMapping
    public Purchase createPurchase(@RequestBody Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    @PutMapping
    public Purchase updatePurchase(@RequestBody Purchase purchase) {
        return purchaseRepository.save(purchase);
    }


    @GetMapping
    public Iterable<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    @DeleteMapping("{purchaseId}")
    public void deletePurchase(@PathVariable("purchaseId") long id) {
        purchaseRepository.deleteById(id);
    }
    @GetMapping("/{purchaseId}")
    public Purchase getById(@PathVariable("purchaseId") long id){
        return purchaseRepository.findById(id).get();
    }

}
