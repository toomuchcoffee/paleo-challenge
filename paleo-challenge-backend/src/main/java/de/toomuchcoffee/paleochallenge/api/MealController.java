package de.toomuchcoffee.paleochallenge.api;

import de.toomuchcoffee.paleochallenge.service.MealApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping(value = "api/meals")
public class MealController {
    private final MealApiService mealApiService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Meal> getMeals() {
        return mealApiService.getMeals();
    }

    @PostMapping
    public void postMeal(@RequestBody Meal meal) {
        mealApiService.addMeal(meal);
    }
}
