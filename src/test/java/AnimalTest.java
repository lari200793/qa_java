import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class AnimalTest {
    private String animalKind;
    private List<String> expected;
    public AnimalTest(String animalKind,List<String> expected){
        this.animalKind = animalKind;
        this.expected = expected;
    }
    @Parameterized.Parameters
    public static Object[][] getAnimalKind() {
        return new Object[][]{
                {"Травоядное",List.of("Трава", "Различные растения")},
                {"Хищник",List.of("Животные", "Птицы", "Рыба")},
                {"травoядное",List.of("Животные", "Птицы", "Рыба")},
                {"хищник",List.of("Животные", "Птицы", "Рыба")}
        };
    }
    @Test
    public void checkGetFood(){
        Animal animal= new Animal();
        try {
            assertEquals( expected,animal.getFood(animalKind));

        } catch (Exception exception) {
            Assert.assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
        }

    }
    @Test
    public void checkGetFamily_ShouldBeString(){
        Animal animal = new Animal();
        try{
            assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", animal.getFamily());
        }catch (Exception exception) {
            Assert.assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
        }
    }

}
