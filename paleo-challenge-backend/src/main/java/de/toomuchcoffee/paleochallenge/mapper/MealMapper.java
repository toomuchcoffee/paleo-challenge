package de.toomuchcoffee.paleochallenge.mapper;

import de.toomuchcoffee.paleochallenge.api.Meal;
import org.mapstruct.Mapper;

@Mapper(uses = IngredientMapper.class)
public interface MealMapper {

    Meal asApiObj(de.toomuchcoffee.paleochallenge.domain.entity.Meal entity);

    de.toomuchcoffee.paleochallenge.domain.entity.Meal asEntity(Meal apiObj);

}
