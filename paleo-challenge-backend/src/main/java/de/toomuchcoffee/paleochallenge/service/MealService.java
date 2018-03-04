package de.toomuchcoffee.paleochallenge.service;

import com.google.common.collect.Lists;
import de.toomuchcoffee.paleochallenge.api.Ingredient;
import de.toomuchcoffee.paleochallenge.api.Meal;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MealService {

    private ArrayList<Meal> meals;

    @PostConstruct
    public void setUp() {
        meals = Lists.newArrayList(
                newMeal("Frozen Berry Smoothie",
                        newIngredient("Banana"),
                        newIngredient("Nuts"),
                        newIngredient("Joghurt"),
                        newIngredient("Frozen Berries")
                ),
                newMeal("Salmon & Broccoli",
                        newIngredient("Salmon"),
                        newIngredient("Broccoli"),
                        newIngredient("Mustard"),
                        newIngredient("Olive Oil")
                ));
    }

    private Meal newMeal(String name, Ingredient... ingredients) {
        Meal meal = new Meal();
        meal.setName(name);
        meal.setIngredients(Lists.newArrayList());
        Arrays.stream(ingredients)
                .forEach(i -> meal.getIngredients().add(i));
        return meal;
    }

    private Ingredient newIngredient(String name) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(name);
        return ingredient;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void addMeal(Meal meal) {
        meals.add(meal);
    }
}
