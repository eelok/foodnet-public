package de.htw.foodnet.recipes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public interface PhotoRepository extends JpaRepository<ImageFile, Long> {

    @Transactional
    Optional<ImageFile> findByRecipeId(Long rLong);

}
