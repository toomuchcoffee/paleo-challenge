package de.toomuchcoffee.paleochallenge.domain.repository;

import de.toomuchcoffee.paleochallenge.domain.entity.Meal;
import org.springframework.data.repository.CrudRepository;

public interface MealRepository extends CrudRepository<Meal, Long> {
}
