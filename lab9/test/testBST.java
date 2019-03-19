import org.junit.Test;

import bst.BST;
import bst.BSTImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class testBST {


  @Test
  public void testAdd() {


    BST testTree = new BSTImpl();
    testTree.add(20);
    System.out.println(testTree.toString());
    assertEquals(1, (int) testTree.getSize());
    assertEquals(20, (int) testTree.minimum());
    testTree.add(10);
    assertEquals(10, (int) testTree.minimum());
    testTree.add(30);
    assertEquals(3, (int) testTree.getSize());
    testTree.add(5);
    testTree.add(1);
    //assertEquals(1, (int)testTree.minimum());
    assertTrue(testTree.present(5));
    // assertEquals(4, (int)testTree.getSize());
    //testTree.add(30);
    assertFalse(testTree.present(12));
    assertTrue(testTree.present(30));
    // assertEquals(3, (int)testTree.getSize());

    System.out.println(testTree.toString());

  }


}
