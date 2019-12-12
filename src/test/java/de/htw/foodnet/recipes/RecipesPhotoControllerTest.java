package de.htw.foodnet.recipes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RecipesPhotoControllerTest {

    private RecipesPhotoController recipesPhotoController;

    @Mock
    private RecipePhotoService recipePhotoService;

    @BeforeEach
    void setUp() {
        recipesPhotoController = new RecipesPhotoController(recipePhotoService);
    }

    @Test
    void should_getRecipePhoto() {
        long photoId = 5;
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        recipesPhotoController.getRecipePhoto(photoId, request, response);

        verify(recipePhotoService).findByRecipeId(photoId);
    }

    @Test
    void should_setContentType() throws IOException {
        long photoId = 5;
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        ImageFile imageFile = mock(ImageFile.class);
        when(imageFile.getContentType()).thenReturn("contentType");
        byte[] byteArr = new byte[] {1};
        when(imageFile.getContent()).thenReturn(byteArr);
        when(imageFile.getContentLength()).thenReturn(20);
        Optional<ImageFile> image = Optional.of(imageFile);

        when(recipePhotoService.findByRecipeId(5)).thenReturn(image);
        ServletOutputStream out = mock(ServletOutputStream.class);
        when(response.getOutputStream()).thenReturn(out);

        recipesPhotoController.getRecipePhoto(5, request, response);

        verify(response).setContentType(imageFile.getContentType());
        verify(response).setContentLength(imageFile.getContentLength());
    }

}
