package de.toomuchcoffee.paleochallenge.service;

import de.toomuchcoffee.paleochallenge.domain.entity.Ingredient;
import de.toomuchcoffee.paleochallenge.domain.entity.Meal;
import de.toomuchcoffee.paleochallenge.domain.repository.IngredientRepository;
import de.toomuchcoffee.paleochallenge.domain.repository.MealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@Service
public class MealService {

    private final MealRepository mealRepository;
    private final IngredientRepository ingredientRepository;

    public List<Meal> getMeals() {
        return newArrayList(mealRepository.findAll());
    }

    @Transactional
    public void addMeal(Meal meal) {
        List<Ingredient> ingredients = meal.getIngredients().stream()
                .map(i -> ingredientRepository.findByNameIgnoreCase(i.getName()).orElse(i))
                .collect(toList());
        meal.setIngredients(ingredients);
        mealRepository.save(meal);
    }
}
