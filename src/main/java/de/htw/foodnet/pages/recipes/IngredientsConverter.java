package de.htw.foodnet.recipes;

import de.htw.foodnet.database.Entity.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class IngredientsConverter implements Converter<String, List<Ingredient>> {

    @Override
    public List<Ingredient> convert(String ingredients) {
        return Stream.of(ingredients.split(","))
                .map(s -> {
                    String[] split = s.split(":");
                    String name = split[0];
                    int amount = Integer.parseInt(split[1]);

                    return new Ingredient(name, amount);
                })
                .collect(Collectors.toList());
    }

}
