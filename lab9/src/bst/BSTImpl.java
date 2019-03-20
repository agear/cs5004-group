package bst;

/**
 * This class represents a binary search tree. It can add, it can get its size, it can detect if an
 * inputted object is present, and it can find the minimum object.
 */
public class BSTImpl<T extends Comparable<T>> implements BST<T> {

  private BSTNode root;


  /**
   * Creates an empty BST.
   */
  public BSTImpl() {
    // No data initialization needed
  }

  /**
   * Adds a comparable object to the tree in its proper place.
   *
   * @param obj The object to put in the tree
   */
  @Override
  public void add(T obj) {
    // TODO Delete debugging print statements.
    //    System.out.println("Trying to add " + obj);

    // If the tree is empty, this object is the root node.
    if (this.root == null) {
      BSTNode newNode = new Leaf(obj);
      this.root = newNode;
//      System.out.println("New root node. The root now is: " + this.root.getData());
      return;
    }
    // If the tree already contains the node, do nothing.
    if (this.root.present(obj)) {
//      System.out.println(obj + " is already in the tree!");
      return;
    }

    this.root = this.root.add(obj);
    System.out.println("The root after adding is: " + this.root.getData() + "\n");
    return;
  }

  /**
   * Counts the number of objects in this data structre.
   *
   * @return the number of objects
   */
  @Override
  public int getSize() {

    // If the tree is empty, the tree is empty
    if (this.root == null) {
      return 0;
    }

    return this.root.getSize();

  }

  /**
   * Iterates through the tree attempting to find the specified object.
   *
   * @param obj the object to find
   * @return true if object is in the tree, false otherwise
   */
  @Override
  public boolean present(T obj) {

    // If the tree is empty, the object is not in it
    if (this.root == null) {
      return false;
    }

    return this.root.present(obj);
  }

  /**
   * Returns the smallest object (defined by the ordering) in the tree, and null if the tree is
   * empty.
   *
   * @return the smallest object or null
   */
  @Override //TODO this aint rite dawg
  public T minimum() {

    // If the tree is empty, there is no minimum
    if (this.root == null) {
      return null;
    }
    // TODO I'm sure there is a better way to solve this but at least it compiles...
    return (T) this.root.minimum();
  }


  /**
   * Traverses the tree and returns printable data stored in each node.
   *
   * @return a printable representation of the tree
   */
  @Override
  public String toString() {
    return this.root.toString();
  }

  //TODO we can find the rank of an element p in the tree rooted at node T as follows:
  // If T contains p as its data, its rank in this tree is 1+size of left subtree of T.
  // If p is in the left subtree of T, then its rank in T would be whatever its rank is in the left
  // subtree of T.
  // If p is in the right subtree of T, then its rank in T would be whatever its rank in the right
  // subtree of T, plus the number of elements before it in T which is 1 + size of left subtree of T.
  // If T is an empty node, p is not present in the tree, so its rank cannot be computed. In this
  // case, return 0 as its rank.
  public int rank(T obj) { return 0; }

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
    return (T) empty; }
}
