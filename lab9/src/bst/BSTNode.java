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

  //TODO we can find the rank of an element p in the tree rooted at node T as follows:
  // If T contains p as its data, its rank in this tree is 1+size of left subtree of T.
  // If p is in the left subtree of T, then its rank in T would be whatever its rank is in the left
  // subtree of T.
  // If p is in the right subtree of T, then its rank in T would be whatever its rank in the right
  // subtree of T, plus the number of elements before it in T which is 1 + size of left subtree of T.
  // If T is an empty node, p is not present in the tree, so its rank cannot be computed. In this
  // case, return 0 as its rank.
  int rank(T obj);

  // TODO write javadoc
  T select(int rank);


}
