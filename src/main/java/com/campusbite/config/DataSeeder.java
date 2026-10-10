package com.campusbite.config;

import com.campusbite.entity.FoodItem;
import com.campusbite.repository.FoodItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.math.BigDecimal;
import java.util.List;

@Configuration
public class DataSeeder {
    @Bean
    CommandLineRunner seedFood(FoodItemRepository repo){
        return args -> {
            if(repo.count()==0){
                repo.saveAll(List.of(
                    new FoodItem("Masala Dosa", FoodItem.Category.Breakfast, new BigDecimal("60.00"), true),
                    new FoodItem("Idli Sambar", FoodItem.Category.Breakfast, new BigDecimal("45.00"), true),
                    new FoodItem("Veg Meals", FoodItem.Category.Lunch, new BigDecimal("100.00"), true),
                    new FoodItem("Samosa", FoodItem.Category.Snacks, new BigDecimal("25.00"), true),
                    new FoodItem("Veg Sandwich", FoodItem.Category.Snacks, new BigDecimal("55.00"), true),
                    new FoodItem("Fresh Lime Soda", FoodItem.Category.Drinks, new BigDecimal("35.00"), true)
                ));
            }
        };
    }
}
