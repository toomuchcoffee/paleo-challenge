package de.toomuchcoffee.paleochallenge.api;

import de.toomuchcoffee.paleochallenge.service.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping(value = "api/meals")
public class MealController {
    private final MealService mealService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Meal> getMeals() {
        return mealService.getMeals();
    }

    @PostMapping
    public void postMeal(@RequestBody Meal meal) {
        mealService.addMeal(meal);
    }
}
