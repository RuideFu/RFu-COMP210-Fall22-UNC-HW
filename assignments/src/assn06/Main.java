package assn06;

public class Main {
    public static void main(String[] args) {

        // Create a new empty tree.
        SelfBalancingBST<Integer> avl_bst = new AVLTree<Integer>();

        // Insert 50 random integers.
        // Note how we need to capture the result of insert back into
        // the variable avl_bst because the post insertion root that is
        // returned might change because of the insertion

//        avl_bst.isEmpty();
//        avl_bst.insert(null);
//        avl_bst.height();
//        avl_bst.remove(null);
//        avl_bst.findMin();
//        avl_bst.findMax();
//        avl_bst.contains(null);
//        avl_bst.contains(1234);
//        avl_bst.getValue();
//        avl_bst.getLeft();
//        avl_bst.getRight();
//
//        for (int i=0; i<100; i++) {
//            avl_bst = avl_bst.insert((int) (Math.random()*100));
//            avl_bst.isEmpty();
//            avl_bst.insert(null);
//            avl_bst.height();
//            avl_bst.remove(null);
//            avl_bst.findMin();
//            avl_bst.findMax();
//            avl_bst.contains(null);
//            avl_bst.contains(1234);
//            avl_bst.getValue();
//            avl_bst.getLeft();
//            avl_bst.getRight();
//        }
//
//        for (int i=0; i<300; i++) {
//            avl_bst = avl_bst.remove((int) (Math.random()*100));
//            avl_bst.isEmpty();
//            avl_bst.insert(null);
//            avl_bst.height();
//            avl_bst.remove(null);
//            avl_bst.findMin();
//            avl_bst.findMax();
//            avl_bst.contains(null);
//            avl_bst.contains(1234);
//            avl_bst.getValue();
//            avl_bst.getLeft();
//            avl_bst.getRight();
//        }
//
//        avl_bst.isEmpty();
//        avl_bst.insert(null);
//        avl_bst.height();
//        avl_bst.remove(null);
//        avl_bst.findMin();
//        avl_bst.findMax();
//        avl_bst.contains(null);
//        avl_bst.contains(1234);
//        avl_bst.getValue();
//        avl_bst.getLeft();
//        avl_bst.getRight();

        avl_bst = avl_bst.insert((int) (20));
        avl_bst = avl_bst.insert((int) (11));
        avl_bst = avl_bst.insert((int) (50));
        avl_bst = avl_bst.insert((int) (4));
        avl_bst = avl_bst.insert((int) (6));
        avl_bst = avl_bst.insert((int) (15));
        avl_bst = avl_bst.insert((int) (3));
        avl_bst = avl_bst.insert((int) (16));
        avl_bst = avl_bst.insert((int) (17));
//        avl_bst = avl_bst.insert((int) (2));

        avl_bst = avl_bst.remove(20);
        avl_bst = avl_bst.remove(4);
        avl_bst = avl_bst.remove(3);

        avl_bst.getRight().getRight().getValue();

        System.out.println(avl_bst.height());

        // Now insert 50 integers in increasing order which would
        // cause a simple BST to become very tall but for our
        // self-balancing tree won't be too bad.

//        for (int i=0; i<10; i++) {
//            avl_bst = avl_bst.insert(i);
//        }
//
//        System.out.println(avl_bst.height());
    }
}