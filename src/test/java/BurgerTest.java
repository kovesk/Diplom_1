

import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BurgerTest {

    private Burger burger;
    private Bun bun;
    private Ingredient ingredient1;
    private Ingredient ingredient2;

    @Before
    public void setUp() {
        burger = new Burger();
        bun = mock(Bun.class);
        ingredient1 = mock(Ingredient.class);
        ingredient2 = mock(Ingredient.class);

        when(bun.getName()).thenReturn("Bun Name");
        when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient1.getName()).thenReturn("ingredient 1");
        when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient2.getName()).thenReturn("ingredient 2");
        when(bun.getPrice()).thenReturn(1.0f);
        when(ingredient1.getPrice()).thenReturn(0.5f);
        when(ingredient2.getPrice()).thenReturn(0.75f);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient1);
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient1, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient2, burger.ingredients.get(0));
        assertEquals(ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        float expectedPrice = 3.25f;
        assertEquals(expectedPrice, burger.getPrice(), 0.01f);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.setBuns(bun);
        burger.getPrice();
        // Вызов тестируемого метода
        String receipt = burger.getReceipt();
        // Проверка результата
        String expectedReceipt = "(==== Bun Name ====)\n" +
                "= filling ingredient 1 =\n" +
                "= sauce ingredient 2 =\n" +
                "(==== Bun Name ====)\n" +
                "\nPrice: 3,250000\n";
        assertEquals(expectedReceipt, receipt);
    }
}

