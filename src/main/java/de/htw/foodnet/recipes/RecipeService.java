package de.htw.foodnet.recipes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecipeService {

    private RecipeRepository recipeRepository;

    public List<Recipe> getRecepies() {
        return recipeRepository.findAllByOrderByIdDesc();
    }

    public void saveRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }
}
