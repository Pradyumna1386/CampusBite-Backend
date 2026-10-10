package com.campusbite.service;

import com.campusbite.entity.FoodItem;
import com.campusbite.exception.ResourceNotFoundException;
import com.campusbite.repository.FoodItemRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FoodService {
    private final FoodItemRepository repo;
    public FoodService(FoodItemRepository repo){this.repo=repo;}
    public List<FoodItem> all(){return repo.findAll();}
    public FoodItem create(FoodItem item){return repo.save(item);}
    public FoodItem update(Long id, FoodItem data){
        FoodItem item=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Food item not found: "+id));
        item.setName(data.getName()); item.setCategory(data.getCategory()); item.setPrice(data.getPrice()); item.setAvailable(data.getAvailable());
        return repo.save(item);
    }
    public void delete(Long id){if(!repo.existsById(id)) throw new ResourceNotFoundException("Food item not found: "+id); repo.deleteById(id);}
}
