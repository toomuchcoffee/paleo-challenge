package de.toomuchcoffee.paleochallenge.service;

import de.toomuchcoffee.paleochallenge.api.Meal;
import de.toomuchcoffee.paleochallenge.mapper.MealMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@Service
public class MealApiService {

    private final MealService mealService;

    private final MealMapper mealMapper;

    public List<Meal> getMeals() {
        return mealService.getMeals().stream()
                .map(mealMapper::asApiObj)
                .collect(toList());
    }

    public void addMeal(Meal meal) {
        de.toomuchcoffee.paleochallenge.domain.entity.Meal entity = mealMapper.asEntity(meal);
        mealService.addMeal(entity);
    }
}
