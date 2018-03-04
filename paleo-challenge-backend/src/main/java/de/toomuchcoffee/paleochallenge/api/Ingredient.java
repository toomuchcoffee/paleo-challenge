package de.toomuchcoffee.paleochallenge.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@JsonInclude
@Data
@Builder
public class Ingredient {
    private String name;
}
