package de.toomuchcoffee.paleochallenge.service;

import de.toomuchcoffee.paleochallenge.domain.entity.Ingredient;
import de.toomuchcoffee.paleochallenge.domain.entity.Meal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MealServiceIT {

    @Autowired
    private MealService mealService;

    @Test
    public void insertsTwoMealsWithOneSharedIngredient() throws Exception {
        mealService.addMeal(newMeal("Smoothie", "Banana", "Yogurt"));
        mealService.addMeal(newMeal("Pancake", "Banana", "Egg"));

        List<Meal> meals = mealService.getMeals();
        assertThat(meals).hasSize(2);
        Set<Ingredient> ingredients = meals.stream()
                .map(Meal::getIngredients)
                .flatMap(Collection::stream)
                .collect(toSet());
        assertThat(ingredients).hasSize(3);
    }

    private Meal newMeal(String mealName, String... ingredientName) {
        Meal meal = new Meal();
        meal.setName(mealName);
        List<Ingredient> ingredients = stream(ingredientName)
                .map(name -> {
                    Ingredient ingredient = new Ingredient();
                    ingredient.setName(name);
                    return ingredient;
                })
                .collect(toList());
        meal.setIngredients(ingredients);
        return meal;
    }
}