import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * A JUnit test class for the InfixExpression class.
 */
public class InfixExpressionTest {

  InfixExpression goodTestExpression;
  InfixExpression goodTestExpressionWithParentheses;
  PostfixExpression conversion;
  PostfixExpression conversionWithParenthesis;
  InfixExpression webtest1;
  InfixExpression webtest2;
  InfixExpression letters;
  InfixExpression illegal;

  @Before
  public void setUpTest() throws Exception {
    goodTestExpression = new InfixExpression("1 + 5 * 4 + 3");
    goodTestExpressionWithParentheses = new InfixExpression("( 2 + 5 ) * ( 3 - 4 )");
    // TODO figure out incorrect popping.
    webtest1 = new InfixExpression("( 5 + 4 ) * ( ( 4 + 8 ) / 6 ) + 2");
    webtest2 = new InfixExpression("1 - 2 + 3");
    letters = new InfixExpression("a + b + e");
  }

  //TODO Fix incorrect exception.

  //  @Test(expected = IllegalArgumentException.class)
  //  public void infixExpresssionConstructorIllegalArgumentExceptionTest() {
  //    illegal = new InfixExpression( "( 1 ( ) ( 3 ) + - ) )" );
  //  }

  @Test
  public void toPostfixTest() {
    //  conversion = goodTestExpression.toPostfix();
    //assertEquals(24, conversion.evaluate(), 0.001);
    conversionWithParenthesis = goodTestExpressionWithParentheses.toPostfix();
    assertEquals(-7, conversionWithParenthesis.evaluate(), 0.001);
  }

  @Test
  public void evaluateTest() {
    assertEquals(24, goodTestExpression.evaluate(), 0.001);
    assertEquals(-7, goodTestExpressionWithParentheses.evaluate(),0.001);
    assertEquals(2, webtest2.evaluate(), 0.001);
    assertEquals(20, webtest1.evaluate(), 0.001);

  }

  @Test
  public void toStringTest() {
    assertEquals("1 + 5 * 4 + 3", goodTestExpression.toString());
    assertEquals("( 2 + 5 ) * ( 3 - 4 )", goodTestExpressionWithParentheses.toString());
  }
}
