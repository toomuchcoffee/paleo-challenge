package de.toomuchcoffee.paleochallenge.api;

import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "api/meals")
public class MealController {

    @GetMapping
    public List<Meal> getMeals() {
        return Lists.newArrayList(
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
}
