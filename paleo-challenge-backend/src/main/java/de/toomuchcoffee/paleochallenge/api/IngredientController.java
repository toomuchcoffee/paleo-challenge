package de.toomuchcoffee.paleochallenge.api;

import de.toomuchcoffee.paleochallenge.service.IngredientApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("api/ingredients")
public class IngredientController {
    private final IngredientApiService ingredientApiService;

    @GetMapping
    public List<Ingredient> findIngredientsMatching(@RequestParam("q") String query) {
        return ingredientApiService.findIngredientsMatching(query);
    }
}
