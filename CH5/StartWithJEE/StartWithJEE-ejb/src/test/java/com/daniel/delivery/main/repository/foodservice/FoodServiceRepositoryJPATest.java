
package com.daniel.delivery.main.repository.foodservice;

import com.daniel.delivery.abstraction.entity.FoodService;
import com.daniel.delivery.abstraction.entity.User;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FoodServiceRepositoryJPATest {
    
    @Mock
    private EntityManager entityManager;
    
    @Mock
    private TypedQuery typedQuery;
    
    @InjectMocks
    private FoodServiceRepositoryJPA foodServiceRepositoryJPA;

    @Test
    public void save() {
        User user = new User("email1@email.com", "pass1");
        FoodService foodService = new FoodService("email1@email.com", "Pizzas 25", "Street 89", "PIZZA", 100, true, user, Collections.emptyList());
        
        UserData userData = new UserData();
        userData.setEmail(user.getEmail());
        userData.setPassword(user.getPassword());
        
        FoodServiceData foodServiceData = new FoodServiceData();
        foodServiceData.setActive(foodService.getActive());
        foodServiceData.setAddress(foodService.getAddress());
        foodServiceData.setDeliveryFee(foodService.getDeliveryFee());
        foodServiceData.setEmail(foodService.getEmail());
        foodServiceData.setFoodType(foodService.getFoodType());
        foodServiceData.setName(foodService.getName());
        foodServiceData.setUserData(userData);
        
        foodServiceRepositoryJPA.save(foodService);
        
        verify(entityManager).persist(foodServiceData);
    }
    
    @Test
    public void update() {
        User user = new User("email1@email.com", "pass1");
        FoodService foodService = new FoodService("email1@email.com", "Pizzas 25", "Street 89", "PIZZA", 100, true, user, Collections.emptyList());
        
        UserData userData = new UserData();
        userData.setEmail(user.getEmail());
        userData.setPassword(user.getPassword());
        
        FoodServiceData foodServiceData = new FoodServiceData();
        foodServiceData.setActive(foodService.getActive());
        foodServiceData.setAddress(foodService.getAddress());
        foodServiceData.setDeliveryFee(foodService.getDeliveryFee());
        foodServiceData.setEmail(foodService.getEmail());
        foodServiceData.setFoodType(foodService.getFoodType());
        foodServiceData.setName(foodService.getName());
        foodServiceData.setUserData(userData);
        
        when(entityManager.merge(foodServiceData)).thenReturn(foodServiceData);
        
        foodServiceRepositoryJPA.update(foodService);
        
        verify(entityManager).merge(foodServiceData);
    }
    
    @Test
    public void getAll() {
        User user = new User("email1@email.com", "pass1");
        FoodService foodService = new FoodService("email1@email.com", "Pizzas 25", "Street 89", "PIZZA", 100, true, user, Collections.emptyList());
        
        UserData userData = new UserData();
        userData.setEmail(user.getEmail());
        userData.setPassword(user.getPassword());
        
        FoodServiceData foodServiceData = new FoodServiceData();
        foodServiceData.setActive(foodService.getActive());
        foodServiceData.setAddress(foodService.getAddress());
        foodServiceData.setDeliveryFee(foodService.getDeliveryFee());
        foodServiceData.setEmail(foodService.getEmail());
        foodServiceData.setFoodType(foodService.getFoodType());
        foodServiceData.setName(foodService.getName());
        foodServiceData.setUserData(userData);
        
        when(typedQuery.getResultList()).thenReturn(Arrays.asList(foodServiceData));
        when(entityManager.createNamedQuery("FoodServiceData.findAll", FoodServiceData.class)).thenReturn(typedQuery);
                
        List<FoodService> foodServices = foodServiceRepositoryJPA.getAll();
        
        assertThat(foodServices).isEqualTo(Arrays.asList(foodService));
    }
    
    @Test
    public void getByFoodType() {
        User user = new User("email1@email.com", "pass1");
        FoodService foodService = new FoodService("email1@email.com", "Pizzas 25", "Street 89", "PIZZA", 100, true, user, Collections.emptyList());
        
        UserData userData = new UserData();
        userData.setEmail(user.getEmail());
        userData.setPassword(user.getPassword());
        
        FoodServiceData foodServiceData = new FoodServiceData();
        foodServiceData.setActive(foodService.getActive());
        foodServiceData.setAddress(foodService.getAddress());
        foodServiceData.setDeliveryFee(foodService.getDeliveryFee());
        foodServiceData.setEmail(foodService.getEmail());
        foodServiceData.setFoodType(foodService.getFoodType());
        foodServiceData.setName(foodService.getName());
        foodServiceData.setUserData(userData);
        
        when(typedQuery.getResultList()).thenReturn(Arrays.asList(foodServiceData));
        when(typedQuery.setParameter("foodType", "PIZZA")).thenReturn(typedQuery);
        when(entityManager.createNamedQuery("FoodServiceData.findByFoodType", FoodServiceData.class)).thenReturn(typedQuery);
                
        List<FoodService> foodServices = foodServiceRepositoryJPA.getByFoodType("PIZZA");
        
        assertThat(foodServices).isEqualTo(Arrays.asList(foodService));
    }
    
}
