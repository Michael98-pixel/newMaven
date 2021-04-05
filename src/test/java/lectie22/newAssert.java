//package lectie22;
//
//import org.assertj.core.api.SoftAssertions;
//import org.hamcrest.MatcherAssert;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import static org.hamcrest.Matchers.*;
//
//public class newAssert {
//    @Test
//    public void checkAsBoolean(){
//double result = 1;
//int p = 7;
//        MatcherAssert.assertThat(result,allOf(
//                not(equalTo(0d)),
//                lessThan(33d),
//                greaterThan(0d)));
//
//        SoftAssertions softAssertions = new SoftAssertions();
//
//        softAssertions.assertThat(result).isEqualTo(1);
//        softAssertions.assertThat(result).isBetween(-1d,1d);
//        softAssertions.assertThat(result).isGreaterThan(-10);
//
//        softAssertions.assertAll();
//
////            Assertions.assertThat(result)
////    .isEqualsTo(0)
////        .isBetween(-1d,1d)
////        .isGreaterThan(-10)
////        .isLessThan(33)
////         .asString()
////        .startsWith("1");
//}
//// |ID|username|password|full name    |
//    // |1| cofstea|test1234|Bivol Constantin |
//    // |1| cofstea|test1234|Bivol Constantin |
//    // |1| cofstea|test1234|Bivol Constantin |
//    // |1| cofstea|test1234|Bivol Constantin |
//}
