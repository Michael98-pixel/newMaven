import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Divide {
    //   @ParameterizedTest(name = "{index} => numberToBeDivided={0}, divisor={1}, quotient={2}")
//    @CsvSource( {"1, 3, 3"});

    public double divisionFunction(double numberToBeDivided, double divisor) {
        if (divisor == 0.0) {
            throw new IllegalArgumentException("Argument 'divisor' is 0");

        } else {
            return (numberToBeDivided / divisor);
        }
    }
@DisplayName("Positive path for for multiplyTest")
    @Test
    public void multiplyTest() {
        System.out.println(divisionFunction(9, 82));

    }
    @DisplayName("Positive path for for multiplyTest")
    @Test
    public void negativeMultiplyTest() {
        System.out.println(divisionFunction(9, 82));

    }
}
