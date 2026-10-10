package com.campusbite.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class OrderItemRequest {
    @NotNull private Long foodId;
    private String name;
    private BigDecimal price;
    @NotNull @Min(1) private Integer quantity;
    public Long getFoodId(){return foodId;} public void setFoodId(Long foodId){this.foodId=foodId;}
    public String getName(){return name;} public void setName(String name){this.name=name;}
    public BigDecimal getPrice(){return price;} public void setPrice(BigDecimal price){this.price=price;}
    public Integer getQuantity(){return quantity;} public void setQuantity(Integer quantity){this.quantity=quantity;}
}
