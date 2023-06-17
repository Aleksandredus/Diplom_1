package praktikum;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class IngredientTypeTest {
    @Test
    public void checkFillingIsNotEmpty() {
        assertThat("Filling is empty!", IngredientType.FILLING, is(notNullValue()));
    }

    @Test
    public void checkSauceIsNotEmpty() {
        assertThat("Sauce is empty!", IngredientType.SAUCE, is(notNullValue()));
    }
}