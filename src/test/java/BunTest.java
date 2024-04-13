import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import praktikum.Bun;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private final String expectedName;
    private final float expectedPrice;

    public BunTest(String expectedName, float expectedPrice) {
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Cheeseburger", 10.99f },
                {"Hamburger", 5.0f},
                {"Big burger", 6.0f}
        });
    }

    @Test
    public void testBunCreation() {
        Bun bun = new Bun(expectedName, expectedPrice);

        assertEquals(expectedName, bun.getName());
        assertEquals(expectedPrice, bun.getPrice(), 0.01f);
    }
}

