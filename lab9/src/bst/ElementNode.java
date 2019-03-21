package bst;

/**
 * This class represents a node in the tree that isn't a leaf. It has the capacity to contain 0-2
 * children nodes. Node data must be Comparable as this node is part of a BST.
 */
public class ElementNode<T extends Comparable<T>> implements BSTNode<T> {

  private T data;
  private BSTNode<T> left;
  private BSTNode<T> right;
  private int progeny;

  /**
   * Creates a node in the tree that isn't a leaf- i.e., it has the capacity to have 0-2 children.
   *
   * @param data  Information stored in the node
   * @param left  left child
   * @param right right child
   */
  public ElementNode(T data, BSTNode<T> left, BSTNode<T> right) {

    this.data = data;
    this.left = left;
    this.right = right;
    this.progeny = 2;

  }

  /**
   * Inserts an object in the tree.
   *
   * @param object to insert
   */
  @Override
  public BSTNode add(T object) {

    // Increase the number of progeny
    this.progeny += 1;

    // If object is less than current node, add to left
    if (object.compareTo(this.data) < 0) {
      // If left exists, add it over there
      if (this.left != null) {
        this.left = this.left.add(object);
        return this;
      }

      // If left doesn't exist, make a new leaf and
      // put the object as this node's left child
      else {
        BSTNode newNode = new Leaf(object);
        this.left = newNode;
        return this;
      }

    }


    // Else, add to right
    else {

      if (this.right != null) {
        this.right = this.right.add(object);
        return this;
      } else {
        BSTNode newNode = new Leaf(object);
        this.right = newNode;
        return this;
      }

    }

  }

  /**
   * Return the size of this tree (i.e. the number of elements in this tree) by accumulating the
   * number of nodes while traversing through tree.
   *
   * @return the the number of elements in this tree.
   */
  @Override
  public int getSize() {

    // Return the size of this plus the size of the right and left sub BSTs.
    if (this.left != null && this.right != null) {
      return this.left.getSize() + this.right.getSize() + 1;
    } else if (this.left != null) {
      return this.left.getSize() + 1;
    } else if (this.right != null) {
      return this.right.getSize() + 1;
    } else {
      return 1;
    }
  }

  /**
   * Returns true if this object is present in the tree, false otherwise.
   *
   * @return true if this object is present in the tree, false otherwise
   */
  @Override
  public boolean present(T present) {
    if (this.data.equals(present)) {
      return true;
    } else if (this.left != null && this.right != null) {
      return (this.left.present(present) | this.right.present(present));
    } else if (this.left != null) {
      return this.left.present(present);
    } else if (this.right != null) {
      return this.right.present(present);
    } else {
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
    } else {
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
      return " " + this.data + this.left.toString() + this.right.toString();
    } else if (this.left != null) {
      return " " + this.data + this.left.toString();

    } else if (this.right != null) {
      return " " + this.data + this.right.toString();
    } else {
      return " " + this.data;
    }

  }


  public int rank(T p) {


    // (1) If T contains p as its data, its rank in this tree is 1+size of left subtree of T.
    if (this.data == p) {

      if (this.left == null) {
        return 1;
      }

      return 1 + left.getSize();
    }

    // (2) If p is in the left subtree of T,
    // then its rank in T would be whatever its rank is in the left subtree of T.
    if (this.left != null ) {
      if (this.left.present(p)) {
        return left.rank(p);
      }
    }

    // (3) If p is in the right subtree of T, then its rank in T would be whatever its rank
    // in the right subtree of T, plus the number of elements before it in T which is 1 + size of
    // left subtree of T.

    if (this.right != null ) {
      if (this.right.present(p)) {

        // Get the size of the left  - it depends on if it exists or not!
        int leftSize;
        if (this.left == null) {
          leftSize = 0;
        } else {
          leftSize = left.getSize();
        }

        int numElementsBefore = 1 + leftSize;
        return numElementsBefore + right.rank(p);
      }
    }

    // (4) If T is an empty node, p is not present in the tree, so its rank cannot be computed.
    // In this case, return 0 as its rank.

    return 0;

  }

  public T select(int x) {

    // r = 1 + size of left subtree
    int r;

    // If the left subtree exists and has no children,
    // or it doesn't exist, its size is 0:
    if ( this.left == null || this.left.getProgeny() == 0 ) {
      r = 1;
    }

    else {
      r = 1 + this.left.getProgeny();
    }

    // If r is equal to x, then return the data at this node and exit
    if ( r == x ){
      return this.data;
    }

    // (3) If r<x, then element must be in right subtree of this
    // But its rank there would be x-r
    else if ( r < x ) {
      return this.right.select(x - r);
    }

    // (4) If r>x then the element of rank x must be in the left subtree of T.
    // So look for element of rank x in the left subtree of T.
    else if ( r > x ) {
      return this.left.select(x);
    }

    // If T is an empty node, the rank x is invalid. Return null as the result.
    else {
      return null;
    }

  }

  /**
   * Gets the size of the subtree of a node.
   * @return the size of the subtree this node.
   */
  public int getProgeny() { return this.progeny; }



}
