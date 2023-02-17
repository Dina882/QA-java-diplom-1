package praktikum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final String ingredientType;
    public IngredientTypeTest(String ingredientType) {
        this.ingredientType = ingredientType;
    }
    @Parameterized.Parameters
    public static Object[][] getIngredientTypeParamTest(){
        return new Object[][] {
                {"FILLING"},
                {"SAUCE"},
        };
    }
    @Test
    public void checkIngredientTypeTest(){
        Assert.assertNotNull(IngredientType.valueOf(ingredientType));
    }
}

