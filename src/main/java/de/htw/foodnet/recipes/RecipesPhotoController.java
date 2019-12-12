package de.htw.foodnet.recipes;

import lombok.AllArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class RecipesPhotoController {

    private RecipePhotoService recipePhotoService;

    @GetMapping("/recipes/photo/{id}")
    public void getRecipePhoto(@PathVariable("id") long idNo, HttpServletRequest request, HttpServletResponse response) {
        Optional<ImageFile> imageFile = recipePhotoService.findByRecipeId(idNo);
        imageFile.ifPresent(image -> {
            try {
                setResponseImage(response, image);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void setResponseImage(HttpServletResponse response, ImageFile image) throws IOException {
        response.setHeader("Content-Disposition", "inline;filename=\"" + image.getName() + "\"");
        try (OutputStream out = response.getOutputStream()) {
            response.setContentType(image.getContentType());
            response.setContentLength(image.getContentLength());
            IOUtils.copy(new ByteArrayInputStream(image.getContent()), out);
            out.flush();
        }
    }
}
