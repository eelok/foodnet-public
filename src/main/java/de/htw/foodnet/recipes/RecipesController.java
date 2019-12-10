package de.htw.foodnet.recipes;

import lombok.AllArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Optional;

@Controller
@RequestMapping("recipes")
@AllArgsConstructor
public class RecipesController {

    private RecipeRepository recipeRepository;
    private PhotoRepository photoRepository;
    private ImageService imageService;


    @RequestMapping(value = "")
    public ModelAndView getRecipes(Model model) {
        model.addAttribute("recipes", recipeRepository.findAllByOrderByIdDesc());
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
//        recipe.setImages(Collections.singletonList(getImage(file, recipe.getName())));
//        recipeRepository.save(recipe);
        imageService.setImageInRecipe(file);
        model.addAttribute("recipe", new Recipe());

        return "redirect:/recipes";
    }

    @GetMapping("/photo/{id}")
    public void download(@PathVariable("id") long idNo, HttpServletRequest request, HttpServletResponse response) {
//        Optional<ImageFile> imageFile = photoRepository.findByRecipeId(idNo);
//        imageFile.ifPresent(image -> {
//            try {
//                setResponseImage(response, image);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
        imageService.fetchImageFromForm(response);
    }

//    private void setResponseImage(HttpServletResponse response, ImageFile image) throws IOException {
//        response.setHeader("Content-Disposition", "inline;filename=\"" + image.getName() + "\"");
//        OutputStream out = response.getOutputStream();
//        response.setContentType(image.getContentType());
//        response.setContentLength(image.getContentLength());
//        IOUtils.copy(new ByteArrayInputStream(image.getContent()), out);
//        out.flush();
//        out.close();
//
//    }

//    private ImageFile getImage(MultipartFile file, String name) throws IOException {
//        return new ImageFile(
//                file.getBytes(),
//                file.getContentType(),
//                Long.valueOf(file.getSize()).intValue(),
//                name
//        );
//    }

}
