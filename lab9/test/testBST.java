import org.junit.Test;

import bst.BST;
import bst.BSTImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class testBST {


//  @Test
//  public void testAdd() {
//
//
//    BST testTree = new BSTImpl();
//    assertEquals(0, (int) testTree.getSize());
//    testTree.add(20);
//    System.out.println(testTree.toString());
//    assertEquals(1, (int) testTree.getSize());
//    assertEquals(20, (int) testTree.minimum());
//    testTree.add(20);
//    testTree.add(30);
//    assertEquals(2, (int) testTree.getSize());
//    testTree.add(10);
//    assertEquals(10, (int) testTree.minimum());
//    assertEquals(2, (int) testTree.getSize());
//    testTree.add(30);
//    assertEquals(3, (int) testTree.getSize());
//    testTree.add(5);
//    testTree.add(1);
//    //assertEquals(1, (int)testTree.minimum());
//    assertTrue(testTree.present(5));
//    // assertEquals(4, (int)testTree.getSize());
//    //testTree.add(30);
//    assertFalse(testTree.present(12));
//    assertTrue(testTree.present(30));
//    // assertEquals(3, (int)testTree.getSize());
//
//    System.out.println(testTree.toString());
//
//  }

  @Test
  public void testAddRight() {


    BST testTree = new BSTImpl();
    assertEquals(0, (int) testTree.getSize());
    testTree.add(1);
    //System.out.println(testTree.toString());
    assertEquals(1, (int) testTree.getSize());
    assertEquals(1, (int) testTree.minimum());
    testTree.add(2);
    //System.out.println("Moving on...");
    assertEquals(2, (int) testTree.getSize());
   // System.out.println("Moving on2...");
    //testTree.toString();
    testTree.add(2);
    testTree.add(3);
    testTree.add(4);
    System.out.println("TO STRING: " + testTree.toString());
    assertEquals(3, (int) testTree.getSize());
    testTree.add(4);
    assertEquals(1, (int) testTree.minimum());
    assertEquals(4, (int) testTree.getSize());
    testTree.add(30);
    assertEquals(5, (int) testTree.getSize());
//    testTree.add(5);
//    testTree.add(1);
    //assertEquals(1, (int)testTree.minimum());
    assertTrue(testTree.present(4));
    // assertEquals(4, (int)testTree.getSize());
    //testTree.add(30);
    assertFalse(testTree.present(12));
    assertTrue(testTree.present(30));
    // assertEquals(3, (int)testTree.getSize());

    System.out.println(testTree.toString());

  }
}
