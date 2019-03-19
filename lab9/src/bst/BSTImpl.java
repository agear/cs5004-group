package bst;

/**
 * This class represents a binary search tree. It can add, it can get its size, it can detect
 * if an inputted object is present, and it can find the minimum object.
 */
public class BSTImpl implements BST {

  private BSTNode root;


  /**
   * Creates an empty BST.
   */
  public BSTImpl(){
    // Does nothing
  }

  /**
   * Adds a comparable object to the tree in its proper place.
   *
   * @param obj The object to put in the tree
   */
  @Override
  public void add(Integer obj) {
    System.out.println("Trying to add " + obj);

    // If the tree is empty, this object is the root node.
    if (this.root == null) {
      BSTNode newNode = new Leaf(obj);
      this.root = newNode;
      System.out.println("New root node. The root now is: " + this.root.getData());
      return;
    }
    // If the tree already contains the node, do nothing.
    if (this.root.present(obj)) {
      System.out.println(obj + " is already in the tree!");
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
  public Integer getSize() {

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
  public boolean present(Integer obj) {

    // If the tree is empty, the object is not in it
    if (this.root == null) {
      return false;
    }

    return this.root.present(obj);
  }

  /** Returns the smallest object (defined by the ordering) in the tree,
   * and null if the tree is empty.
   *
   * @return the smallest object or null
   */
  @Override
  public Integer minimum() {

    // If the tree is empty, there is no minimum
    if (this.root == null) {
      return null;
    }

    return this.root.minimum();
  }

  @Override
  public String toString() {
    return this.root.toString();
  }
}
