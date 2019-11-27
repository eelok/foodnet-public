package de.htw.foodnet.database;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.List;

@Entity
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

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name= "recipe_id")
    private List<Ingredient> ingredientsList;

   public Recipe() {
    }

    public Recipe(
            String name,
                  String description,
                  List<Ingredient> ingredientsList,
                  int cookTime,
                  int prepareTime
    ) {
        this.name = name;
        this.description = description;
        this.ingredientsList = ingredientsList;
        this.cookTime = cookTime;
        this.prepareTime = prepareTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Ingredient> getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(List<Ingredient> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }


    public int getCookTime() {
        return cookTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    public int getPrepareTime() {
        return prepareTime;
    }

    public void setPrepareTime(int prepareTime) {
        this.prepareTime = prepareTime;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cookTime=" + cookTime +
                ", prepareTime=" + prepareTime +
                '}';
    }
}
