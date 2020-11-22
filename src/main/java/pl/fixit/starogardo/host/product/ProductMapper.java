package pl.fixit.starogardo.host.product;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;
import pl.fixit.stargardo.common.product.dto.ProductDto;

@Component
class ProductMapper {

    ProductDto map(Product entity) {
        ProductDto dto = new ProductDto();
        dto.setId(entity.getId());
        dto.setCompanyId(entity.getCompanyId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice() != null ? entity.getPrice().doubleValue() : null);
        dto.setDescription(entity.getDescription());
        byte[] photoByteArray = entity.getProductPicture();
        if (photoByteArray != null) {
            dto.setPhoto(Base64.encodeBase64String(photoByteArray));
        }
        return dto;
    }
}
