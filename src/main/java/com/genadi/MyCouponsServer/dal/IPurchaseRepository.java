package com.genadi.MyCouponsServer.dal;

import com.genadi.MyCouponsServer.bean.Purchase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPurchaseRepository extends CrudRepository<Purchase,Long> {

}
