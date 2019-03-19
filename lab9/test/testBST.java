import org.junit.Test;

import bst.BST;
import bst.BSTImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class testBST {

  @Test
  public void testGetSize() {

    // Create a new tree
    BST testTree = new BSTImpl();
    assertEquals(0, (int) testTree.getSize());

    // Size == 1
    testTree.add(1);
    assertEquals(1, (int) testTree.getSize());
    assertEquals(1, (int) testTree.minimum());

    // Size == 2
    testTree.add(2);
    assertEquals(2, (int) testTree.getSize());

    // Size == 3
    testTree.add(3);
    assertEquals(3, (int) testTree.getSize());

    // Size == 4
    testTree.add(4);
    assertEquals(4, (int) testTree.getSize());

    // Size == 5
    testTree.add(30);
    assertEquals(5, (int) testTree.getSize());


    testTree.add(10);
    assertEquals(6, (int) testTree.getSize());

    // Size == 5
    testTree.add(19);
    assertEquals(7, (int) testTree.getSize());

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
  public void testPresent(){
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

}
