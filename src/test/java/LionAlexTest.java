import com.example.Feline;
import com.example.LionAlex;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class LionAlexTest {
    private String sex;
     public LionAlexTest (String sex){
        this.sex = sex;
    }
    @Parameterized.Parameters
    public static Object[][] getSex() {
        return new Object[][]{
                {"Самка"},
                {"Самец"},
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
     public void checkGetKittens_shouldBeZero() throws Exception {
        Feline mockLionAlex = Mockito.mock(Feline.class);
        try {LionAlex lionAlex = new LionAlex( sex,mockLionAlex);
            int expected = 0;
            assertEquals(" У Алекса нет  львят", expected, lionAlex.getKittens());
        } catch (Exception exception) {
            Assert.assertEquals("Используйте допустимые значения пола животного. Лев Алекс - Самец ", exception.getMessage());
        }

     }
    @Test
    public void checkDoesHaveMane_shouldBeTrue(){
        Feline mockLionAlex = Mockito.mock(Feline.class);
        try {LionAlex lionAlex = new LionAlex( sex,mockLionAlex);
            boolean expected = true;
            assertEquals(" У Алекса есть грива", expected, lionAlex.doesHaveMane());
        } catch (Exception exception) {
            Assert.assertEquals("Используйте допустимые значения пола животного. Лев Алекс - Самец ", exception.getMessage());
        }
    }
    @Test
    public void checkGetFood_shouldEatMeat(){
        Feline mockLionAlex = Mockito.mock(Feline.class);
        try {LionAlex lionAlex = new LionAlex( sex,mockLionAlex);
            List<String> expected = List.of("Животные", "Птицы", "Рыба");
            Mockito.when(mockLionAlex.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            assertEquals("Алекс - хищник ", expected, lionAlex.getFood());
        } catch (Exception exception) {
            Assert.assertEquals("Используйте допустимые значения пола животного. Лев Алекс - Самец ", exception.getMessage());
        }
    }
     @Test
    public void checkGetFriends_shouldBeList(){
         Feline mockLionAlex = Mockito.mock(Feline.class);
         try {LionAlex lionAlex = new LionAlex( sex,mockLionAlex);
             List<String> expected = List.of("Зебра Марти"," Бегемотиха Глория","Жираф Мелман");
             assertEquals("Друзья Алекса: Мартиб Глория, Мелман ", expected, lionAlex.getFriends());
         } catch (Exception exception) {
             Assert.assertEquals("Используйте допустимые значения пола животного. Лев Алекс - Самец ", exception.getMessage());
         }
     }
     @Test
    public void checkGetPlaceOfLiving_ShouldBeNewYork(){
         Feline mockLionAlex = Mockito.mock(Feline.class);
         try {LionAlex lionAlex = new LionAlex( sex,mockLionAlex);
             String expected = "Нью-Йорский зоопарк";
             assertEquals("Живет Алекс в Нью-Йорском зоопарке", expected, lionAlex.getPlaceOfLiving());
         } catch (Exception exception) {
             Assert.assertEquals("Используйте допустимые значения пола животного. Лев Алекс - Самец ", exception.getMessage());
         }
     }
}
