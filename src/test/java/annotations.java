import org.junit.jupiter.api.*;

@DisplayName("My first test of even numbers")
public class annotations {
    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    public String adultAge(int age) {
        return age >= 18 ? "Yes" : "No";
    }
@RepeatedTest(5)
    @Test
    public void myFirstTest() {
        System.out.println("Here is my first test.");
    }

    @Test

    public void mySecondTest() {
        System.out.println("Second test.");
    }
@DisplayName("Happy path for is even functionality ")
    @Test
    public void isEvenTest() {        boolean result = isEven(20);
        Assertions.assertTrue(result);

    }
    @DisplayName("Negative path for is even functionality ")
    @Test
    public void isNotEvenTest() {
        boolean result = isEven(19);
        Assertions.assertFalse(result);
    }
    @DisplayName("Test the adult age functionality returning expected Yes or No")
    @Test
    public void ageAdultTest() {
        String actual = adultAge(18);
        Assertions.assertEquals("Yes", actual);
    }
    @Test
    public void ageAdultNegativeTest() {
        String actual = adultAge(17);
        Assertions.assertEquals("No", actual);
    }
}
