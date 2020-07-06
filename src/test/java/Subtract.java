import org.junit.jupiter.api.Test;

public class Subtract {

    public int subtract(int firstNumber, int secondNumber){

        if ( firstNumber> secondNumber && secondNumber >= 0 ) {
            return firstNumber-secondNumber;
        } return -1;
    }
    @Test
    public void subtractTest() {
        System.out.println(subtract(95, 82));
    }
}
