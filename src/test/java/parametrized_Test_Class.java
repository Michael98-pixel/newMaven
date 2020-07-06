import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)

public class parametrized_Test_Class {
    @ParameterizedTest(name = "Test with the {argument} test data at {index} try ")
    @CsvSource(value = {"SSs,SSS","AAA,AAA","123,123"})
    public void testUpperCaseMethod(String string, String expectedValue){
         String actual = string.toUpperCase();
        Assertions.assertEquals(expectedValue,actual);
    }

@ParameterizedTest
@NullSource
@EmptySource
public void testIsBlankString(String input){
    Assertions.assertTrue(StringUtils.isBlank(input));
}
}