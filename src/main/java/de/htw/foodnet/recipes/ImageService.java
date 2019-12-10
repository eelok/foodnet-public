package de.htw.foodnet.recipes;

import lombok.NoArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Optional;

@Component
@NoArgsConstructor
public class ImageService {

    PhotoRepository photoRepository;
    RecipeRepository recipeRepository;
    Recipe recipe;

    public void setImageInRecipe(MultipartFile file) throws IOException {
        this.recipe.setImages(Collections.singletonList(getImage(file, recipe.getName())));
        recipeRepository.save(recipe);
    }


    public void fetchImageFromForm(HttpServletResponse response){
        Optional<ImageFile> imageFile = photoRepository.findByRecipeId(this.recipe.getId());
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
        OutputStream out = response.getOutputStream();
        response.setContentType(image.getContentType());
        response.setContentLength(image.getContentLength());
        IOUtils.copy(new ByteArrayInputStream(image.getContent()), out);
        out.flush();
        out.close();
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
