package de.htw.foodnet.home;

import de.htw.foodnet.recipes.RecipeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController {

    private RecipeRepository recipeRepository;

    public HomePageController(RecipeRepository RecipeRepository) {
        recipeRepository = RecipeRepository;
    }

    @RequestMapping("/")
    public ModelAndView getIndexPage() {
        ModelAndView model = new ModelAndView("home");
        model.addObject("recipes", recipeRepository.findTop2ByOrderByIdDesc());
        return model;
    }
}
