package bst;

public class Leaf implements BSTNode {

  private int data;

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
    return 1;
  }

  /**
   * Returns true if this object is present in the tree, false otherwise.
   *
   * @param present@return true if this object is present in the tree, false otherwise.
   */
  @Override
  public boolean present(int present) {
    return (this.data == present);
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
    return 0;
  }
}
