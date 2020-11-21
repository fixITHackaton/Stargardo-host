package pl.fixit.starogardo.host.company;

import pl.fixit.stargardo.common.company.dto.CompanyDto;
import pl.fixit.stargardo.common.company.restaurant.dto.CompanySearchCriteriaDto;

import java.util.List;

public abstract class CompanyServiceImpl implements CompanyService {
    public List<CompanyDto> getCompanies(CompanySearchCriteriaDto searchCriteriaDto) {
        return null;
    }
}
