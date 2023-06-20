package com.genadi.MyCouponsServer.controller;
import com.genadi.MyCouponsServer.bean.Coupon;
import com.genadi.MyCouponsServer.bean.Customer;
import com.genadi.MyCouponsServer.bean.Purchase;
import com.genadi.MyCouponsServer.dto.PurchaseDto;
import com.genadi.MyCouponsServer.logic.CouponsLogic;
import com.genadi.MyCouponsServer.logic.CustomersLogic;
import com.genadi.MyCouponsServer.logic.PurchasesLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchases")
public class PurchasesController {
    private PurchasesLogic purchasesLogic;
    private CustomersLogic customersLogic;
    private CouponsLogic couponsLogic;


    @Autowired
    public PurchasesController(PurchasesLogic purchasesLogic,CustomersLogic customersLogic, CouponsLogic couponsLogic) {
        this.purchasesLogic = purchasesLogic;
        this.customersLogic = customersLogic;
        this.couponsLogic = couponsLogic;
    }

    @PostMapping()
    public Purchase makePurchase(@RequestParam String customerName, @RequestParam long couponId){
        Customer customer = customersLogic.findByCustomerName(customerName);
        Coupon coupon = couponsLogic.findById(couponId);
        Purchase purchase = new Purchase();
        purchase.setAmountOfPurchased(1);
        purchase.setCoupon(coupon);
        purchase.setCustomer(customer);
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

    public CustomersLogic getCustomersLogic() {
        return customersLogic;
    }

    public void setCustomersLogic(CustomersLogic customersLogic) {
        this.customersLogic = customersLogic;
    }

    public CouponsLogic getCouponsLogic() {
        return couponsLogic;
    }

    public void setCouponsLogic(CouponsLogic couponsLogic) {
        this.couponsLogic = couponsLogic;
    }
}
