package com.eventdriven.order_service.Controller;


import com.eventdriven.base_domains.Order;
import com.eventdriven.base_domains.OrderEvent;
import com.eventdriven.order_service.Kafka.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }


    @PostMapping("/orders")
    public String placeOrder(@RequestBody Order order){
        order.setOrderId(UUID.randomUUID().toString());

        OrderEvent event = new OrderEvent();
        event.setStatus("PENDING");
        event.setMessage("Order is in Pending state");
        event.setOrder(order);
        System.out.println(event.toString());
        orderProducer.message(event);

        return "Order place successfully";
    }

}
