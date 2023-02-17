package praktikum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredientMock;
    Burger burger;
    @Mock
    Ingredient secondIngredientMock;

    @Before
    public void setUp(){
        burger = new Burger();
    }

    @Test
    public void addIngredientsTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientMock);
        Assert.assertEquals(1, burger.ingredients.size());
    }
    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredientMock);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }
    @Test
    public void getPriceReturnCorrectTest(){
        burger.setBuns(bun);
        burger.addIngredient(ingredientMock);
        Mockito.when(bun.getPrice()).thenReturn(100.0f);
        Mockito.when(ingredientMock.getPrice()).thenReturn(200.0f);
        Assert.assertEquals(400.0f, burger.getPrice(), 0);
    }
    @Test
    public void moveIngredientTest(){
        Mockito.when(ingredientMock.getName()).thenReturn("sour cream");
        Mockito.when(secondIngredientMock.getName()).thenReturn("chili sauce");
        burger.addIngredient(ingredientMock);
        burger.addIngredient(secondIngredientMock);
        burger.moveIngredient(0,1);
        Assert.assertEquals("chili sauce", burger.ingredients.get(0).getName());
        Assert.assertEquals("sour cream", burger.ingredients.get(1).getName());
    }
    @Test
    public void getReceiptTest() {
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(ingredientMock.getName()).thenReturn("hot sauce");
        Mockito.when(ingredientMock.getType()).thenReturn(IngredientType.FILLING).toString().toLowerCase();
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredientMock.getPrice()).thenReturn(100f);
        burger.setBuns(bun);
        burger.addIngredient(ingredientMock);
        burger.addIngredient(ingredientMock);
        burger.getPrice();
        String expected = "(==== black bun ====)\r\n" +
                "= filling hot sauce =\r\n" +
                "= filling hot sauce =\r\n" +
                "(==== black bun ====)\r\n" +
                "\r\n" +
                "Price: 400,000000\r\n";
        Assert.assertEquals(expected, burger.getReceipt());
    }
}
