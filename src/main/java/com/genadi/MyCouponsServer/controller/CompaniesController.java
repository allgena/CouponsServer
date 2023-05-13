package com.genadi.MyCouponsServer.controller;

import com.genadi.MyCouponsServer.bean.Company;
import com.genadi.MyCouponsServer.dto.CompanyDto;
import com.genadi.MyCouponsServer.logic.CompaniesLogic;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompaniesController {
    private CompaniesLogic companiesLogic;

//    @Autowired
    public CompaniesController(CompaniesLogic companiesLogic) {
        this.companiesLogic = companiesLogic;
    }

    @PostMapping
    public Company createCompany(@RequestBody Company company) {
        return companiesLogic.save(company);
    }

    @PutMapping
    public Company updateCompany( @RequestBody Company company) {
        if (companiesLogic.getById(company.getId()) == null ) throw new RuntimeException("company not found");
        return companiesLogic.save(company);
    }


    @GetMapping
    public List<CompanyDto> getAllCompanies() {
        return companiesLogic.findAllCompanies();
    }

    @GetMapping("/byPage")
    public Iterable<CompanyDto> getAllByPage(@RequestParam int pageNumber, @RequestParam int amountOfItemsPerPage)  {
        return companiesLogic.findAllByPage(pageNumber, amountOfItemsPerPage);
    }
    @DeleteMapping("/{companyId}")
    public void deleteCompany(@PathVariable("companyId") long id) {
        companiesLogic.deleteCompanyById(id);
    }

    @GetMapping("/{companyId}")
    public CompanyDto getCompanyCoupons(@PathVariable("companyId") long id) {
        return companiesLogic.findCompanyById(id);
    }

    @PostMapping("/createData")
    public Company createAllData(@RequestParam String companyName){
        return  companiesLogic.createCompanyData(companyName);
    }
}
