package de.toomuchcoffee.paleochallenge.domain.repository;

import de.toomuchcoffee.paleochallenge.domain.entity.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
    Optional<Ingredient> findByNameIgnoreCase(String name);
    List<Ingredient> findByNameStartsWithIgnoreCase(String name);
}
