package de.toomuchcoffee.paleochallenge.service;


import de.toomuchcoffee.paleochallenge.domain.entity.Ingredient;
import de.toomuchcoffee.paleochallenge.domain.entity.Meal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MealApiServiceIT {

    @Autowired
    private MealApiService mealApiService;

    @MockBean
    private MealService mealService;

    @Before
    public void setUp() throws Exception {
        when(mealService.getMeals()).thenReturn(newArrayList(newMeal()));
    }

    @Test
    public void getMeals() throws Exception {
        List<de.toomuchcoffee.paleochallenge.api.Meal> meals = mealApiService.getMeals();

        assertThat(meals).hasSize(1);
        assertThat(meals.get(0).getName()).isEqualTo("Pancake");
        assertThat(meals.get(0).getIngredients()).hasSize(2);
        assertThat(meals.get(0).getIngredients().get(0).getName()).isEqualTo("Egg");
        assertThat(meals.get(0).getIngredients().get(1).getName()).isEqualTo("Banana");
    }

    @Test
    public void addMeal() throws Exception {
        de.toomuchcoffee.paleochallenge.api.Meal apiMeal = newApiMeal();

        mealApiService.addMeal(apiMeal);

        ArgumentCaptor<Meal> argumentCaptor = ArgumentCaptor.forClass(Meal.class);
        verify(mealService).addMeal(argumentCaptor.capture());
        Meal meal = argumentCaptor.getValue();
        assertThat(meal.getName()).isEqualTo(apiMeal.getName());
        assertThat(meal.getIngredients().get(0).getName()).isEqualTo(apiMeal.getIngredients().get(0).getName());
        assertThat(meal.getIngredients().get(1).getName()).isEqualTo(apiMeal.getIngredients().get(1).getName());
    }

    private Meal newMeal() {
        Meal meal = new Meal();
        meal.setName("Pancake");
        Ingredient ingredient1 = new Ingredient();
        ingredient1.setName("Egg");
        Ingredient ingredient2 = new Ingredient();
        ingredient2.setName("Banana");
        meal.setIngredients(newArrayList(ingredient1, ingredient2));
        return meal;
    }

    private de.toomuchcoffee.paleochallenge.api.Meal newApiMeal() {
        de.toomuchcoffee.paleochallenge.api.Meal meal = new de.toomuchcoffee.paleochallenge.api.Meal();
        meal.setName("Pancake");
        de.toomuchcoffee.paleochallenge.api.Ingredient ingredient1 = new de.toomuchcoffee.paleochallenge.api.Ingredient();
        ingredient1.setName("Egg");
        de.toomuchcoffee.paleochallenge.api.Ingredient ingredient2 = new de.toomuchcoffee.paleochallenge.api.Ingredient();
        ingredient2.setName("Banana");
        meal.setIngredients(newArrayList(ingredient1, ingredient2));
        return meal;
    }
}