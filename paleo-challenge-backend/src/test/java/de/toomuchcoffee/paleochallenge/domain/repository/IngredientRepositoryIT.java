package de.toomuchcoffee.paleochallenge.domain.repository;

import de.toomuchcoffee.paleochallenge.domain.entity.Ingredient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
public class IngredientRepositoryIT {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Before
    public void setUp() throws Exception {
        List<Ingredient> ingredients = newArrayList(
                newIngredient("abc"), newIngredient("Abd"), newIngredient("aAa"));
        ingredientRepository.save(ingredients);
    }

    @Test
    public void findByNameStartsWithIgnoreCase() throws Exception {
        Iterable<Ingredient> all = ingredientRepository.findAll();
        assertThat(all).hasSize(3);
        List<Ingredient> found = ingredientRepository.findByNameStartsWithIgnoreCase("aB");
        assertThat(found).hasSize(2);
    }

    private Ingredient newIngredient(String name) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(name);
        return ingredient;
    }
}