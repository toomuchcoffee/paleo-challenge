CREATE TABLE meal (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE meal_to_ingredient (
    meal_id integer,
    ingredient_id integer,
    PRIMARY KEY(meal_id, ingredient_id)
);

CREATE TABLE ingredient (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255)
);