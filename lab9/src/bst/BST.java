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
   * Counts the number of objects in this data structure.
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
  T minimum();


  /**
   * Traverses the tree and returns printable data stored in each node.
   *
   * @return a printable representation of the tree
   */
  @Override
  String toString();

  /**
   * Finds the rank of an element in the tree. If the element does not exist in the tree, return 0.
   *
   * @param obj Element to find the rank of.
   * @return an int representing the rank of an element in the tree. If the element does not exist
   * in the tree, returns 0.
   */
  int rank(T obj);

  /**
   * Returns the object at a specific rank in the tree. If no object exists with the given rank,
   * return null as the result.
   *
   * @param rank of the object to return.
   * @return Object of the specified rank. If no object exists with given rank, return null.
   */
  T select(int rank);

}
