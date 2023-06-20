package com.genadi.MyCouponsServer.dal;

import com.genadi.MyCouponsServer.bean.Company;
import com.genadi.MyCouponsServer.dto.CompanyDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ICompanyRepository extends JpaRepository<Company,Long> {

    @Query(value = "select new com.genadi.MyCouponsServer.dto.CompanyDto(c.id, c.companyName, c.phoneNumber,c.address) from Company c where c.id = :id")
    CompanyDto findCompanyById(long id);

    @Query(value = "select new com.genadi.MyCouponsServer.dto.CompanyDto(c.id, c.companyName, c.phoneNumber,c.address) from Company c")
    List<CompanyDto> findAllCompanies();

    Company findByCompanyName(String companyName);

    @Query("select companyName from Company")
    List<String> findCompaniesNames();
}
