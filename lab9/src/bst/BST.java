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
  public void add(T obj);


  /**
   * Counts the number of objects in this data structre.
   *
   * @return the number of objects
   */
  public int getSize();


  /**
   * Iterates through the tree attempting to find the specified object.
   *
   * @param obj the object to find
   * @return true if object is in the tree, false otherwise
   */
  public boolean present(T obj);


  /**
   * Returns the smallest object (defined by the ordering) in the tree, and null if the tree is
   * empty.
   *
   * @return the smallest object or null
   */
  public java.lang.Object minimum();


  /**
   * Traverses the tree and returns printable data stored in each node.
   *
   * @return a printable representation of the tree
   */
  @Override
  String toString();

}
