package bst;

/**
 * This class represents a node in the tree that isn't a leaf.
 * It has the capacity to contain 0-2 children nodes.
 * Node data must be Comparable as this node is part of a BST.
 */
public class ElementNode<T extends Comparable<T>> implements BSTNode<T> {

private T data;
private BSTNode<T> left;
private BSTNode<T> right;


  /** Creates a node in the tree that isn't a leaf- i.e., it has the capacity to have 0-2 children.
   *
   * @param data Information stored in the node
   * @param left left child
   * @param right right child
   */
  public ElementNode(T data, BSTNode<T> left, BSTNode<T> right) {

    this.data = data;
    this.left = left;
    this.right = right;

  }

  //TODO delete this method before handing in
  public T getData() {
    return this.data;
  }

  /**
   * Inserts an object in the tree.
   *
   * @param object to insert
   */
  @Override
  public BSTNode add(T object) {

    System.out.println("Entered BSTNode [" +this.data + "] add with input: " + object);

    // If object is less than current node, add to left
    if (object.compareTo(this.data) < 0) {
      System.out.println("Input is less than current node.");

      // If left exists, add it over there
      if (this.left != null ) {
        System.out.println(this.data + " node has a left child, which is " + left.getData());
        this.left = this.left.add(object);
        System.out.println("Returning " + this.data);
        return this;
      }

      // If left doesn't exist, make a new leaf and
      // put the object as this node's left child
      else {
        System.out.println(this.data + " node doesn't have a left child. Creating a new leaf.");
        BSTNode newNode = new Leaf(object);
        this.left = newNode;
        System.out.println("Returning " + this.data);
        return this;
      }

    }


    // Else, add to right
    else {
      System.out.println("Input is more than than current node.");

      if (this.right != null ) {
        System.out.println("This node has a right child. Going right >>>");
        this.right = this.right.add(object);
        return this;
      }

      else {
        BSTNode newNode = new Leaf(object);
        this.right = newNode;
        return this;
      }

    }

  }

  /**
   * Return the size of this tree (i.e. the number of elements in this tree)
   * by accumulating the number of nodes while traversing through tree.
   *
   * @return the the number of elements in this tree.
   */
  @Override
  public int getSize() {

    // Return the size of this plus the size of the right and left sub BSTs.
    if (this.left != null && this.right != null) {
      return this.left.getSize() + this.right.getSize() + 1;
    }
    else if (this.left != null) {
      return this.left.getSize() + 1;
    }
    else if (this.right != null) {
      return this.right.getSize() + 1;
    }
    else {
      return 1;
    }
  }

  /**
   * Returns true if this object is present in the tree, false otherwise.
   *
   * @param present
   * @return true if this object is present in the tree, false otherwise
   */
  @Override
  public boolean present(T present) {
    if (this.data.equals(present)) {
      return true;
    }
    else if (this.left != null && this.right != null) {
      return (this.left.present(present) | this.right.present(present));
    }
    else if (this.left!= null) {
      return this.left.present(present);
    }
    else if (this.right!= null) {
      return this.right.present(present);
    }
    else {
      return false;
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
  public T minimum() {
    if (this.left != null) {
      return this.left.minimum();
    }
    else {
      return this.data;
    }
  }


  /**
   * To string method that does a breadth-first list of element data.
   *
   * @return a printable representation of the tree
   */
  @Override
  public String toString() {

    if (this.left != null && this.right != null) {
      return " "+ this.data + this.left.toString() + this.right.toString();
    }

    else if ( this.left != null  ) {
      return " " + this.data + this.left.toString() ;

    }

    else if ( this.right != null ) {
      return " " + this.data + this.right.toString();
    }

    else {
      return " " + this.data;
    }

  }
}