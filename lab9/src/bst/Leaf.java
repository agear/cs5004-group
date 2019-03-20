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

    System.out.println("Entered leaf node [" + this.data + "] with this input: " + object);
    BSTNode newNode = new Leaf(object);


    if (object.compareTo(this.data) < 0) {
      // Put the new object below to the left.
      System.out.println("Input is less than this node. Adding left: " + newNode.getData());
      BSTNode convertedLead = new ElementNode(this.data, newNode, null);
      return convertedLead;
    } else {
      // Put the new object below to the right.
//      System.out.println("Input is more than this node. Adding right: " + newNode.getData());
      BSTNode convertedLead = new ElementNode(this.data, null, newNode);
//      System.out.println("New node = " + newNode.getData());
//      System.out.println("ConvertedLead = " + convertedLead.getData());
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
    System.out.println("Counting Leaf " + this.data);
    return 1;
  }

  /**
   * Returns true if this object is present in the tree, false otherwise.
   *
   * @param present@return true if this object is present in the tree, false otherwise.
   */
  @Override
  public boolean present(T present) {
    return (this.data.equals(present));
  }

  /**
   * Returns the smallest object (defined by the ordering) in the tree, and null if the tree is
   * empty.
   *
   * @return the smallest object (defined by the ordering) in the tree, and null if the tree is
   * empty.
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


  //TODO delete this before handing it in
  public T getData() {
    return this.data;
  }

  //TODO we can find the rank of an element p in the tree rooted at node T as follows:
  // If T contains p as its data, its rank in this tree is 1+size of left subtree of T.
  // If p is in the left subtree of T, then its rank in T would be whatever its rank is in the left
  // subtree of T.
  // If p is in the right subtree of T, then its rank in T would be whatever its rank in the right
  // subtree of T, plus the number of elements before it in T which is 1 + size of left subtree of T.
  // If T is an empty node, p is not present in the tree, so its rank cannot be computed. In this
  // case, return 0 as its rank.
  public int rank(T obj) {
    return 0;
  }

  // TODO let size(T) be the size of the tree T. Then the element at a specific rank x in tree
  //  rooted at node T can be found as follows: Compute r=1+size of left subtree of T.
  //  If r=x then return the data at this node and exit.
  //  If r<x then the element of rank x must be in the right subtree of T. However its rank
  //  there would be x-r. So look for element of rank x-r in the right subtree of T.
  //  If r>x then the element of rank x must be in the left subtree of T. So look for element of
  //  rank x in the left subtree of T.
  //  If T is an empty node, the rank x is invalid. Return null as the result.
  public T select(int rank) {
    Integer empty = 0;
    return (T) empty;
  }
}
