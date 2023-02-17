package praktikum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[] ingredientsData() {
        return new Object[][]{
                {IngredientType.SAUCE, "sour cream", 100},
                {IngredientType.FILLING, "cutlet", 100}
        };
    }
    @Test
    public void getCorrectPriceTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals("Данные не совпадают", price, actualPrice, 0);
    }
    @Test
    public void getCorrectNameTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        String actualName = ingredient.getName();
        Assert.assertEquals("Данные не совпадают", name, actualName);
    }
    @Test
    public void getCorrectIngredientTypeTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actualType = ingredient.getType();
        Assert.assertEquals("Данные не совпадают", type, actualType);
    }
}


