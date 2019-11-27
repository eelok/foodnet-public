package de.htw.foodnet.database;

import de.htw.foodnet.database.Entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Override
    Recipe save(Recipe entity);

}
