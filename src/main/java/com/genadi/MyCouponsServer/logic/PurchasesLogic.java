package com.genadi.MyCouponsServer.logic;
import com.genadi.MyCouponsServer.bean.Purchase;
import com.genadi.MyCouponsServer.dal.IPurchaseRepository;
import com.genadi.MyCouponsServer.dto.PurchaseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
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

    public Iterable<PurchaseDto> findAllByPage(int pageNumber, int amountOfItemsPerPage) {
        Pageable pageable = PageRequest.of(pageNumber-1, amountOfItemsPerPage);
        List<PurchaseDto> result = new ArrayList<>();
        Page<Purchase> companies = purchaseRepository.findAll(pageable);
        for (Purchase purchase: companies){
            PurchaseDto purchaseDto = new PurchaseDto(purchase);

            result.add(purchaseDto);
        }
        return result;
    }

    public List<Purchase> findByCouponId(long id) {
            return purchaseRepository.findByCouponId(id);
    }

    public void deleteByCouponId(long id) {
        purchaseRepository.deleteByCouponId(id);
    }
}