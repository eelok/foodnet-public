package de.htw.foodnet.recipes.createNew;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CreateRecipesController {
    @RequestMapping(value="createRecipes")
    public ModelAndView createRecipes() {
        return new ModelAndView("createRecipes");
    }

}
