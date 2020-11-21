package pl.fixit.starogardo.host.order;

import org.springframework.stereotype.Service;
import pl.fixit.stargardo.common.order.dto.OrderDto;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Long saveOrder(OrderDto orderDto) {
        return 6286111L;
    }

}
