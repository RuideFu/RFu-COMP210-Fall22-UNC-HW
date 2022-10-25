package assn03;

public class Main {

    public static void main(String[] args) {
//        LinkedList list = new LinkedList<Integer>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//
//        LinkedList list2 = new LinkedList();
//        list2.add(1);
//        list2.add(2);
//        list2.add(3);
//
//
//        System.out.println(list.isEqual(list2));

//        LinkedList list = new LinkedList<Integer>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(3);
//        list.add(2);
//        list.add(1);
//        System.out.println(list.isSymmetrical());

//        LinkedList list = new LinkedList<Integer>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.multiply(1);
//        System.out.println(list.toString());
//        list.multiply(0);
//        System.out.println(list.toString());

//        LinkedList list = new LinkedList<Integer>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        System.out.println(list.containsCycle());

        LinkedList list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        LinkedList list2 = new LinkedList();
        list2.add(4);
        list2.add(5);
//        list2.add(6);

        list.merge(list2);
        System.out.println(list.toString());

    }
}
