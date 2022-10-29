import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline mockCat;
    @Test
    public void checkGetSound_getMyau() {
        Cat cat = new Cat(mockCat);
        String expected = "Мяу";
        assertEquals("Кот должен мяукать",expected, cat.getSound());
    }


    @Test
    public void   checkGetFood_shouldEatMeet() throws Exception {
        Cat cat = new Cat(mockCat);
        Mockito.when(mockCat.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(" Ожидается, что кот питается животными, птицами,рыбой " ,expected,cat.getFood());
        }



}