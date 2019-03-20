package bst;

public interface BSTNode <T extends Comparable<T>> {

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
   * @param present, the object to search for.
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


  // TODO remove this method before submitting
  T getData();

  //TODO
  int rank(T obj);

  //TODO
  T select(int rank);
}
