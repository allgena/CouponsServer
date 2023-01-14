package com.genadi.MyCouponsServer.logic;

import com.genadi.MyCouponsServer.dal.IPurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchasesLogic {
    private IPurchaseRepository purchaseRepository;
    @Autowired
    public PurchasesLogic(IPurchaseRepository purchaseRepository){
        this.purchaseRepository=purchaseRepository;
    }
}
