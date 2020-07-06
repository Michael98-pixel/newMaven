import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionTestClass {
    @Test
    public void testException(){
        Assertions.assertThrows(RuntimeException.class,this ::throwExceptionOrSomething);
    }
    public void throwExceptionOrSomething(){

        throw new RuntimeException("Exception is thrown ");
    }
}
