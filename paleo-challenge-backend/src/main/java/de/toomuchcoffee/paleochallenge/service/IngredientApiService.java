package de.toomuchcoffee.paleochallenge.service;

import de.toomuchcoffee.paleochallenge.api.Ingredient;
import de.toomuchcoffee.paleochallenge.mapper.IngredientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@Service
public class IngredientApiService {
    private final IngredientService ingredientService;

    private final IngredientMapper ingredientMapper;

    public List<Ingredient> findIngredientsMatching(String query) {
        return ingredientService.findIngredientsMatching(query).stream()
                .map(ingredientMapper::asApiObj)
                .collect(toList());
    }
}
