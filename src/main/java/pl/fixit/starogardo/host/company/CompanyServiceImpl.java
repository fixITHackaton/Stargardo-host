package pl.fixit.starogardo.host.company;

import pl.fixit.stargardo.common.company.dto.CompanyDto;
import pl.fixit.stargardo.common.company.dto.CompanySubcategoryDto;
import pl.fixit.stargardo.common.company.enums.CompanyCategory;
import pl.fixit.stargardo.common.company.restaurant.dto.CompanySearchCriteriaDto;

import java.util.Arrays;
import java.util.List;

public abstract class CompanyServiceImpl implements CompanyService {

    public List<CompanyDto> getCompanies(CompanySearchCriteriaDto searchCriteriaDto) {
        return null;
    }

    public List<CompanySubcategoryDto> findSubcategories(CompanyCategory companyCategory) {
        // TODO - use repository
        return Arrays.asList(new CompanySubcategoryDto(1L, "Indyjskie"),
                new CompanySubcategoryDto(2L, "Włoskie"),
                new CompanySubcategoryDto(3L, "Burgery"),
                new CompanySubcategoryDto(4L, "Tajskie"),
                new CompanySubcategoryDto(5L, "Chińskie"),
                new CompanySubcategoryDto(6L, "Meksykańskie"),
                new CompanySubcategoryDto(7L, "Polskie"),
                new CompanySubcategoryDto(8L, "Sushi"));
    }

    public CompanyCategory getCompanyCategory(Long companyId) {
        return CompanyCategory.FOOD;
    }
}
