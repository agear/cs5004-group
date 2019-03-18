package bst;

public class Leaf implements BSTNode {

  private Integer data;


  /**
   * @param data TODO add
   */
  public Leaf(int data){
    this.data = data;
  }


  /**
   * Inserts an object in the tree.
   *
   * @param object to insert
   */
  @Override
  public BSTNode add(Integer object) {

    if (object < this.data) {
      // Put the new object below
      BSTNode newNode = new Leaf(object);
      BSTNode convertedLead = new ElementNode(this.data, newNode, null);
      return convertedLead;
    }

    else {
      // Put the new object below
      BSTNode newNode = new Leaf(object);
      BSTNode convertedLead = new ElementNode(this.data, null, newNode);
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
    return 1;
  }

  /**
   * Returns true if this object is present in the tree, false otherwise.
   *
   * @param present@return true if this object is present in the tree, false otherwise.
   */
  @Override
  public boolean present(int present) {
    return (this.data == present);
  }

  /**
   * Returns the smallest object (defined by the ordering) in the tree, and null if the tree is
   * empty.
   *
   * @return the smallest object (defined by the ordering) in the tree, and null if the tree is
   * empty.
   */
  @Override
  public int minimum() {
    return 0;
  }


  public String toString(){
    return " " + this.data.toString();
  }
}
