package pl.fixit.starogardo.host.company;

import pl.fixit.stargardo.common.company.dto.CompanyDto;
import pl.fixit.stargardo.common.company.dto.CompanySubcategoryDto;
import pl.fixit.stargardo.common.company.enums.CompanyCategory;
import pl.fixit.stargardo.common.company.restaurant.dto.CompanySearchCriteriaDto;
import pl.fixit.stargardo.common.product.dto.ProductDto;

import java.util.List;

public interface CompanyService {
    List<CompanyDto> getCompanies(CompanySearchCriteriaDto searchCriteriaDto);

    List<CompanySubcategoryDto> findSubcategories(CompanyCategory companyCategory);

    CompanyCategory getCompanyCategory(Long companyId);

    List<ProductDto> findProducts(Long companyId);
}
