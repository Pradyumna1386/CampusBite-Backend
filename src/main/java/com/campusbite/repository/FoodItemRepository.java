package com.campusbite.repository;
import com.campusbite.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
public interface FoodItemRepository extends JpaRepository<FoodItem, Long> { }
