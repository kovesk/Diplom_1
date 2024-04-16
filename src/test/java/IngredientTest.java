

import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

public class IngredientTest {

    @Test
    public void testIngredientConstructor() {
        IngredientType type = IngredientType.FILLING;
        String name = "Tomato";
        float price = 1.5f;

        Ingredient ingredient = new Ingredient(type, name, price);

        assertEquals(type, ingredient.getType());
        assertEquals(name, ingredient.getName());
        assertEquals(price, ingredient.getPrice(), 0.001f);
    }

    @Test
    public void testIngredientGetters() {
        IngredientType type = IngredientType.SAUCE;
        String name = "Bolognese";
        float price = 2.0f;

        Ingredient ingredient = new Ingredient(type, name, price);

        assertEquals(type, ingredient.getType());
        assertEquals(name, ingredient.getName());
        assertEquals(price, ingredient.getPrice(), 0.001f);
    }
}
