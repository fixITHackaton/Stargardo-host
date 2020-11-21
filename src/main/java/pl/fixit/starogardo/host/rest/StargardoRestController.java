package pl.fixit.starogardo.host.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.fixit.stargardo.common.company.dto.CompanyDto;
import pl.fixit.stargardo.common.company.restaurant.dto.CompanySearchCriteriaDto;
import pl.fixit.starogardo.host.company.CompanyServiceStrategy;

import java.util.List;

@RestController
class StargardoRestController {

    private CompanyServiceStrategy companyServiceStrategy;

    public StargardoRestController(@Autowired CompanyServiceStrategy strategy) {
        companyServiceStrategy = strategy;
    }

    @PostMapping("/companies")
    public List<CompanyDto> getCompanies(@RequestBody(required = false) CompanySearchCriteriaDto searchCriteriaDto) {
        return companyServiceStrategy.selectService(searchCriteriaDto.getCompanyCategory())
                .getCompanies(searchCriteriaDto);
    }

}
