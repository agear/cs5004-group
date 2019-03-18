package bst;

public class ElementNode implements BSTNode {

private Integer data;
private BSTNode left;
private BSTNode right;


  /** TODO add this lol
   * @param data
   * @param left
   * @param right
   */
  public ElementNode(int data, BSTNode left, BSTNode right){

    this.data = data;
    this.left = left;
    this.right = right;

  }

  /**
   * Inserts an object in the tree.
   *
   * @param object to insert
   */
  @Override
  public BSTNode add(Integer object) {

    // If object is less than current node, add to left
    if (object < this.data) {

      // If left exists, add it over there
      if (this.left != null ) {
        this.left = this.left.add(object);
        return this.left;
      }

      // If left doesn't exist, make a new leaf and
      // put the object as this node's left child
      else {
        BSTNode newNode = new Leaf(object);
        this.left = newNode;
        return this.left;
      }

    }

    // If we are adding something already in the tree, do nothing
    if (this.data == object ) {
      return this;
    }

    // Else, add to right
    else {

      if (this.left != null ) {
        this.right = this.right.add(object);
        return this.right;
      }

      else {
        BSTNode newNode = new Leaf(object);
        this.right = newNode;
        return this.right;
      }

    }

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
    return 0;
  }



  public String toString(){
    return " " + this.data.toString() + this.left.toString() + this.right.toString();
  }

}
