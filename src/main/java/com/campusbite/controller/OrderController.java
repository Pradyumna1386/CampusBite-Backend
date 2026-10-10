package com.campusbite.controller;

import com.campusbite.dto.CreateOrderRequest;
import com.campusbite.dto.StatusRequest;
import com.campusbite.entity.Order;
import com.campusbite.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins="http://localhost:5173")
public class OrderController {
    private final OrderService service;
    public OrderController(OrderService service){this.service=service;}
    @GetMapping public List<Order> get(){return service.all();}
    @PostMapping public Order post(@Valid @RequestBody CreateOrderRequest request){return service.create(request);}
    @PutMapping("/{id}/status") public Order status(@PathVariable Long id,@RequestBody StatusRequest request){return service.updateStatus(id,request.getStatus());}
}
