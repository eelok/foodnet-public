package de.htw.foodnet.recipes;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@EnableAutoConfiguration
@Table(name="recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "recipe_name")
    private String name;

    @Column(name = "cook_time")
    private int cookTime;

    @Column(name = "prepare_time")
    private int prepareTime;

    @Column(name = "description", length = 12000)
    private String description;

    @Lob
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="recipe_id")
    private List<ImageFile> images;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="recipe_id")
    private List<Ingredient> ingredientsList;


    public Recipe(
        String name,
        String description,
        List<Ingredient> ingredientsList,
        int cookTime,
        int prepareTime,
        List<ImageFile> images
    ) {
        this.name = name;
        this.description = description;
        this.ingredientsList = ingredientsList;
        this.cookTime = cookTime;
        this.prepareTime = prepareTime;
        this.images = images;
    }

}
