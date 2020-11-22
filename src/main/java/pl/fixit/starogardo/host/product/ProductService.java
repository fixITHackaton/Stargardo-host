package pl.fixit.starogardo.host.product;

import pl.fixit.stargardo.common.product.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> findByCompanyId(Long companyId);
}
