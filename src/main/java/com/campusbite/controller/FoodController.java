package com.campusbite.controller;

import com.campusbite.entity.FoodItem;
import com.campusbite.service.FoodService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/food")
@CrossOrigin(origins="http://localhost:5173")
public class FoodController {
    private final FoodService service;
    public FoodController(FoodService service){this.service=service;}
    @GetMapping public List<FoodItem> get(){return service.all();}
    @PostMapping public FoodItem post(@Valid @RequestBody FoodItem item){return service.create(item);}
    @PutMapping("/{id}") public FoodItem put(@PathVariable Long id,@Valid @RequestBody FoodItem item){return service.update(id,item);}
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id){service.delete(id);}
}
