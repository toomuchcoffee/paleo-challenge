package de.toomuchcoffee.paleochallenge.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@JsonInclude
@Data
@Builder
public class Meal {
    private String name;
    private List<Ingredient> ingredients;
}
