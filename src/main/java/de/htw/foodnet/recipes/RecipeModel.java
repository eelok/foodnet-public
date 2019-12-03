package de.htw.foodnet.recipes;

public class RecipeModel {
    private final String name;
    private final String description;
    private final Long photoId;

    public RecipeModel(String name, String description, Long photoId) {
        this.name = name;
        this.description = description;
        this.photoId = photoId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getPhotoId() {
        return photoId;
    }
}
