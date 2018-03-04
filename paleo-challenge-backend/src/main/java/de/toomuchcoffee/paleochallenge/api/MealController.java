package de.toomuchcoffee.paleochallenge.api;

import de.toomuchcoffee.paleochallenge.service.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping(value = "api/meals")
public class MealController {
    private final MealService mealService;

    @GetMapping
    public List<Meal> getMeals() {
        return mealService.getMeals();
    }
}
