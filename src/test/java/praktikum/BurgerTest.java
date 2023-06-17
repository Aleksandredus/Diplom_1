package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun blackBun;
    @Mock
    Ingredient dinosaurFilling;
    @Mock
    Ingredient chiliSauce;

    @Test
    public void checkSetBuns() {
        Burger burger = new Burger();
        burger.setBuns(blackBun);
        System.out.println(blackBun);
        assertThat("You can't have a burger without a bun", burger.bun, is(notNullValue()));
    }

    @Test
    public void checkAddIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(dinosaurFilling);
        assertTrue("You not added ingredient in burger", burger.ingredients.contains(dinosaurFilling));
    }

    @Test
    public void checkGetPrice() {
        Burger burger = new Burger();
        burger.setBuns(blackBun);
        burger.addIngredient(dinosaurFilling);
        burger.addIngredient(dinosaurFilling);
        Mockito.when(blackBun.getPrice()).thenReturn(100f);
        Mockito.when(dinosaurFilling.getPrice()).thenReturn(200f);
        Assert.assertEquals("Price is incorrect", burger.getPrice(), 600, 1);
    }

    @Test
    public void checkRemoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(chiliSauce);
        burger.removeIngredient(0);
        assertTrue("Ingredient isn't remove!", burger.ingredients.isEmpty());
    }

    @Test
    public void checkMoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(chiliSauce);
        burger.addIngredient(dinosaurFilling);
        List<Ingredient> ingredient = new ArrayList<>();
        ingredient.add(dinosaurFilling);
        ingredient.add(chiliSauce);
        burger.moveIngredient(0, 1);
        Assert.assertEquals("Ingredient isn't moved!", burger.ingredients, ingredient);
    }

    @Test
    public void checkGetReceipt() {
        Burger burger = new Burger();
        burger.setBuns(blackBun);
        burger.addIngredient(dinosaurFilling);
        burger.addIngredient(chiliSauce);
        Mockito.when(blackBun.getName()).thenReturn("black bun");
        Mockito.when(chiliSauce.getName()).thenReturn("chili sauce");
        Mockito.when(dinosaurFilling.getName()).thenReturn("dinosaur");
        Mockito.when(chiliSauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(dinosaurFilling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(blackBun.getPrice()).thenReturn(100f);
        Mockito.when(dinosaurFilling.getPrice()).thenReturn(200f);
        String newGetReceipt = "(==== black bun ====)\n" +
                "= filling dinosaur =\n" +
                "= sauce chili sauce =\n" +
                "(==== black bun ====)\n" +
                "\n" +
                "Price: 400,000000" + "\n";
        String actualReceipt = burger.getReceipt();
        Assert.assertEquals("Receipt have incorrect information about burger!", newGetReceipt.replace("\r\n", "\n"), actualReceipt.replace("\r\n", "\n"));
    }
}
