package sample.cafekiosk.spring.api.controller.order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sample.cafekiosk.spring.api.controller.order.request.OrderCreateRequest;
import sample.cafekiosk.spring.api.service.order.OrderService;
import sample.cafekiosk.spring.api.service.order.response.OrderResponse;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping(path = "/api/v1/order/new")
    public OrderResponse createOrder(
        @RequestBody OrderCreateRequest orderCreateRequest
    ) {
        LocalDateTime registeredDateTime = LocalDateTime.now();
        return orderService.createOrder(orderCreateRequest,registeredDateTime);
    }
}
