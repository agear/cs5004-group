import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.fail;

import static org.junit.Assert.assertEquals;

/**
 * A JUnit test class for the PostfixExpression class.
 */
public class PostfixExpressionTest {

  PostfixExpression goodTestExpression;
  PostfixExpression simpleGoodTestExpression;
  PostfixExpression badTestExpression;
  PostfixExpression notEnoughOperandsMult;
  PostfixExpression notEnoughOperandsAdd;
  PostfixExpression notEnoughOperandsSub;
  PostfixExpression notEnoughOperandsDiv;
  PostfixExpression testExpresionWithSubtraction;
  PostfixExpression testExpresionWithDivision;
  PostfixExpression testDoubleDigit;
  PostfixExpression testMultiDigit;
  PostfixExpression testSpacing;
  PostfixExpression huh;
  PostfixExpression failedWebTest;

  @Before
  public void setUpTest() {
    goodTestExpression = new PostfixExpression("2 5 3 * + 4 +");
    simpleGoodTestExpression = new PostfixExpression("3 2 +");
    testExpresionWithSubtraction = new PostfixExpression("2 5 3 * + 4 -");

    testExpresionWithSubtraction = new PostfixExpression("2 5 3 * + 4 -");
    testExpresionWithDivision = new PostfixExpression("2 4 /");

    testDoubleDigit = new PostfixExpression("15 15 +");
    testMultiDigit = new PostfixExpression("25 1000 -");
    testSpacing = new PostfixExpression("   2  5    3  *    +  4     + ");
   // huh = new PostfixExpression("2 5 + 3 4 -");
    failedWebTest = new PostfixExpression("a b d + c +");

  }

  @Test(expected = ArithmeticException.class)
  public void postfixExpresssionConstructorIllegalArgumentExceptionTest() {
    badTestExpression = new PostfixExpression("a b c * + d +");
    assertEquals("a b c * + d +", badTestExpression.toString());
    assertEquals(20, badTestExpression.evaluate(), 0.001);
  }

  @Test(expected = IllegalArgumentException.class)
  public void evaluateMultArithmeticExceptionTest() {
    notEnoughOperandsMult = new PostfixExpression("2 *");
  }

  @Test(expected = IllegalArgumentException.class)
  public void failedWebTest() {
    failedWebTest = new PostfixExpression("a b d + c +");
  }

  @Test(expected = IllegalArgumentException.class)
  public void evaluateAddArithmeticExceptionTest() {
    notEnoughOperandsAdd = new PostfixExpression("2 +");
  }

  @Test(expected = IllegalArgumentException.class)
  public void evaluateSubArithmeticExceptionTest() {
    notEnoughOperandsSub = new PostfixExpression("2 -");
  }

  @Test//(expected = IllegalArgumentException.class)
  public void evaluateDivArithmeticExceptionTest() {
    try {
      notEnoughOperandsDiv = new PostfixExpression("2 /");
      fail("An exception should have been thrown");
    }
    catch (IllegalArgumentException e) {

    }
  }

  @Test
  public void evaluateTest() {
    assertEquals(5, simpleGoodTestExpression.evaluate(), 0.001);
    assertEquals(21, goodTestExpression.evaluate(), 0.001);
    assertEquals(21, testSpacing.evaluate(), 0.001);
    assertEquals(13, testExpresionWithSubtraction.evaluate(), 0.001);
    assertEquals(0.5, testExpresionWithDivision.evaluate(), 0.001);
    assertEquals(30, testDoubleDigit.evaluate(), 0.001);
    assertEquals(-975, testMultiDigit.evaluate(), 0.001);
    assertEquals(1, failedWebTest.evaluate(), 0.001);
  }

  @Test
  public void toStringTest() {
    assertEquals("2 5 3 * + 4 +", goodTestExpression.toString());
  }
}
