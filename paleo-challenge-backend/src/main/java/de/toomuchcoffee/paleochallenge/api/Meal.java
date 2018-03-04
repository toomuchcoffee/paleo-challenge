package de.toomuchcoffee.paleochallenge.api;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Meal {
    private String name;
    private List<Ingredient> ingredients;
}
