package com.daniel.delivery.main.repository.foodservice;

import com.daniel.delivery.abstraction.entity.FoodService;
import com.daniel.delivery.abstraction.repository.FoodServiceRepository;
import com.daniel.delivery.main.Infrastructure;
import java.util.List;
import java.util.Optional;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Local
@Infrastructure
public class FoodServiceRepositoryEJB implements FoodServiceRepository{
    @Inject
    private FoodServiceRepositoryJPA foodServiceRepositoryJPA;

    @Override
    public List<FoodService> getAll() {
        return foodServiceRepositoryJPA.getAll();
    }

    @Override
    public List<FoodService> getAll(Integer page, Integer pageSize) {
        return foodServiceRepositoryJPA.getAll(page, pageSize);
    }
    
    @Override
    public FoodService save(FoodService foodService) {
        return foodServiceRepositoryJPA.save(foodService);
    }

    @Override
    public FoodService update(FoodService foodService) {
        return foodServiceRepositoryJPA.update(foodService);
    }

    @Override
    public List<FoodService> getByFoodType(String foodType, Integer page, Integer pageSize) {
        return foodServiceRepositoryJPA.getByFoodType(foodType, page, pageSize);
    }

    @Override
    public Optional<FoodService> getById(String email) {
        return foodServiceRepositoryJPA.getById(email);
    }

    @Override
    public Optional<FoodService> getByEmailAndPassword(String email, String password) {
        return foodServiceRepositoryJPA.getByEmailAndPassword(email, password);
    }
}