package praktikum;
import org.junit.Assert;
import org.junit.Test;

public class BunTest {
    Bun bun = new Bun("white bun", 200);
    @Test
    public void getPriceTest(){
        Assert.assertEquals(200, bun.getPrice(), 0);
    }
    @Test
    public void getNameTest(){
        Assert.assertEquals("white bun", bun.getName());
    }
}