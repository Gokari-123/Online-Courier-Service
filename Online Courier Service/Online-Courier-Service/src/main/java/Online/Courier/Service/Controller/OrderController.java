package Online.Courier.Service.Controller;

import Online.Courier.Service.Entity.Order;
import Online.Courier.Service.ServicesImpl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/place")
    public Order placeOrder(@RequestBody Order order) {

        return orderService.placeOrder(order);
    }

    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUser(@PathVariable Long userId) {
        return orderService.getOrdersByUserId(userId);
    }

    @PatchMapping("/{orderId}/status")
        public void updateOrderStatus(@PathVariable Long orderId, @RequestParam Order.Status status){
        orderService.updateOrderStatus(orderId, status);
        }
    }
