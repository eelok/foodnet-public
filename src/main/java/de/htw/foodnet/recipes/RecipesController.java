package de.htw.foodnet.recipes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RecipesController {

    @RequestMapping(value = "recipes")
    public ModelAndView getRecipes(){
        return new ModelAndView("recipes");
    }
}
