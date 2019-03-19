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
  public ElementNode(Integer data, BSTNode left, BSTNode right) {

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

    System.out.println("Entered BSTNode [" +this.data + "] add with input: " + object);

    // If object is less than current node, add to left
    if (object < this.data) {
      System.out.println("Input is less than current node.");

      // If left exists, add it over there
      if (this.left != null ) {
        System.out.println(this.data + " node has a left child, which is " + left.getData());
        this.left = this.left.add(object);
        System.out.println("Returning " + this.data);
        return this;
      }

      // If left doesn't exist, make a new leaf and
      // put the object as this node's left child
      else {
        System.out.println(this.data + " node doesn't have a left child. Creating a new leaf.");
        BSTNode newNode = new Leaf(object);
        this.left = newNode;
        System.out.println("Returning " + this.data);
        return this;
      }

    }


    // Else, add to right
    else {
      System.out.println("Input is more than than current node.");

      if (this.right != null ) {
        System.out.println("This node has a right child. Going right >>>");
        this.right = this.right.add(object);
        return this;
      }

      else {
        BSTNode newNode = new Leaf(object);
        this.right = newNode;
        return this;
      }

    }

  }

  /**
   * Return the size of this tree (i.e. the number of elements in this tree.
   *
   * @return the the number of elements in this tree.
   */
  @Override
  public Integer getSize() {

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
  public boolean present(Integer present) {
    if (this.data.equals(present)) {
      return true;
    }
    else if (this.left != null && this.right != null){
      return (this.left.present(present) | this.right.present(present));
    }
    else if (this.left!= null) { return this.left.present(present);}
    else if (this.right!= null) { return this.right.present(present);}
    else { return false; }
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
      return " !!"+ this.data//.toString()
              + this.left.toString() + this.right.toString();

    }

    else if ( this.left != null  ) {
      return " _" + this.data//.toString()
              + this.left.toString() ;

    }

    else if ( this.right != null ) {
      return " _" + this.data + this.right.toString();
    }

    else {
      return " ?" + this.data;//.toString();
    }

//  return "HELLO";
  }

  public Integer getRight() { return this.right.getData(); }
}
