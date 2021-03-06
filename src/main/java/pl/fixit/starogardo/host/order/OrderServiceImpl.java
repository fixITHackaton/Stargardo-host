package pl.fixit.starogardo.host.order;


import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;
import pl.fixit.stargardo.common.order.dto.OrderDto;
import pl.fixit.stargardo.common.product.dto.ProductDto;
import pl.fixit.starogardo.host.company.Company;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Long saveOrder(OrderDto orderDto) {
        Query query = em.createNativeQuery("insert into ORDERS (ID,CONSUMENT_ADRESS,CONSUMENT_NAME,CONSUMENT_SURNAME,DELIVERY_TIME,DESCRIPTION,PRICE) values(?,?,?,?,?,?,?)");
        query.setParameter(1, orderDto.getId());
        query.setParameter(2, orderDto.getAddress());
        query.setParameter(3, orderDto.getName());
        query.setParameter(4, orderDto.getSurname());
        query.setParameter(5, orderDto.getDeliveryTime());
        query.setParameter(6, orderDto.getNote());
        query.setParameter(7, orderDto.getPrice());
        query.executeUpdate();

        return orderDto.getId();
    }

    @Override
    public List<OrderDto> getCompanyActiveOrders(Long companyId) {

        TypedQuery query = em.createQuery("select a from Orders a where a.restaurantId = ?1", Orders.class);
        query.setParameter(1, companyId);

        return query.getResultList();
    }

//    public List<OrderDto> mockOrders(Long companyId) {
//        List<OrderDto> result = new ArrayList();
//        for (int i=0;i<100;i++) {
//            OrderDto dto = new OrderDto();
//            dto.setId((long) i);
//            dto.setRestaurantId(companyId);
//            dto.setName("Krzysztof " + i);
//            dto.setSurname("Sajkowski " + i);
//            dto.setAddress("ul. Marszałkowska 3/12");
//            List<ProductDto> products = new ArrayList();
//            for (int j=0;j<3;j++) {
//                ProductDto productDto = new ProductDto();
//                productDto.setId((long) j);
//                productDto.setCompanyId(companyId);
//                productDto.setName("Danie " + j);
//                productDto.setPrice((double) j);
//                productDto.setDescription("Mniam mniam " + j);
//                productDto.setAmount((long) j);
//                try {
//                    productDto.setPhoto(loadImage());
//                } catch(IOException e) {
//                }
//                products.add(productDto);
//            }
//            dto.setProducts(products);
//            dto.setNote("Notatka do zamówienia.");
//            dto.setPaymentType(1L);
//        }
//        return result;
//    }

    private String loadImage() throws IOException {
        return Base64
                .encodeBase64String(this.getClass().getClassLoader().getResourceAsStream("zaba.png")
                        .readAllBytes());
    }

}
