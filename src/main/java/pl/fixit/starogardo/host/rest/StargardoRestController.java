package pl.fixit.starogardo.host.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.fixit.stargardo.common.company.dto.CompanyDto;
import pl.fixit.stargardo.common.company.dto.CompanySubcategoryDto;
import pl.fixit.stargardo.common.company.enums.CompanyCategory;
import pl.fixit.stargardo.common.company.restaurant.dto.CompanySearchCriteriaDto;
import pl.fixit.stargardo.common.order.dto.OrderDto;
import pl.fixit.stargardo.common.order.dto.OrderStatusDto;
import pl.fixit.stargardo.common.product.dto.ProductDto;
import pl.fixit.starogardo.host.company.CompanyServiceStrategy;
import pl.fixit.starogardo.host.order.OrderService;

import java.util.List;

@RestController
class StargardoRestController {

    private final CompanyServiceStrategy companyServiceStrategy;
    private final OrderService orderService;

    public StargardoRestController(@Autowired CompanyServiceStrategy strategy,
                                   @Autowired OrderService orderService) {
        this.companyServiceStrategy = strategy;
        this.orderService = orderService;
    }

    @PostMapping("/companies")
    public List<CompanyDto> getCompanies(@RequestBody(required = false) CompanySearchCriteriaDto searchCriteriaDto) {
        return companyServiceStrategy.selectService(searchCriteriaDto.getCompanyCategory())
                .getCompanies(searchCriteriaDto);
    }

    @GetMapping("/companySubcategories/{companyCategory}")
    public List<CompanySubcategoryDto> getSubcategories(@PathVariable(name = "companyCategory") CompanyCategory companyCategory) {
        return companyServiceStrategy.selectService(companyCategory)
                    .findSubcategories(companyCategory);
    }

    @GetMapping("/companies/{companyId}")
    public List<ProductDto> getCompanyProducts(@PathVariable Long companyId) {
        CompanyCategory companyCategory = getCompanyCategory(companyId);
        return companyServiceStrategy.selectService(companyCategory)
                    .findProducts(companyId);
    }

    @PostMapping("/finishOrder")
    public Long finishOrder(@RequestBody OrderDto orderDto) {
        return orderService.saveOrder(orderDto);
    }

    @GetMapping("/status/{orderId}")
    public OrderStatusDto finishOrder(@PathVariable Long orderId) {
        return null;
    }

    private CompanyCategory getCompanyCategory(Long companyId) {
        return companyServiceStrategy.selectService(CompanyCategory.FOOD)
                .getCompanyCategory(companyId);

    }
}
