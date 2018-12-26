package TREE;

public class Main {
    public static void main(String[] args) {
        int array[] = {6, 2, 8, -3, 5, 12, 4, 9};
        BinarySearchTree<Integer> tree = new BinarySearchTreeImpl<>();
        for (int element : array) {
            tree.insert(element);
        }
        tree.print();
        System.out.println("kek");
        tree.contains(5);
        tree.printByLevels();        tree.remove(5);
        System.out.println(" ");
        tree.printByLevels();
    }
}