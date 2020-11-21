package pl.fixit.starogardo.host.order;

import pl.fixit.stargardo.common.order.dto.OrderDto;

import java.util.List;

public interface OrderService {
    Long saveOrder(OrderDto orderDto);

    List<OrderDto> getCompanyActiveOrders(Long companyId);
}
