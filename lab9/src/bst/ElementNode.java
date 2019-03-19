package bst;

public class ElementNode implements BSTNode {

private Integer data;
private BSTNode left;
private BSTNode right;


  /** TODO add this lol
   * @param data
   * @param left
   * @param right
   */
  public ElementNode(int data, BSTNode left, BSTNode right){

    this.data = data;
    this.left = left;
    this.right = right;

  }

  public Integer getData() {
    return this.data;
  }

  /**
   * Inserts an object in the tree.
   *
   * @param object to insert
   */
  @Override
  public BSTNode add(Integer object) {

    System.out.println("Adding a node: " + object);

    // If object is less than current node, add to left
    if (object < this.data) {

      // If left exists, add it over there
      if (this.left != null ) {
        System.out.println("Going left <<<");
        this.left = this.left.add(object);
        return this.left;
      }

      // If left doesn't exist, make a new leaf and
      // put the object as this node's left child
      else {
        BSTNode newNode = new Leaf(object);
        this.left = newNode;
        return this.left;
      }

    }
    // TODO can we use present() for this? Maybe in BSTImpl...
    // If we are adding something already in the tree, do nothing
//    if (this.data == object ) {
//      return this;
//    }

    // Else, add to right
    else {

      if (this.right != null ) {
        System.out.println("Going right>>>");
        this.right = this.right.add(object);
        return this.right;
      }

      else {
        BSTNode newNode = new Leaf(object);
        this.right = newNode;
        return this.right;
      }

    }

  }

  /**
   * Return the size of this tree (i.e. the number of elements in this tree.
   *
   * @return the the number of elements in this tree.
   */
  @Override
  public int getSize() {

    // TODO figure out why this isn't working....
    // Return the size of this plus the size of the right and left sub BSTs.
    if (this.left != null && this.right != null) {
      System.out.println("Counting left & right");
      return this.left.getSize() + this.right.getSize() + 1;}
    else if (this.left != null) {
      System.out.println("Counting left");
      return this.left.getSize() + 1; }
    else if (this.right != null) {
      System.out.println("Counting right");
      return this.right.getSize() + 1; }
    else {
      System.out.println("Counting 1");
      return 1; }
  }

  /**
   * Returns true if this object is present in the tree, false otherwise.
   *
   * @param present@return true if this object is present in the tree, false otherwise.
   */
  @Override
  public boolean present(int present) {
    if (this.data == present) {
      return true;
    }
    //TODO fix for null leafs...
    else {
      return (this.left.present(present) | this.right.present(present));
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
  public int minimum() {
    if (this.left != null) {
      return this.left.minimum();
    }
    else {
      return this.data;
    }
  }


  @Override
  public String toString(){

    if (this.left != null && this.right != null){
      return " !!"+ this.data.toString() + this.left.toString() + this.right.toString();

    }

    else if ( this.left != null  ) {
      return " _" + this.data.toString() + this.left.toString() ;

    }

    else {
      return " ?" + this.data.toString();
    }

//  return "HELLO";
  }

}
