package bst;

public class ElementNode implements BSTNode {

private int data;
private BSTNode left;
private BSTNode right;

  /**
   * Inserts an object in the tree.
   *
   * @param object to insert
   */
  @Override
  public void add(int object) {

  }

  /**
   * Return the size of this tree (i.e. the number of elements in this tree.
   *
   * @return the the number of elements in this tree.
   */
  @Override
  public int getSize() {
    int sum = left.getSize();
    sum += right.getSize();
    return 1 + sum;
  }

  /**
   * Returns true if this object is present in the tree, false otherwise.
   *
   * @param present@return true if this object is present in the tree, false otherwise.
   */
  @Override
  public boolean present(int present) {
    if (this.data == present) {
      return true;
    }
    else {
      return (this.left.present(present) | this.right.present(present));
    }
  }

  /**
   * Returns the smallest object (defined by the ordering) in the tree, and null if the tree is
   * empty.
   *
   * @return the smallest object (defined by the ordering) in the tree, and null if the tree is
   * empty.
   */
  @Override
  public int minimum() {
    return this.left.minimum();
  }
}
