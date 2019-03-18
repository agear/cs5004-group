import org.junit.Test;
import static org.junit.Assert.assertEquals;

import bst.BSTImpl;
import bst.BST;

public class testBST {



  @Test
  public void testAdd(){


    BST testTree = new BSTImpl();
    testTree.add(20);
    testTree.toString();
    testTree.add(10);
    //testTree.add(30);
    System.out.println(testTree.toString());

  }


}
