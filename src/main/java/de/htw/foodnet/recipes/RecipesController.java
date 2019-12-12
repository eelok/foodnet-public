package de.htw.foodnet.recipes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Collections;

@Controller
@RequestMapping("recipes")
@AllArgsConstructor
public class RecipesController {

    private RecipeService recipeService;

    @RequestMapping(value = "")
    public ModelAndView getRecipes(Model model) {
        model.addAttribute("recipes", recipeService.getRecepies());

        return new ModelAndView("recipes");
    }

    @GetMapping(value = "/new")
    public ModelAndView getNewRecipeForm(Model model) {
        model.addAttribute("recipe", new Recipe());

        return new ModelAndView("newRecipes");
    }

    @PostMapping("/new")
    public String postRecipe(
            @ModelAttribute Recipe recipe,
            @RequestParam("file") MultipartFile file,
            Model model
    ) throws IOException {
        recipe.setImages(Collections.singletonList(getImage(file, recipe.getName())));
        recipeService.saveRecipe(recipe);
        model.addAttribute("recipe", new Recipe());

        return "redirect:/recipes";
    }

    private ImageFile getImage(MultipartFile file, String name) throws IOException {
        return new ImageFile(
                file.getBytes(),
                file.getContentType(),
                Long.valueOf(file.getSize()).intValue(),
                name
        );
    }

}
