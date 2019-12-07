package de.htw.foodnet.recipes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findAllByOrderByIdDesc();
    List<Recipe> findTop2ByOrderByIdDesc();
}
