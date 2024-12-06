package Online.Courier.Service.ServicesImpl;

import Online.Courier.Service.Entity.Order;
import Online.Courier.Service.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Order placeOrder(Order order){
        return orderRepository.save(order);
    }

    public List<Order> getOrdersByUserId(Long userId){
      return orderRepository.findByUserId(userId);
    }

    public void updateOrderStatus(Long orderId,Order.Status status){
        Order order=orderRepository.findById(orderId).orElseThrow();
        order.setStatus(status);
        orderRepository.save(order);
    }
}
