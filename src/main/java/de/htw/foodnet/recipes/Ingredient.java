package de.htw.foodnet.recipes;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@EnableAutoConfiguration
@Table(name="ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "amount_per_portion")
    private int amountPerPortion;


    public Ingredient(String name, int amountPerPortion) {
        this.name = name;
        this.amountPerPortion = amountPerPortion;
    }
}
