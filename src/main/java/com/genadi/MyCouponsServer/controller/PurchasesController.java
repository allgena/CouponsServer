package com.genadi.MyCouponsServer.controller;

import com.genadi.MyCouponsServer.bean.Purchase;
import com.genadi.MyCouponsServer.dto.PurchaseDto;
import com.genadi.MyCouponsServer.logic.PurchasesLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchases")
public class PurchasesController {
    private PurchasesLogic purchasesLogic;


    @Autowired
    public PurchasesController(PurchasesLogic purchasesLogic) {
        this.purchasesLogic = purchasesLogic;

    }

    @PostMapping
    public Purchase createPurchase(@RequestBody Purchase purchase) {
        return purchasesLogic.save(purchase);
    }

    @PutMapping
    public Purchase updatePurchase(@RequestBody Purchase purchase) {
        return purchasesLogic.save(purchase);
    }


    @GetMapping
    public Iterable<Purchase> getAllPurchases() {
        return purchasesLogic.findAll();
    }

    @GetMapping("/byPage")
    public Iterable<PurchaseDto> getAllByPage(@RequestParam int pageNumber, @RequestParam int amountOfItemsPerPage)  {
        return purchasesLogic.findAllByPage(pageNumber, amountOfItemsPerPage);
    }


    @DeleteMapping("{purchaseId}")
    public void deletePurchase(@PathVariable("purchaseId") long id) {
        purchasesLogic.deleteById(id);
    }
    @GetMapping("/{purchaseId}")
    public Purchase getById(@PathVariable("purchaseId") long id){
        return purchasesLogic.findById(id);
    }

}
