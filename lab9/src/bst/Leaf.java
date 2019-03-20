package bst;

/**
 *  Leaf represents a node with no children in a binary search tree.
 */
public class Leaf<T extends Comparable<T>> implements BSTNode<T> {

  private T data;


  /** Creates a leaf in a binary search tree. It must be initialized with data to hold.
   *
   * @param data information to store in this node
   */
  public Leaf(T data){
    this.data = data;
  }


  /**
   * Inserts an object in the tree.
   *
   * @param object to insert
   */
  @Override
  public BSTNode add(T object) {

    System.out.println("Entered leaf node [" + this.data + "] with this input: " + object);
    BSTNode newNode = new Leaf(object);


    if (object.compareTo(this.data) < 0) {
      // Put the new object below to the left.
      System.out.println("Input is less than this node. Adding left: " + newNode.getData());
      BSTNode convertedLead = new ElementNode(this.data, newNode, null);
      return convertedLead;
    }

    else {
      // Put the new object below to the right.
//      System.out.println("Input is more than this node. Adding right: " + newNode.getData());
      BSTNode convertedLead = new ElementNode(this.data, null, newNode);
//      System.out.println("New node = " + newNode.getData());
//      System.out.println("ConvertedLead = " + convertedLead.getData());
      return convertedLead;
    }

  }

  /**
   * Return the size of this tree (i.e. the number of elements in this tree.
   *
   * @return the the number of elements in this tree.
   */
  @Override
  public int getSize() {
    System.out.println("Counting Leaf " + this.data);
    return 1;
  }

  /**
   * Returns true if this object is present in the tree, false otherwise.
   *
   * @param present@return true if this object is present in the tree, false otherwise.
   */
  @Override
  public boolean present(T present) {
    return (this.data.equals(present));
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
    return this.data;
  }


  /**
   * Represents a printable string with no fancy formatting, just the data that is stored.
   * @return
   */
  @Override
  public String toString(){
    return " " + this.data;
  }


  //TODO delete this before handing it in
  public T getData(){
    return this.data;
  }


}
