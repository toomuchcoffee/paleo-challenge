package de.toomuchcoffee.paleochallenge.mapper;

import de.toomuchcoffee.paleochallenge.api.Ingredient;
import org.mapstruct.Mapper;

@Mapper
public interface IngredientMapper {

    Ingredient asApiObj(de.toomuchcoffee.paleochallenge.domain.entity.Ingredient entity);

    de.toomuchcoffee.paleochallenge.domain.entity.Ingredient asEntity(Ingredient apiObj);

}
