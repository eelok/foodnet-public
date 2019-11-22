package de.htw.foodnet.recipes;

import de.htw.foodnet.database.Recipe;
import de.htw.foodnet.database.RecipeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("recipes")
public class RecipesController {

    private RecipeRepository recipeRepository;

    public RecipesController(RecipeRepository RecipeRepository) {
        recipeRepository = RecipeRepository;
    }

    @RequestMapping(value = "")
    public ModelAndView getRecipes() {
        return new ModelAndView("recipes");
    }

    @GetMapping(value = "/new")
    public ModelAndView getNewRecipeForm(Model model) {
        model.addAttribute("recipe", new Recipe());

        return new ModelAndView("newRecipes");
    }

    @PostMapping("/new")
    public ModelAndView postRecipe(@ModelAttribute Recipe recipe, Model model) {
        recipeRepository.save(recipe);
        model.addAttribute("message", "Recipe has been saved");
        model.addAttribute("recipe", new Recipe());

        return new ModelAndView("newRecipes");
    }

}
