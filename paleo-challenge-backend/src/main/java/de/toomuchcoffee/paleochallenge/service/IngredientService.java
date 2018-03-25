package de.toomuchcoffee.paleochallenge.service;

import de.toomuchcoffee.paleochallenge.domain.entity.Ingredient;
import de.toomuchcoffee.paleochallenge.domain.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public List<Ingredient> findIngredientsMatching(String query) {
        return ingredientRepository.findByNameStartsWithIgnoreCase(query);
    }

}
