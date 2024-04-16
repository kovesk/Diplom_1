

import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void testIngredientTypeValues() {
        // Проверяем, что в перечислении IngredientType есть два ожидаемых значения
        assertEquals("Ожидалось два значения в перечислении IngredientType", 2, IngredientType.values().length);

        // Проверяем, что первое значение в перечислении - SAUCE
        assertEquals("Первое значение в перечислении должно быть SAUCE", IngredientType.SAUCE, IngredientType.values()[0]);

        // Проверяем, что второе значение в перечислении - FILLING
        assertEquals("Второе значение в перечислении должно быть FILLING", IngredientType.FILLING, IngredientType.values()[1]);
    }
}

