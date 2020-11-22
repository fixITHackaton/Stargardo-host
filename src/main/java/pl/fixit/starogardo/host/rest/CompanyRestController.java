package pl.fixit.starogardo.host.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.fixit.stargardo.common.company.dto.CompanySubcategoryDto;
import pl.fixit.stargardo.common.company.enums.CompanyCategory;
import pl.fixit.stargardo.common.order.dto.OrderDto;
import pl.fixit.stargardo.common.product.dto.ProductDto;
import pl.fixit.starogardo.host.order.OrderService;

import java.util.List;

@RestController("/company")
public class CompanyRestController {

    private final OrderService orderService;

    public CompanyRestController(@Autowired OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{companyId}/activeOrders")
    public List<OrderDto> getSubcategories(@PathVariable(name = "companyId") Long companyId) {
        return orderService.getCompanyActiveOrders(companyId);
    }

    @PostMapping("/{companyId}/addProduct")
    public Long addProduct(@PathVariable(name = "companyId") Long companyId, @RequestBody ProductDto productDto) {
        if (!companyId.equals(productDto.getCompanyId())) {
            throw new IllegalArgumentException("Wrong companyId");
        }
        return 1L;
    }

}
