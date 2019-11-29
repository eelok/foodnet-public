package de.htw.foodnet.recipes;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Entity
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

    public Ingredient() {
    }

    public Ingredient(String name, int amountPerPortion) {
        this.name = name;
        this.amountPerPortion = amountPerPortion;
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

    public float getAmountPerPortion() {
        return amountPerPortion;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmountPerPortion(int amountPerPortion) {
        this.amountPerPortion = amountPerPortion;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", amountPerPortion=" + amountPerPortion +
                '}';
    }
}
