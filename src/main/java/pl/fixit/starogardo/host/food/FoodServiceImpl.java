package pl.fixit.starogardo.host.food;

import org.springframework.stereotype.Service;
import pl.fixit.stargardo.common.company.dto.CompanyDto;
import pl.fixit.stargardo.common.company.dto.CompanySubcategoryDto;
import pl.fixit.stargardo.common.company.enums.CompanyCategory;
import pl.fixit.stargardo.common.company.restaurant.dto.CompanySearchCriteriaDto;
import pl.fixit.starogardo.host.company.CompanyServiceImpl;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
class FoodServiceImpl extends CompanyServiceImpl implements FoodService {

    @Override
    public List<CompanyDto> getCompanies(CompanySearchCriteriaDto searchCriteriaDto) {
        return mockCompanyList();
    }

    private List<CompanyDto> mockCompanyList() {
        List<CompanyDto> result = new ArrayList();
        for (int i=0;i<100;i++) {
            CompanyDto dto = new CompanyDto();
            dto.setId(Long.valueOf(i));
            dto.setCompanyCategory(CompanyCategory.parse(i%3));
            dto.setOpeningHour(LocalTime.NOON);
            dto.setClosingHour(LocalTime.MIDNIGHT.minusHours(i%11));
            dto.setName("Knajpa " + i);
            dto.setTelephone("+91" + i);
            dto.setCompanySubcategories(Arrays.asList(new CompanySubcategoryDto(1L, "indyjskie " + i),
                    new CompanySubcategoryDto(3L, "chińskie " + i)));
            dto.setDescription("Description " + i);
            result.add(dto);
        }
        return result;
    }
}
