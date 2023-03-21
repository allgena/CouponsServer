package com.genadi.MyCouponsServer.dal;

import com.genadi.MyCouponsServer.bean.Company;
import com.genadi.MyCouponsServer.dto.CompanyDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ICompanyRepository extends CrudRepository<Company,Long> {

    @Query(value = "select new com.genadi.MyCouponsServer.dto.CompanyDto(c.id, c.companyName) from Company c where c.id = :id")
    CompanyDto findCompanyById(long id);

    @Query(value = "select new com.genadi.MyCouponsServer.dto.CompanyDto(c.id, c.companyName) from Company c")
    List<CompanyDto> findAllCompanies();
}
