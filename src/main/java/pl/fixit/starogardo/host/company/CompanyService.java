package pl.fixit.starogardo.host.company;

import pl.fixit.stargardo.common.company.dto.CompanyDto;
import pl.fixit.stargardo.common.company.restaurant.dto.CompanySearchCriteriaDto;

import java.util.List;

public interface CompanyService {
    List<CompanyDto> getCompanies(CompanySearchCriteriaDto searchCriteriaDto);
}
