package pl.fixit.starogardo.host.food;

import org.springframework.stereotype.Service;
import pl.fixit.stargardo.common.company.dto.CompanyDto;
import pl.fixit.stargardo.common.company.dto.CompanySubcategoryDto;
import pl.fixit.stargardo.common.company.enums.CompanyCategory;
import pl.fixit.stargardo.common.company.restaurant.dto.CompanySearchCriteriaDto;
import pl.fixit.stargardo.common.product.dto.ProductDto;
import pl.fixit.starogardo.host.company.CompanyServiceImpl;

import java.io.IOException;
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

    @Override
    public List<ProductDto> findProducts(Long companyId) {
        return mockProductsList(companyId);
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
            try {
                dto.setImage(loadImage());
            } catch(IOException e) {
            }
            result.add(dto);
        }
        return result;
    }

    private List<ProductDto> mockProductsList(Long companyId) {
        List<ProductDto> result = new ArrayList();
        for (int i=0;i<100;i++) {
            ProductDto dto = new ProductDto();
            dto.setId(Long.valueOf(i));
            dto.setCompanyId(companyId);
            dto.setName("Danie " + i);
            dto.setPrice(Double.valueOf(i));
            dto.setDescription("Mmmmm pysze " + i);
            try {
                dto.setPhoto(loadImage());
            } catch(IOException e) {
            }
            result.add(dto);
        }
        return result;
    }

    private byte[] loadImage() throws IOException {
        return this.getClass().getClassLoader().getResourceAsStream("zaba.png")
                .readAllBytes();
    }
}
