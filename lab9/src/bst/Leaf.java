package bst;

public class Leaf implements BSTNode {

  private Integer data;


  /**
   * @param data TODO add
   */
  public Leaf(Integer data){
    this.data = data;
  }


  /**
   * Inserts an object in the tree.
   *
   * @param object to insert
   */
  @Override
  public BSTNode add(Integer object) {

    System.out.println("Entered leaf node [" + this.data + "] with this input: " + object);
    BSTNode newNode = new Leaf(object);

    if (object < this.data) {
      // Put the new object below to the left.
      System.out.println("Input is less than this node. Adding left: " + newNode.getData());
      BSTNode convertedLead = new ElementNode(this.data, newNode, null);
      return convertedLead;
    }

    else {
      // Put the new object below to the right.
      System.out.println("Input is more than this node. Adding right: " + newNode.getData());
      BSTNode convertedLead = new ElementNode(this.data, null, newNode);
      System.out.println("New node = " + newNode.getData());
      System.out.println("ConvertedLead = " + convertedLead.getData());
      System.out.println("New right = " + convertedLead.getRight());
      return convertedLead;
    }

  }

  /**
   * Return the size of this tree (i.e. the number of elements in this tree.
   *
   * @return the the number of elements in this tree.
   */
  @Override
  public Integer getSize() {
    System.out.println("Counting Leaf " + this.data);
    return 1;
  }

  /**
   * Returns true if this object is present in the tree, false otherwise.
   *
   * @param present@return true if this object is present in the tree, false otherwise.
   */
  @Override
  public boolean present(Integer present) {
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
  public Integer minimum() {
    return this.data;
  }


  @Override
  public String toString(){
  //return "HELLO";
  return "?? " + this.data;//.toString();
  }


  public Integer getData(){
    return this.data;
  }

  public Integer getRight() {return null;}
}
