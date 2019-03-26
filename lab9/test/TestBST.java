import org.junit.Test;

import bst.BST;
import bst.BSTImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests methods in BSTImpl class.
 */
public class TestBST {

  @Test
  public void testGetSize() {

    // Create a new tree
    BST testTree = new BSTImpl();
    assertEquals(0, testTree.getSize());

    // Size == 1
    testTree.add(1);
    assertEquals(1, testTree.getSize());
    assertEquals(1, testTree.minimum());

    // Size == 2
    testTree.add(2);
    assertEquals(2, testTree.getSize());

    // Size == 3
    testTree.add(3);
    assertEquals(3, testTree.getSize());

    // Size == 4
    testTree.add(4);
    assertEquals(4, testTree.getSize());

    // Size == 5
    testTree.add(30);
    assertEquals(5, testTree.getSize());

    // Size == 6
    testTree.add(10);
    assertEquals(6, testTree.getSize());

    // Size == 7
    testTree.add(19);
    assertEquals(7, testTree.getSize());

  }


  @Test
  public void testMinimum() {

    // Create a new tree with negatives and a zero and in not chronological order
    BST testTree = new BSTImpl();
    testTree.add(-100);
    testTree.add(-50);
    testTree.add(0);
    testTree.add(4);
    testTree.add(-10);
    testTree.add(100);
    Integer expected = -100;
    assertEquals(expected, testTree.minimum());

  }


  @Test
  public void testPresent() {
    BST testTree = new BSTImpl();
    testTree.add(-100);
    testTree.add(-50);
    testTree.add(4);
    testTree.add(-10);
    testTree.add(100);
    Integer obj = -100;
    assertTrue(testTree.present(obj));

    obj = 0;
    assertFalse(testTree.present(obj));

    testTree.add(0);
    assertTrue(testTree.present(obj));

    obj = -10;
    assertTrue(testTree.present(obj));

    obj = -1;
    assertFalse(testTree.present(obj));


  }


  @Test
  public void testSelectNodeAtRank() {


    // Create a new tree with negatives and a zero and in not chronological order
    BST testTree = new BSTImpl();
    testTree.add(-100);
    testTree.add(-50);
    testTree.add(0);
    testTree.add(4);
    testTree.add(-10);
    testTree.add(100);

    Integer expected = -100;
    assertEquals(expected, testTree.select(1));

    expected = -50;
    assertEquals(expected, testTree.select(2));

    expected = -10;
    assertEquals(expected, testTree.select(3));

    expected = 0;
    assertEquals(expected, testTree.select(4));

    expected = 4;
    assertEquals(expected, testTree.select(5));

    expected = 100;
    assertEquals(expected, testTree.select(6));

    testTree.add(-5);
    testTree.add(-7);

    expected = -5;
    assertEquals(expected, testTree.select(5));


  }

  @Test
  public void testFindRankOfElement() {


    // Create a new tree with negatives and a zero and in not chronological order
    BST testTree = new BSTImpl();
    testTree.add(-100);
    testTree.add(-50);
    testTree.add(0);
    testTree.add(4);
    testTree.add(-10);
    testTree.add(100);

    Integer input = -100;
    assertEquals(1, testTree.rank(input));

    input = -50;
    assertEquals(2, testTree.rank(input));

    input = -10;
    assertEquals(3, testTree.rank(input));

    input = 0;
    assertEquals(4, testTree.rank(input));

    assertTrue(testTree.present(4));

    input = 4;
    assertEquals(5, testTree.rank(input));

    input = 100;
    assertEquals(6, testTree.rank(input));

    testTree.add(-5);
    input = -5;
    assertEquals(4, testTree.rank(input));

    testTree.add(-7);
    input = -7;
    assertEquals(4, testTree.rank(input));


  }


