package com.campusbite.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

public class CreateOrderRequest {
    @NotBlank private String studentName;
    @NotBlank private String pickupTime;
    @NotEmpty @Valid private List<OrderItemRequest> items;
    public String getStudentName(){return studentName;} public void setStudentName(String studentName){this.studentName=studentName;}
    public String getPickupTime(){return pickupTime;} public void setPickupTime(String pickupTime){this.pickupTime=pickupTime;}
    public List<OrderItemRequest> getItems(){return items;} public void setItems(List<OrderItemRequest> items){this.items=items;}
}
