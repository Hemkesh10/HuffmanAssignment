//package BinaryTrees;

public class TreeNode
{
  private HuffmanObjects item;
  private TreeNode leftChild;
  private TreeNode rightChild;

  public TreeNode(HuffmanObjects newItem)
  {
  // Initializes tree node with item and no children.
    item = newItem;
    leftChild  = null;
    rightChild = null;
  }  // end constructor

  public TreeNode(HuffmanObjects newItem , TreeNode left, TreeNode right) {
   item = newItem;
    leftChild = left;
    rightChild = right;
  }

  public HuffmanObjects getItem() {
    return item;
  }  // end getItem

  public void setItem(HuffmanObjects newItem) {
  // Sets the item field to the new value newItem.
    item = newItem;
  }  // end setItem

  public TreeNode getLeft(){
  // Returns the reference to the left child.
    return leftChild;
  }  // end getLeft

  public void setLeft(TreeNode left)
  {
  // Sets the left child reference to left.
    leftChild  = left;
  }  // end setLeft

  public TreeNode getRight()
  {
  // Returns the reference to the right child.
    return rightChild;
  }  // end getRight

  public void setRight(TreeNode right)
  {
  // Sets the right child reference to right.
    rightChild  = right;
  }  // end setRight

}  // end TreeNode