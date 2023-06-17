package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Test: {0} {1}")
    public static Object[][] testData() {
        return new Object[][]{
                {"black bun", 100},
                {"some test bun", Float.MAX_VALUE},
                {"", Float.MIN_VALUE},
                {null, 0},
                {" ", -100}
        };
    }

    @Test
    public void checkGetBinName() {
        Bun bun = new Bun(name, price);
        assertEquals("Bin name is incorrect", name, bun.getName());
    }

    @Test
    public void checkGetBinPrise() {
        Bun bun = new Bun(name, price);
        assertEquals("Bin price is incorrect", price, bun.getPrice(), 0);
    }
}