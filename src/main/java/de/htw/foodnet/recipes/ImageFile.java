package de.htw.foodnet.recipes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
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

    public ImageFile(byte[] content, String contentType, int contentLength, String name) {
        this.content = content;
        this.contentType = contentType;
        this.contentLength = contentLength;
        this.name = name;
    }

}
