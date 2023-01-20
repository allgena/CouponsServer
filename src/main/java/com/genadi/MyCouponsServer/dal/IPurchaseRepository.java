package com.genadi.MyCouponsServer.dal;

import com.genadi.MyCouponsServer.bean.Purchase;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.rmi.ServerException;

@Repository
public interface IPurchaseRepository extends CrudRepository<Purchase,Long> {

}
