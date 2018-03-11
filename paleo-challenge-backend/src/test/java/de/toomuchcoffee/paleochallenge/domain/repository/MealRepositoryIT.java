package de.toomuchcoffee.paleochallenge.domain.repository;

import de.toomuchcoffee.paleochallenge.domain.entity.Ingredient;
import de.toomuchcoffee.paleochallenge.domain.entity.Meal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MealRepositoryIT {

    @Autowired
    private MealRepository mealRepository;

    @Before
    public void setUp() throws Exception {
        mealRepository.deleteAll();
    }

    @Test
    public void insert() throws Exception {
        Meal meal = new Meal();
        meal.setName("Smoothie");
        meal.setIngredients(newArrayList(
                newIngredient("Banana"),
                newIngredient("Joghurt")
                ));

        mealRepository.save(meal);

        Iterable<Meal> meals = mealRepository.findAll();
        assertThat(meals).hasSize(1);
        assertThat(meals.iterator().next().getIngredients()).hasSize(2);
    }

    private Ingredient newIngredient(String name) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(name);
        return ingredient;
    }

}