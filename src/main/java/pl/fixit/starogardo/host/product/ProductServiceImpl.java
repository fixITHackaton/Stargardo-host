package pl.fixit.starogardo.host.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.fixit.stargardo.common.product.dto.ProductDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;

    @Autowired
    ProductMapper mapper;

    @Override
    public List<ProductDto> findByCompanyId(Long companyId) {
        return repository.findByCompanyId(companyId)
                            .stream()
                            .map(entity -> mapper.map(entity))
                            .collect(Collectors.toList());
    }
}
