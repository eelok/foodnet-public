package de.htw.foodnet.recipes;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private RecipeRepository recipeRepository;

    @RequestMapping(value = "")
    public ModelAndView getRecipes(Model model) {
        model.addAttribute("recipes", recipeRepository.findAll());
        return new ModelAndView("recipes");
    }

    @GetMapping(value = "/new")
    public ModelAndView getNewRecipeForm(Model model) {
        model.addAttribute("recipe", new Recipe());

        return new ModelAndView("newRecipes");
    }

    @PostMapping("/new")
    public String postRecipe(@ModelAttribute Recipe recipe, Model model) {
        recipeRepository.save(recipe);
        model.addAttribute("recipe", new Recipe());

        return "redirect:/recipes";
    }

}
