package bst;


/**
 * This interface represents a Binary Search Tree of a generic object.
 */
public interface BST<T extends Comparable<T>> {


  /**
   * Adds a comparable object to the tree in its proper place.
   *
   * @param obj The object to put in the tree
   */
  void add(T obj);


  /**
   * Counts the number of objects in this data structre.
   *
   * @return the number of objects
   */
  int getSize();


  /**
   * Iterates through the tree attempting to find the specified object.
   *
   * @param obj the object to find
   * @return true if object is in the tree, false otherwise
   */
  boolean present(T obj);


  /**
   * Returns the smallest object (defined by the ordering) in the tree, and null if the tree is
   * empty.
   *
   * @return the smallest object or null
   */
  java.lang.Object minimum();


  /**
   * Traverses the tree and returns printable data stored in each node.
   *
   * @return a printable representation of the tree
   */
  @Override
  String toString();

  //TODO we can find the rank of an element p in the tree rooted at node T as follows:
  // If T contains p as its data, its rank in this tree is 1+size of left subtree of T.
  // If p is in the left subtree of T, then its rank in T would be whatever its rank is in the left
  // subtree of T.
  // If p is in the right subtree of T, then its rank in T would be whatever its rank in the right
  // subtree of T, plus the number of elements before it in T which is 1 + size of left subtree of T.
  // If T is an empty node, p is not present in the tree, so its rank cannot be computed. In this
  // case, return 0 as its rank.
  int rank(T obj);

  // TODO let size(T) be the size of the tree T. Then the element at a specific rank x in tree
  //  rooted at node T can be found as follows: Compute r=1+size of left subtree of T.
  //  If r=x then return the data at this node and exit.
  //  If r<x then the element of rank x must be in the right subtree of T. However its rank
  //  there would be x-r. So look for element of rank x-r in the right subtree of T.
  //  If r>x then the element of rank x must be in the left subtree of T. So look for element of
  //  rank x in the left subtree of T.
  //  If T is an empty node, the rank x is invalid. Return null as the result.
  T select(int rank);

}
