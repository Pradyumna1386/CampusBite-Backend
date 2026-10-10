package com.campusbite.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "food_items")
public class FoodItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank private String name;
    @Enumerated(EnumType.STRING) @NotNull private Category category;
    @DecimalMin("0.01") @NotNull private BigDecimal price;
    @NotNull private Boolean available = true;

    public enum Category { All, Breakfast, Lunch, Snacks, Drinks }
    public FoodItem() {}
    public FoodItem(String name, Category category, BigDecimal price, Boolean available) { this.name=name; this.category=category; this.price=price; this.available=available; }
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getName(){return name;} public void setName(String name){this.name=name;}
    public Category getCategory(){return category;} public void setCategory(Category category){this.category=category;}
    public BigDecimal getPrice(){return price;} public void setPrice(BigDecimal price){this.price=price;}
    public Boolean getAvailable(){return available;} public void setAvailable(Boolean available){this.available=available;}
}
