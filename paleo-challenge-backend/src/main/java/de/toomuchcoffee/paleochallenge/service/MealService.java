package de.toomuchcoffee.paleochallenge.service;

import com.google.common.collect.Lists;
import de.toomuchcoffee.paleochallenge.api.Ingredient;
import de.toomuchcoffee.paleochallenge.api.Meal;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MealService {

    private ArrayList<Meal> meals;

    @PostConstruct
    public void setUp() {
        meals = Lists.newArrayList(
                Meal.builder()
                        .name("Frozen Berry Smoothie")
                        .ingredients(Lists.newArrayList(
                                Ingredient.builder().name("Banana").build(),
                                Ingredient.builder().name("Nuts").build(),
                                Ingredient.builder().name("Joghurt").build(),
                                Ingredient.builder().name("Frozen Berries").build()
                        ))
                        .build(),
                Meal.builder()
                        .name("Salmon & Broccoli")
                        .ingredients(Lists.newArrayList(
                                Ingredient.builder().name("Salmon").build(),
                                Ingredient.builder().name("Broccoli").build(),
                                Ingredient.builder().name("Mustard").build(),
                                Ingredient.builder().name("Olive Oil").build()
                        ))
                        .build()
        );
    }

    public List<Meal> getMeals() {
        return meals;
    }
}