  @Test
  public void testGetSizeDouble() {

    // Create a new tree
    BST testTree = new BSTImpl();
    assertEquals(0, testTree.getSize());

    // Size == 1
    testTree.add(1.1);
    assertEquals(1, testTree.getSize());
    assertEquals(1.1, testTree.minimum());

    // Size == 2
    testTree.add(2.0);
    assertEquals(2, testTree.getSize());

    // Size == 3
    testTree.add(3.0);
    assertEquals(3, testTree.getSize());

    // Size == 4
    testTree.add(4.0);
    assertEquals(4, testTree.getSize());

    // Size == 5
    testTree.add(30.0);
    assertEquals(5, testTree.getSize());

    // Size == 6
    testTree.add(10.5);
    assertEquals(6, testTree.getSize());

    // Size == 7
    testTree.add(19.7893);
    assertEquals(7, testTree.getSize());

  }


  @Test
  public void testMinimumDouble() {

    // Create a new tree with negatives and a zero and in not chronological order
    BST testTree = new BSTImpl();
    testTree.add(-100.50);
    testTree.add(-50.2);
    testTree.add(0.0999);
    testTree.add(4.32);
    testTree.add(-10.87);
    testTree.add(-100.49);
    double expected = -100.50;
    assertEquals(expected, testTree.minimum());

  }


  @Test
  public void testPresentDouble() {
    BST testTree = new BSTImpl();
    testTree.add(-100.1);
    testTree.add(-50.2);
    testTree.add(4.3);
    testTree.add(-10.4);
    testTree.add(100.5);
    double obj = -100.1;
    assertTrue(testTree.present(obj));

    obj = 0.01;
    assertFalse(testTree.present(obj));

    testTree.add(0.01);
    assertTrue(testTree.present(obj));

    obj = -10.4;
    assertTrue(testTree.present(obj));

    obj = -1;
    assertFalse(testTree.present(obj));


  }


  @Test
  public void testSelectNodeAtRankDouble() {


    // Create a new tree with negatives and a zero and in not chronological order
    BST testTree = new BSTImpl<>();
    testTree.add(-100.1);
    testTree.add(-50.2);
    testTree.add(0.3);
    testTree.add(4.4);
    testTree.add(-10.5);
    testTree.add(100.6);

    double expected = -100.1;
    assertEquals(expected, testTree.select(1));

    expected = -50.2;
    assertEquals(expected, testTree.select(2));

    expected = -10.5;
    assertEquals(expected, testTree.select(3));

    expected = 0.3;
    assertEquals(expected, testTree.select(4));

    expected = 4.4;
    assertEquals(expected, testTree.select(5));

    expected = 100.6;
    assertEquals(expected, testTree.select(6));

    testTree.add(-5.7);
    testTree.add(-7.9);

    expected = -5.7;
    assertEquals(expected, testTree.select(5));


  }

  @Test
  public void testFindRankOfElementDouble() {


    // Create a new tree with negatives and a zero and in not chronological order
    BST testTree = new BSTImpl<>();
    testTree.add(-100.1);
    testTree.add(-50.2);
    testTree.add(0.3);
    testTree.add(4.4);
    testTree.add(-10.5);
    testTree.add(100.6);

    double input = -100.1;
    assertEquals(1, testTree.rank(input));

    input = -50.2;
    assertEquals(2, testTree.rank(input));

    input = -10.5;
    assertEquals(3, testTree.rank(input));

    input = 0.3;
    assertEquals(4, testTree.rank(input));

    assertTrue(testTree.present(4.4));

    input = 4.4;
    assertEquals(5, testTree.rank(input));

    input = 100.6;
    assertEquals(6, testTree.rank(input));

    testTree.add(-5.7);
    input = -5.7;
    assertEquals(4, testTree.rank(input));

    testTree.add(-7.8);
    input = -7.8;
    assertEquals(4, testTree.rank(input));



  }


  @Test
  public void emptyTree() {
    BSTImpl<Double> emptyTree = new BSTImpl<>();
    assertEquals(0, emptyTree.rank(1.0));
    assertEquals(0, emptyTree.getSize());
    assertEquals(null, emptyTree.minimum());
    double input = 4;
    assertFalse(emptyTree.present(input));
    assertEquals(null, emptyTree.select(3));

  }
}
