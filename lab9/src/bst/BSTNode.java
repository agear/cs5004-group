package bst;

/**
 * Interface to represent a Binary Search Tree Node of generic element type.
 * @param <T>
 */
public interface BSTNode<T extends Comparable<T>> {

  /**
   * Inserts an object in the tree.
   *
   * @param object to insert
   */
  BSTNode add(T object);

  /**
   * Return the size of this tree (i.e. the number of elements in this tree.
   *
   * @return the the number of elements in this tree.
   */
  int getSize();

  /**
   * Returns true if this object is present in the tree, false otherwise.
   *
   * @param present the object to search for.
   * @return true if this object is present in the tree, false otherwise.
   */
  boolean present(T present);

  /**
   * Returns the smallest object (defined by the ordering) in the tree, and null if the tree is
   * empty.
   *
   * @return the smallest object (defined by the ordering) in the tree, and null if the tree is
   * empty.
   */
  T minimum();

  /**
   * Finds the rank of an element in the tree. If the element does not exist in the tree, return 0.
   * @param obj Element to find the rank of.
   * @return an int representing the rank of an element in the tree.
   *  If the element does not exist in the tree, returns 0.
   */
  int rank(T obj);

  /**
   * Returns the object at a specific rank in the tree. If no object exists with the given rank,
   *  return null as the result.
   * @param rank of the object to return.
   * @return Object of the specified rank. If no object exists with given rank, return null.
   */
  T select(int rank);

  /**
   * Gets the size of the subtree of a node.
   * @return the size of the subtree this node.
   */
  int getProgeny();
}
