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

    // If the tree is empty, this object is the root node.
    if (this.root == null) {
      BSTNode newNode = new Leaf(obj);
      this.root = newNode;
      return;
    }
    // If the tree already contains the node, do nothing.
    if (this.root.present(obj)) {
      return;
    }

    this.root = this.root.add(obj);
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
  @Override
  public T minimum() {

    // If the tree is empty, there is no minimum
    if (this.root == null) {
      return null;
    }

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

  // TODO add javadoc
  public int rank(T obj) {

    return root.rank(obj);

  }


  /** TODO add javadoc
   * @param rank
   * @return
   */
  public T select(int rank) {

    return (T) root.select(rank);

  }
}
