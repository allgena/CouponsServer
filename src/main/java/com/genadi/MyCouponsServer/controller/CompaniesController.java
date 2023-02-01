package com.genadi.MyCouponsServer.controller;

import com.genadi.MyCouponsServer.bean.Company;
import com.genadi.MyCouponsServer.dal.ICompanyRepository;
import com.genadi.MyCouponsServer.dto.CompanyDto;
import com.genadi.MyCouponsServer.logic.CompaniesLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/companies")
public class CompaniesController {
    private ICompanyRepository companyRepository;
    private CompaniesLogic companiesLogic;

    @Autowired
    public CompaniesController(ICompanyRepository companyRepository, CompaniesLogic companiesLogic) {
        this.companyRepository = companyRepository;
        this.companiesLogic = companiesLogic;
    }

    @PostMapping
    public Company createCompany(@RequestBody Company company) {
        return companyRepository.save(company);
    }

    @PutMapping
    public Company updateCompany( @RequestBody Company company) {
        if (!companyRepository.findById(company.getId()).isPresent()) throw new RuntimeException("company not found");
        return companyRepository.save(company);
    }

    @GetMapping("/{companyId}")
    public Company getCompany(@PathVariable("companyId") long id) {
        return companyRepository.findById(id).get();
    }

    @GetMapping
    public Iterable<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @DeleteMapping("/{companyId}")
    public void deleteCompany(@PathVariable("companyId") long id) {
        companiesLogic.deleteCompanyById(id);
    }

    @GetMapping("coupons/{companyId}")
    public CompanyDto getCompanyCoupons(@PathVariable("companyId") long id) {
        return companiesLogic.getCompanyCoupons(id);
    }

    @PostMapping("/createData")
    public Company createAllData(@RequestParam String companyName){
        return  companiesLogic.createCompanyData(companyName);
    }
}
