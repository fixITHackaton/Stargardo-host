package pl.fixit.starogardo.host.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.fixit.stargardo.common.company.enums.CompanyCategory;
import pl.fixit.starogardo.host.food.FoodService;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class CompanyServiceStrategy {

    private Map<CompanyCategory, CompanyService> companyServicesMap = new HashMap();

    FoodService foodService;

    @PostConstruct
    public void loadMap() {
        companyServicesMap.put(CompanyCategory.FOOD, foodService);
        companyServicesMap.put(CompanyCategory.RETAIL, null);
        companyServicesMap.put(CompanyCategory.SERVICES, null);
    }

    public CompanyServiceStrategy(@Autowired FoodService foodService) {
        this.foodService = foodService;
    }

    public CompanyService selectService(CompanyCategory companyCategory) {
        return Optional.ofNullable(companyServicesMap.get(companyCategory))
                    .orElseThrow(() -> new IllegalArgumentException("Unrecognized company category"));
    }
}
