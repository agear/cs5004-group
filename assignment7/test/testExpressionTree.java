import org.junit.Test;

import java.util.HashMap;

import expression.ExpressionTree;

import static org.junit.Assert.assertEquals;

public class testExpressionTree {


  @Test
  public void testA() {
    ExpressionTree testTreeAdd = new ExpressionTree("1 2 +");
    ExpressionTree testTreeMult = new ExpressionTree("2 3 *");
    ExpressionTree testTreeSub = new ExpressionTree("2 3 -");
    ExpressionTree testTreeDiv = new ExpressionTree("6 3 /");
    ExpressionTree testLongerExpression = new ExpressionTree("4 5 6 * +");


    HashMap<String, Double> valueMap = new HashMap<>();
    valueMap.put("a", 1.0);
    valueMap.put("b", 2.0);
    valueMap.put("c", 3.0);
    valueMap.put("d", 4.0);


    assertEquals(3.0, testTreeAdd.evaluate(valueMap), .001);
    assertEquals(6.0, testTreeMult.evaluate(valueMap), .001);
    assertEquals(-1.0, testTreeSub.evaluate(valueMap), .001);
    assertEquals(2.0, testTreeDiv.evaluate(valueMap), .001);
    assertEquals(34, testLongerExpression.evaluate(valueMap), .001);


  }

  //TODO Test that invalid expressions throw execeptions.


//  public void testConstructor() {
//
//  // THIS will be marked as an error because you're supposed to assert something in junit tests.
//  // soooo... TODO delete this when we don't need it anymore
//
//  @Test
//  public void testValidConstructor(){
//
//    // All of these should work
//    ExpressionTree testTree = new ExpressionTree("a b +");
//    testTree = new ExpressionTree("x y *   c + ");
//    testTree = new ExpressionTree("3 2 + 65.12 -");
//    testTree = new ExpressionTree("3 5 + a -");
//
//  }
//
//  @Test(expected = IllegalArgumentException.class)
//  public void testInvalidConstructor1(){
//    // Too few operators
//    ExpressionTree testTree = new ExpressionTree("a b ");
//  }
//
//  @Test(expected = IllegalArgumentException.class)
//  public void testInvalidConstructor2(){
//    // Too few operands
//    ExpressionTree testTree = new ExpressionTree("a +");
//  }
//
//  @Test(expected = IllegalArgumentException.class)
//  public void testInvalidConstructor3(){
//    // Empty/uninitialized tree is not allowed
//    ExpressionTree testTree = new ExpressionTree("");
//  }
//
//
//  @Test
//  public void testInfix(){
//
//
//    // All of these should work
//    ExpressionTree testTree = new ExpressionTree("a b +");
//    assertEquals("( a + b )", testTree.infix());
//
//    testTree = new ExpressionTree("a b c * +");
//    assertEquals("( a + ( b * c ) ),", testTree.infix());
//
//
//    testTree = new ExpressionTree("a b + c *");
//    assertEquals("( ( a + b ) * c )", testTree.infix());
//
//
//    testTree = new ExpressionTree("a b + c d + *");
//    assertEquals("( ( a + b ) * ( c + d ) )", testTree.infix());
//
//
//  }
//
//  @Test
//  public void testEvaluate(){
//
//
//    ExpressionTree testTree = new ExpressionTree("a b +");
//    HashMap<String,Double> valueMap = new HashMap<>();
//    valueMap.put("a",1.0);
//    valueMap.put("b",2.0);
//    valueMap.put("c",3.0);
//    valueMap.put("d",4.0);
//
//
//    assertEquals(3.0, testTree.evaluate(valueMap),.001);
//
//    testTree = new ExpressionTree("a b c * +");
//    assertEquals(7.0, testTree.evaluate(valueMap),.001);
//
//
//    testTree = new ExpressionTree("a b + c *");
//    assertEquals(9.0, testTree.evaluate(valueMap),.001);
//
//
//    testTree = new ExpressionTree("a b + c d + *");
//    assertEquals(36.0, testTree.evaluate(valueMap),.001);
//
//
//
//  }
//


}
