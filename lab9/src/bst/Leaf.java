package bst;

/**
 * Leaf represents a node with no children in a binary search tree.
 */
public class Leaf<T extends Comparable<T>> implements BSTNode<T> {

  private T data;
  private int progeny;


  /**
   * Creates a leaf in a binary search tree. It must be initialized with data to hold.
   *
   * @param data information to store in this node
   */
  public Leaf(T data) {
    this.data = data;
    this.progeny = 1;
  }


  /**
   * Inserts an object in the tree.
   *
   * @param object to insert
   */
  @Override
  public BSTNode add(T object) {

    BSTNode newNode = new Leaf(object);


    if (object.compareTo(this.data) < 0) {
      // Put the new object below to the left.
      BSTNode convertedLead = new ElementNode(this.data, newNode, null);
      return convertedLead;
    } else {
      // Put the new object below to the right.
      BSTNode convertedLead = new ElementNode(this.data, null, newNode);
      return convertedLead;
    }

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
   * @param present the object to check whether or not is present in the tree.
   * @return true if this object is present in the tree, false otherwise.
   */
  @Override
  public boolean present(T present) {
    return (this.data.equals(present));
  }

  /**
   * Returns the smallest object (defined by the ordering) in the tree, and null if the tree is
   * empty.
   *
   * @return the smallest object (defined by the ordering) in the tree
   */
  @Override
  public T minimum() {
    return this.data;
  }


  /**
   * Represents a printable string with no fancy formatting, just the data that is stored.
   */
  @Override
  public String toString() {
    return " " + this.data;
  }

  /**
   * Finds the rank of an element in the tree. If the element does not exist in the tree, return 0.
   *
   * @param p the element to find the rank of.
   * @return an int representing the rank of an element in the tree.
   */
  public int rank(T p) {

    // (1) If T contains p as its data, its rank in this tree is 1+size of left subtree of T.
    if (this.data.equals(p)) {
      return 1;
    }

    // (4) If T is an empty node, p is not present in the tree, so its rank cannot be computed.
    // In this case, return 0 as its rank.

    return 0;

  }

  /**
   * Returns the object at a specific rank in the tree. If no object exists with the given rank,
   * return null as the result.
   *
   * @param x the rank of the object to return.
   * @return Object of the specified rank. If no object exists with given rank, return null.
   */
  public T select(int x) {

    // r = 1 + size of left subtree
    int r = 1;

    // If rSize is equal to x, then return the data at this node and exit
    if (r == x) {
      return this.data;
    }

    // If T is an empty node, the rank x is invalid. Return null as the result.
    else {
      return null;
    }

  }


  /**
   * Gets the size of the subtree of a node.
   *
   * @return the size of the subtree this node.
   */
  public int getProgeny() {
    return this.progeny;
  }

}
