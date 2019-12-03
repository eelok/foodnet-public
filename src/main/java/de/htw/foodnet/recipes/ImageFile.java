package de.htw.foodnet.recipes;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Entity
@EnableAutoConfiguration
@Table(name="photos")
public class ImageFile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    @Column(name = "content")
    private byte[] content;

    @Column(name = "content_type")
    private String contentType;

    @Column(name = "content_length")
    private int contentLength;

    @Column(name = "name")
    private String name;

    @Column(name = "recipe_id")
    private Long recipeId;

    public ImageFile() {

    }

    public ImageFile(byte[] content, String contentType, int contentLength, String name) {
        this.content = content;
        this.contentType = contentType;
        this.contentLength = contentLength;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getContentType() {
        return contentType;
    }

    public int getContentLength() {
        return contentLength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }
}
