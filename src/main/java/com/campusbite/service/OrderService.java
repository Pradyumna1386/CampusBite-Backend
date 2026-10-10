package com.campusbite.service;

import com.campusbite.dto.CreateOrderRequest;
import com.campusbite.dto.OrderItemRequest;
import com.campusbite.entity.*;
import com.campusbite.exception.InvalidStatusException;
import com.campusbite.exception.ResourceNotFoundException;
import com.campusbite.repository.FoodItemRepository;
import com.campusbite.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepo; private final FoodItemRepository foodRepo;
    public OrderService(OrderRepository orderRepo, FoodItemRepository foodRepo){this.orderRepo=orderRepo;this.foodRepo=foodRepo;}
    public List<Order> all(){return orderRepo.findAllByOrderByIdDesc();}
    @Transactional
    public Order create(CreateOrderRequest request){
        Order order=new Order(); order.setStudentName(request.getStudentName().trim()); order.setPickupTime(request.getPickupTime()); order.setStatus(OrderStatus.PENDING);
        BigDecimal total=BigDecimal.ZERO; List<OrderItem> items=new ArrayList<>();
        for(OrderItemRequest input:request.getItems()){
            FoodItem food=foodRepo.findById(input.getFoodId()).orElseThrow(()->new ResourceNotFoundException("Food item not found: "+input.getFoodId()));
            if(!Boolean.TRUE.equals(food.getAvailable())) throw new IllegalArgumentException(food.getName()+" is currently unavailable.");
            BigDecimal line=food.getPrice().multiply(BigDecimal.valueOf(input.getQuantity())); total=total.add(line);
            items.add(new OrderItem(food.getName(), food.getPrice(), input.getQuantity()));
        }
        order.setItems(items); order.setTotal(total); order.setOrderNumber(null);
        order=orderRepo.save(order);
        order.setOrderNumber(String.format("CB%03d", order.getId()));
        return orderRepo.save(order);
    }
    public Order updateStatus(Long id,String raw){
        Order order=orderRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Order not found: "+id));
        OrderStatus status; try {status=OrderStatus.valueOf(raw == null ? "" : raw.trim().toUpperCase());} catch(Exception e){throw new InvalidStatusException();}
        order.setStatus(status); return orderRepo.save(order);
    }
}
