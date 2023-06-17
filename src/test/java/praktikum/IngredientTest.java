package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    public static IngredientType type;
    public static String name;
    public static float price;

    public IngredientTest(IngredientType type, String name, float price) {
        IngredientTest.type = type;
        IngredientTest.name = name;
        IngredientTest.price = price;
    }

    @Parameterized.Parameters(name = "Test: {0} {1}")
    public static Object[][] testData() {
        return new Object[][]{
                {SAUCE, "hot sauce", 100},
                {SAUCE, "chili sauce", -300},
                {FILLING, "cutlet", 0},
                {FILLING, "dinosaur", Float.MIN_VALUE},
                {FILLING, "sausage", Float.MIN_VALUE}
        };
    }

    @Test
    public void checkGetIngredientType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("Ingredient type is incorrect", ingredient.getType(), type);
    }

    @Test
    public void checkGetIngredientName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("Ingredient name is incorrect", ingredient.getName(), name);
    }

    @Test
    public void checkGetIngredientPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("Ingredient price is incorrect", ingredient.getPrice(), price, 0);
    }
}
