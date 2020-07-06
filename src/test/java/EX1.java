import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class EX1 {

    public double multiply(double a, double b) {
    //Scanner scanner = new Scanner(System.in);
    //a=scanner.nextInt();
    //b = scanner.nextInt();
     if (a >=0&& a<=100 && b >=0 && b <=100){
         double product = a* b;
         return product;
     }
    else return 0;
    }
    @DisplayName("Positive path for for multiplyTest")
@Test
    public void multiplyTest(){

    System.out.println(multiply(9,82));


}


    @DisplayName("Negative path for for multiplyTest")
    @Test
    public void negativeMultiplyTest() {
        System.out.println(multiply(-5, 101));
Assertions.assertTrue(false);
    }
}
