package assn04;


public class Main {
  public static void main(String[] args) {
    /*
    This is a basic example of how to create a BST and add values to it.
    You should add more examples and use this class to debug your code
    */
    BST<Integer> bst = new NonEmptyBST<Integer>(8);

      bst = bst.insert(2);
      bst = bst.insert(15);
      bst = bst.insert(1);
      bst = bst.insert(4);
      bst = bst.insert(3);
      bst = bst.insert(6);
      bst = bst.insert(5);
      bst = bst.insert(7);
      bst = bst.insert(20);
      bst = bst.insert(10);
      bst.printBreadthFirstTraversal();
      System.out.println("sus");


  }

}
