package com.campusbite.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_number", nullable = true)
    private String orderNumber;

    private String studentName;
    private BigDecimal total;
    private String pickupTime;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private List<OrderItem> items = new ArrayList<>();

    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getOrderNumber(){return orderNumber;} public void setOrderNumber(String orderNumber){this.orderNumber=orderNumber;}
    public String getStudentName(){return studentName;} public void setStudentName(String studentName){this.studentName=studentName;}
    public BigDecimal getTotal(){return total;} public void setTotal(BigDecimal total){this.total=total;}
    public String getPickupTime(){return pickupTime;} public void setPickupTime(String pickupTime){this.pickupTime=pickupTime;}
    public OrderStatus getStatus(){return status;} public void setStatus(OrderStatus status){this.status=status;}
    public List<OrderItem> getItems(){return items;} public void setItems(List<OrderItem> items){this.items=items;}
}
