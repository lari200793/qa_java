import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {


     @Test
    public void checkGetFamily_shouldBeFeline(){
         Feline feline = new Feline();
         String expected = "Кошачьи";
         assertEquals(" должно быть семейство кошачьих",expected, feline.getFamily());
     }
     @Test
    public void checkGetKittens_shouldBeOne(){
         Feline feline= new Feline();
         int expected = 1;
         assertEquals(" должно быть равно одному",expected, feline.getKittens());

     }

    @Test
    public void checkGetKittens_shouldBeIntKittens(){
         Feline feline = new Feline();
         int actual = feline.getKittens(2);
         int expected = 2;
         assertEquals("Должно быть равно заданному значению", expected, actual);

     }
     @Test
    public void checkEatMeat_shouldBe() throws Exception {
         Feline feline = new Feline();
         List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals("Все кошачьи - хищники", expected, feline.eatMeat());

     }
}

