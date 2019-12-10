package de.htw.foodnet.recipes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class InitData {

    private final RecipeRepository recipeRepository;

    @PostConstruct
    public void postConstruct() throws IOException {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("potato", 1),
                new Ingredient("onion", 1),
                new Ingredient("carrot", 3)
        );
        List<ImageFile> pasta = Arrays.asList(getImageFile("pasta.jpg"));
        List<ImageFile> burger = Arrays.asList(getImageFile("burger.jpeg"));
        List<ImageFile> veganSaladBowl = Arrays.asList(getImageFile("veganSaladBowl.jpeg"));
        List<ImageFile> curry = Arrays.asList(getImageFile("curry.jpg"));
        List<ImageFile> chocolateStrawberryPancakes = Arrays.asList(getImageFile("chocolateStrawberryPancakes.jpeg"));

        recipeRepository.deleteAll();

        recipeRepository.saveAll(Arrays.asList(
                new Recipe(
                        "Pasta Pesto",
                        "Bring a large pot of lightly salted water to a boil. Add pasta and cook for 8 to 10 minutes or until al dente; drain. " +
                                "Meanwhile, melt butter together with the olive oil in a saucepan over medium heat. Stir in onion, and cook until softened and" +
                                "translucent, about 2 minutes. Stir in garlic, red pepper, and mushroom; cook over medium-high heat until soft, about 2 minutes more.",
                        ingredients,
                        10,
                        20,
                        pasta
                ),
                new Recipe(
                        "Portobello Mushroom Burgers",
                        "Place the mushroom caps, smooth side up, in a shallow dish. In a small bowl," +
                                " whisk together vinegar, oil, basil, oregano, garlic, salt, and pepper. " +
                                "Pour over the mushrooms. Let stand at room temperature for 15 minutes or so, turning twice." +
                                "Preheat grill for medium-high heat. Brush grate with oil. Place mushrooms on the grill, reserving" +
                                " marinade for basting. Grill for 5 to 8 minutes on each side, or until tender. Brush with marinade frequently." +
                                " Top with cheese during the last 2 minutes of grilling.",
                        ingredients,
                        20,
                        15,
                        burger
                ),
                new Recipe(
                        "Avocado Corn Salsa",
                        "In a large bowl, mix corn, olives, red bell pepper and onion." +
                                "In a small bowl, mix garlic, olive oil, lemon juice, cider vinegar, " +
                                "oregano, salt and pepper. Pour into the corn mixture and toss to coat. " +
                                "Cover and chill in the refrigerator 8 hours, or overnight. Stir avocados " +
                                "into the mixture before serving.",
                        ingredients,
                        0,
                        30,
                        veganSaladBowl
                ),
                new Recipe(
                        "Marrakesh Vegetable Curry",
                        "In a large Dutch oven place sweet potato, eggplant, peppers, " +
                                "carrots, onion, and three tablespoons oil. Saute over medium heat for 5 minutes." +
                                "In a medium saucepan place 3 tablespoons olive oil, garlic, turmeric, curry powder," +
                                "cinnamon, salt and pepper and saute over medium heat for 3 minutes." +
                                "Pour garlic and spice mixture into the Dutch oven with vegetables in it. " +
                                "Add the garbanzo beans, almonds, zucchini, raisins, and orange juice. Simmer 20 minutes, covered." +
                                "Add spinach to pot and cook for 5 more minutes. Serve!",
                        ingredients,
                        35,
                        15,
                        curry
                ),
                new Recipe(
                        "Chocolate strawberry pancakes",
                        "Mix flour, sugar, baking powder, baking soda, and salt together in a large bowl. Add kefir and eggs; " +
                        "stir until batter is moist but still lumpy. Fold in chocolate chips. Heat a lightly oiled griddle over medium-high heat." +
                        " Drop batter by large spoonfuls onto the griddle and cook until bubbles form and the edges are dry, 3 to 4 minutes. " +
                        "Flip and cook until golden on the other side, 2 to 3 minutes. Repeat with remaining batter.",
                        ingredients,
                        5,
                        10,
                        chocolateStrawberryPancakes
                )));
    }

    private ImageFile getImageFile(String fileName) throws IOException {
        byte[] imageData = extractBytes(fileName);

        return new ImageFile(imageData, "image/jpeg", imageData.length, fileName);
    }

    private byte[] extractBytes(String imageName) throws IOException {
        InputStream resourceAsStream = this.getClass().getResourceAsStream(imageName);
        return getBytesFromInputStream(resourceAsStream);
    }

    public static byte[] getBytesFromInputStream(InputStream is) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        byte[] buffer = new byte[0xFFFF];
        for (int len = is.read(buffer); len != -1; len = is.read(buffer)) {
            os.write(buffer, 0, len);
        }
        return os.toByteArray();
    }

}
