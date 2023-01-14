package com.genadi.MyCouponsServer.dal;

import com.genadi.MyCouponsServer.bean.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompanyRepository extends CrudRepository<Company,Long> {
}
