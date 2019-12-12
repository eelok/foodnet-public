package de.htw.foodnet.recipes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RecipePhotoService {

    private PhotoRepository photoRepository;

    public Optional<ImageFile> findByRecipeId(long idNo) {
        return photoRepository.findByRecipeId(idNo);
    }
}
