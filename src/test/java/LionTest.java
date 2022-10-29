import com.example.Feline;
import com.example.Lion;
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
public class LionTest {
    private String sex;
    private int kittens;
    private boolean hasMane;
    public LionTest (String sex, int kittens, boolean hasMane){
        this.sex = sex;
        this.kittens = kittens;
        this.hasMane = hasMane;
    }
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Parameterized.Parameters
    public static Object[][] getSex() {
        return new Object[][]{
                {"Самка",2, false},
                {"Самец",3, true},
                {"    ", 5, false},
        };
    }

    @Test
    public void checkGetKitten_shouldBeOneKitten() throws Exception {
        Feline mockLion = Mockito.mock(Feline.class);
        try {Lion lion = new Lion(sex, mockLion);
            Mockito.when(mockLion.getKittens()).thenReturn(1);
            int expected = 1;
            assertEquals(" должно быть равно одному", expected, lion.getKittens());
        } catch (Exception exception) {
            Assert.assertEquals("Используйте допустимые значения пола животного - Самец или Самка", exception.getMessage());
        }

    }
    @Test
    public void checkGetKitten_shouldBeKittens(){
        Feline mockLion = Mockito.mock(Feline.class);
        try {Lion lion = new Lion(sex, mockLion);
            Mockito.when(mockLion.getKittens(kittens)).thenReturn(kittens);
            int expected = kittens;
            assertEquals(" должно быть равно ", expected, lion.getKittens(kittens));
        } catch (Exception exception) {
            Assert.assertEquals("Используйте допустимые значения пола животного - Самец или Самка", exception.getMessage());
        }
    }
    @Test
    public void checkDoesHaveMane(){
        Feline mockLion = Mockito.mock(Feline.class);
        try {Lion lion = new Lion(sex, mockLion);
            boolean expected = hasMane;
            assertEquals(" должно быть равно ", expected,lion.doesHaveMane());
        } catch (Exception exception) {
            Assert.assertEquals("Используйте допустимые значения пола животного - Самец или Самка", exception.getMessage());
        }
    }
    @ Test
    public void checkGetFood(){
        Feline mockLion = Mockito.mock(Feline.class);
        try {Lion lion = new Lion(sex, mockLion);
            List<String> expected = List.of("Животные", "Птицы", "Рыба");
            Mockito.when(mockLion.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            assertEquals(" должно быть равно ", expected,lion.getFood());
        } catch (Exception exception) {
            Assert.assertEquals("Используйте допустимые значения пола животного - Самец или Самка", exception.getMessage());
        }
    }

}
