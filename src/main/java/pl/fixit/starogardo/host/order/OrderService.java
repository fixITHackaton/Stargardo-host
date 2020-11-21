package pl.fixit.starogardo.host.order;

import pl.fixit.stargardo.common.order.dto.OrderDto;

public interface OrderService {
    Long saveOrder(OrderDto orderDto);
}
