package de.htw.foodnet.recipes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RecipesControllerTest {

    private RecipesController recipesController;

    @Mock
    private RecipeService recipeService;

    @BeforeEach
    void setUp() {
        recipesController = new RecipesController(recipeService);
    }

    @Test
    void should_getRecipes() {
        Model model = mock(Model.class);

        ModelAndView recipes = recipesController.getRecipes(model);

        assertThat(recipes.getViewName()).isEqualTo("recipes/recipes");
    }

    @Test
    void should_have_attribute_in_model() {
        Model model = mock(Model.class);
        Recipe recipe = mock(Recipe.class);
        when(recipeService.getRecepies()).thenReturn(Collections.singletonList(recipe));

        recipesController.getRecipes(model);

        verify(model).addAttribute("recipes", Collections.singletonList(recipe));
    }

    @Test
    void should_getNewRecipeForm() {
        Model model = mock(Model.class);

        ModelAndView newRecipeForm = recipesController.getNewRecipeForm(model);

        assertThat(newRecipeForm.getViewName()).isEqualTo("recipes/newRecipes");
    }

    @Test
    void sould_postResipe() throws IOException {
        Model model = mock(Model.class);
        Recipe recipe = mock(Recipe.class);
        MultipartFile file = mock(MultipartFile.class);

        String recipes = recipesController.postRecipe(recipe, file, model);

        assertThat(recipes).isEqualTo("redirect:/recipes");
    }

    @Test
    void should_call_set_images() throws IOException {
        Model model = mock(Model.class);
        Recipe recipe = mock(Recipe.class);
        MultipartFile file = mock(MultipartFile.class);

        recipesController.postRecipe(recipe, file, model);

        verify(recipe).setImages(any());
    }

    @Test
    void should_have_attribute() throws IOException {
        Recipe recipe = mock(Recipe.class);
        MultipartFile file = mock(MultipartFile.class);
        Model model = mock(Model.class);

        recipesController.postRecipe(recipe, file, model);

        verify(model).addAttribute("recipe", new Recipe());
    }

}
